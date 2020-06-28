package LeetCode;
import java.util.*;

public class java1 {
    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public static void main(String[] args){
        char[][] a = {{'H','e','l','l','o',' ','w','o','r','l','d','!'},{'a','a'}};
        fun1(a);
        System.out.println("Hello world!" + a[1][1]);
        String b = "aaa";
        String c = b;
        String d;
        d = b;
        System.out.println(d);

        //创建ArrayList集合：
        List<String> list = new ArrayList<String>();
        System.out.println("ArrayList集合初始化容量："+list.size());

        //添加功能：
        list.add("Hello");
        list.add("world");
        list.add(2,"!");
        System.out.println("ArrayList当前容量："+list.size());

        //修改功能：
        list.set(0,"my");
        list.set(1,"name");
        System.out.println("ArrayList当前内容："+list.toString());

        //获取功能：
        String element = list.get(0);
        System.out.println(element);

        //迭代器遍历集合：(ArrayList实际的跌倒器是Itr对象)
        Iterator<String> iterator =  list.iterator();
        while(iterator.hasNext()){
            String next = iterator.next();
            System.out.println(next);
        }

        //for循环迭代集合：
        for(String str:list){
            System.out.println(str);
        }

        //判断功能：
        boolean isEmpty = list.isEmpty();
        boolean isContain = list.contains("my");

        //长度功能：
        int size = list.size();

        //把集合转换成数组：
        String[] strArray = list.toArray(new String[]{});

        //删除功能：
        list.remove(0);
        list.remove("world");
        list.clear();
        System.out.println("ArrayList当前容量："+list.size());

        List<Integer> temp = new ArrayList<Integer>();
        temp.add(2);
        temp.add(5);
        temp.add(6);
        temp.add(4);
        temp.add(1);
        for(Integer n:temp){
            System.out.println(n);
        }
        System.out.println(temp.size() + "!!!!!");
        System.out.println(temp.remove(temp.size() - 1) + "~~~");
        for(Integer n:temp){
            System.out.println(n);
        }

        String sd = new String("asdasfasf");
        System.out.println(sd);
        byte[]sd_byte = sd.getBytes();
        String sd2 = new String(sd_byte);
        System.out.println(sd.hashCode());
        System.out.println(sd2.hashCode());
        String sd3 = new String("asdasfasf");
        String sd4 = new String("asdasfasf");
        String sd5 = new String("asdasfasf");
        System.out.println();
        System.out.println(sd2.hashCode());
        System.out.println(sd3.hashCode());
        System.out.println(sd4.hashCode());
        System.out.println(sd5.hashCode());
        int[][]aaa = new int[5][5];
        for(int i = 0; i < 25; i++)
            aaa[i / 5][i%5] = i + 1;

        for(int[] re : aaa){
            for(int req : re)
                System.out.print(req + "  ");
            System.out.println();
        }
        System.out.println(aaa.length);
        boolean[] bool = new boolean[10];
        System.out.println(bool[5]);
        System.out.println(!bool[5]);

        char[][] chaR = {{'a','v','d','w'},{'t','e','m','p'}};
        String temp11;
        temp11 = new String(chaR[0]);
        System.out.println(temp11);
        System.out.println(new ArrayList<String>(Collections.singleton(new String(chaR[1]))));
        System.out.println(1e9);
        int[] aaax = new int[10];
        System.out.println(aaax[5]);
        String str12 = new String("101000100");
        char[] str13 = str12.toCharArray();
        System.out.println(str13);

        int x = 2,y,z;
        y = x&(x-1);
        z = x&(-x);
        System.out.println("y = "+ y + "    Z = "+z);

        String string = new String("abdhgASDFksaljdaaccccg");
        char[] stringc = string.toCharArray();
        Arrays.sort(stringc);
        for(char temp1 : stringc){
            System.out.print(temp1);
        }
        System.out.println();

        ArrayList<String>exd = new ArrayList<String>();
        exd.add(stringc.toString());
        String daf = stringc.toString();

        System.out.println(daf);
        System.out.println("111:____" + exd.get(0).toCharArray());
        stringc[0] = 'G';

        System.out.println(exd.get(0).toCharArray());


        int[] ints = {1,2,6,3,7,4,5};
        ArrayList<Integer> intsList = new ArrayList<Integer>();
        for (int dad : ints) intsList.add(dad);
        Collections.sort(intsList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int dad : intsList)
        System.out.print(dad);
        System.out.println();
        Integer integer = new Integer(0);
        System.out.println(ints[1]);
        int[] copy = ints.clone();
        System.out.println(copy[1]);
        func1(ints);
        System.out.println(ints[1]);
        System.out.println(copy[1]);
        boolean adsa = true;
        System.out.println(adsa);
        func2(adsa);
        System.out.println(adsa);

        int a4 = 4;
        System.out.println(a4);
        int a5 = a4 << 1;
        System.out.println(a5);
        boolean dads;
        ListNode LNa = new ListNode(0);
        ListNode LNb = new ListNode(1);
        ListNode LNc = new ListNode(2);
        ListNode LNd = new ListNode(3);
        ListNode LNe = new ListNode(4);
        ListNode LNf = new ListNode(5);
        LNa.next = LNb;
        LNb.next = LNc;
        LNc.next = LNd;
        LNd.next = LNe;
        LNe.next = LNf;
        LNf.next = LNb;

        int[]a2 = {1,2,3,4,5,5345,5346,2131,423,5435,32423,2352,4234,545,4234,234};
        int[]a3 = {1,2,3,4,5,5345,5346,2131,423,5435,32423,2352,4234,545,4234,234};
        System.out.println(Arrays.hashCode(a2));
        System.out.println(Arrays.hashCode(a3));

        int[]asdaf1 = {2,4,4,5,6,7,7};
        int[]asdaf2 = asdaf1;
        asdaf1[1] = 5;
        System.out.println(asdaf2[1]);

        int dada = (int) (1e9 + 7);
        System.out.println(Math.log(1e9 + 7) / Math.log(3));
        System.out.println(Math.pow(3, 333));




    }
    public static void func1(int[] a){
        a[1] = 10;
    }
    public static void func2(boolean a){
        a = false;
    }

    public static void fun1(char[][]a){
        a[1][1] = 'A';
    }
}
