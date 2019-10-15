package cn.dayutou.javabase.threads;

public class Test7_Producer_Consumer {
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
                Test7_Producer_Consumer.Producer.produce();
            }
        }).start();

        new Thread(()-> {
            while(true){
                Test7_Producer_Consumer.Producer.produce();
            }
        }).start();

        new Thread(()-> {
            while(true){
                Test7_Producer_Consumer.Consumer.consume();
            }
        }).start();

        new Thread(()-> {
            while(true){
                Test7_Producer_Consumer.Consumer.consume();
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
                while (producted){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                {
                    num++;
                    producted = true;
                    System.out.println( Thread.currentThread().getName() +  "生产：" + num);
                    lock.notifyAll();
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
                while(! producted){
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println( Thread.currentThread().getName() +  "消费：" + num);
                producted = false;
                lock.notifyAll();

            }
        }
    }

}
