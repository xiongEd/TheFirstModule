package ProducerAndConsumer;

public class Producer extends Thread{
    //每次生产的数量
    private int num ;

    //所属的仓库
    private AbstractStorage abstractStorage;

    Producer(AbstractStorage abstractStorage){
        this.abstractStorage = abstractStorage;
    }

    void setNum(int num){
        this.num = num;
    }

    // 线程run函数
    @Override
    public void run()
    {
        produce(num);
    }

    // 调用仓库Storage的生产函数
    private void produce(int num)
    {
        abstractStorage.produce(num);
    }
}