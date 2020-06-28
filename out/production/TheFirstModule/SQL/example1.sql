1. --产品持有期状态变动通知（产品开放日提醒）---微信
PROCEDURE PROC_CPKFRTX(P_DATE DATE) IS --处理产品持有期状态变动通知（产品开放日提醒）
   v_date number;
BEGIN
  v_date:=TO_NUMBER(TO_CHAR(p_date,'yyyymmdd'));
  IF is_trd_date(p_date)='Y' THEN

    insert into WEIXIN_TEMPLATE_MSG
     (ID, TEMPLATE_CODE, ACCOUNT, CREATE_TIME, CONTENT, STATUS)
    select
      mot_seq1.nextval,
      'CPKFRTX',          --产品持有期状态变动通知（产品开放日提醒）
      LPAD(to_char(c.account),12,'0'),--资金账号
      sysdate,
      'first='||conver_url_encoding_utf8('产品开放日提醒：\n尊敬的'||a.user_name||'，小安温馨提示您的'||substr(lpad(to_char(c.account),12,'0'),9,4)||'账户有产品即将开放赎回业务！')
      ||'&'||'keyword1='||conver_url_encoding_utf8(b.fund_name)
      ||'&'||'keyword2='||conver_url_encoding_utf8('基金开放赎回业务')
      ||'&'||'keyword3='||conver_url_encoding_utf8(to_char(f.startdate,'yyyy-mm-dd'))
      ||'&'||'remark='||conver_url_encoding_utf8('信息如有变更，以管理人公告为准。'),
      0
      from choice.fund_bs_openday f ,
           trakgdb.funds b ,
           trakgdb.fund_vol c left join ridp_report.hist_fund_nav_vw d on c.FUND_INTL=d.fund_intl and d.TRD_DATE=v_date,
           trakgdb.users a
     where c.account IN (SELECT DISTINCT TO_NUMBER(zj_account) FROM svc_auto.t_weixin_customer)
       AND b.fund_intl=c.fund_intl
       and c.fund_bln>0
       and f.SECURITYCODE=b.fund_code
       and c.cust_code=a.user_code
       and f.tradetype='002'
       and f.eisdel='0'
       and f.startdate=to_date(to_char(get_trd_date_by_num(v_date,2)),'yyyymmdd') ;
    COMMIT;

    insert into WEIXIN_TEMPLATE_MSG
     (ID, TEMPLATE_CODE, ACCOUNT, CREATE_TIME, CONTENT, STATUS)
    select
      mot_seq1.nextval,
      'CPKFRTX',          --产品持有期状态变动通知（产品开放日提醒）
      LPAD(to_char(a.cuacct_code),12,'0'),--资金账号
      sysdate,
      'first='||conver_url_encoding_utf8('产品开放日提醒：\n尊敬的'||e.user_name||'，小安温馨提示您的'||substr(lpad(to_char(a.cuacct_code),12,'0'),9,4)||'账户有产品即将开放赎回业务！')
      ||'&'||'keyword1='||conver_url_encoding_utf8(c.inst_sname)
      ||'&'||'keyword2='||conver_url_encoding_utf8('基金开放赎回业务')
      ||'&'||'keyword3='||conver_url_encoding_utf8(to_char(to_date(to_char(b.open_end_date),'yyyymmdd'),'yyyy-mm-dd'))
      ||'&'||'remark='||conver_url_encoding_utf8('信息如有变更，以管理人公告为准。'),
      0
      from otcnewsett.otc_asset a left join trakgdb.users e on a.cust_code=e.user_code
                                 inner join otcts.otc_inst_open_info b on a.inst_sno=b.inst_sno
                                 inner join otcts.otc_inst_base_info c on a.inst_sno=c.inst_sno  and c.inst_type in ('J')
     where a.cuacct_code IN (SELECT DISTINCT TO_NUMBER(zj_account) FROM svc_auto.t_weixin_customer)
       AND a.inst_sno<>'906'
       and a.inst_bal>0
       and b.open_end_date=get_trd_date_by_num(v_date,4);
    COMMIT;

  END IF;
END;