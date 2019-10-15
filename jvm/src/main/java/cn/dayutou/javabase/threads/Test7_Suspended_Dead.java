package cn.dayutou.javabase.threads;


/**
 * 线程通信 -- notify 导致的假死模拟
 */
public class Test7_Suspended_Dead {
    /**
     * 用于线程间交互的锁
     */
    private static Object lock = new Object();
    /**
     * 存放生产的数据
     */
    private  static volatile int num = 1;
    /**
     * 是否生产完成
     */
    private  static volatile boolean producted = false;

    public static void main(String[] args) {
        new Thread(()-> {
            while(true){
                Producer.produce();
            }
        }).start();

        new Thread(()-> {
            while(true){
                Producer.produce();
            }
        }).start();

        new Thread(()-> {
            while(true){
                Consumer.consume();
            }
        }).start();

        new Thread(()-> {
            while(true){
                Consumer.consume();
            }
        }).start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * 生产者
     */
    private static class Producer{
        public static void produce(){
            synchronized (lock){
                if(producted){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    num++;
                    producted = true;
                    System.out.println( Thread.currentThread().getName() +  "生产：" + num);
                    lock.notify();
                }
            }
        }
    }

    /**
     * 生产者
     */
    private static class Consumer{
        public static void consume(){
            synchronized (lock){
                if(producted){
                    System.out.println( Thread.currentThread().getName() +  "消费：" + num);
                    producted = false;
                    lock.notify();
                }else{
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    //主要原因是：notify 没有指定哪一个线程激活
}

