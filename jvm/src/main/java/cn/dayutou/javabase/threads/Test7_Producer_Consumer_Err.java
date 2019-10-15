package cn.dayutou.javabase.threads;


/**
 * 错误的生产消费
 * 将 Test7_Suspended_Dead 其他代码不变，将notify 换成notifyAll
 */
public class Test7_Producer_Consumer_Err {
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
                Test7_Producer_Consumer_Err.Producer.produce();
            }
        }).start();

        new Thread(()-> {
            while(true){
                Test7_Producer_Consumer_Err.Consumer.consume();
            }
        }).start();

        new Thread(()-> {
            while(true){
                Test7_Producer_Consumer_Err.Consumer.consume();
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
                if(producted){
                    System.out.println( Thread.currentThread().getName() +  "消费：" + num);
                    producted = false;
                    lock.notifyAll();
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

    //可以看到重复消费的情况

    //为什么？

    //因为  if(producted){
}
