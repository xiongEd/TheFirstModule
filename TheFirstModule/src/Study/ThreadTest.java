package Study;

public class ThreadTest {
    public static void main(String[] args) {
        //方法1
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "~~~线程执行啦！");
            }
        });
        t1.start();
        //方法2
        Thread t2 = new MyThread();
        t2.start();
    }
}


class MyThread extends Thread {
    @Override
    public void run() {
            System.out.println(Thread.currentThread().getName() + "~~~线程执行啦！");
    }
}
