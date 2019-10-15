package cn.dayutou.javabase.threads;


/**
 * 两个线程交替打印奇偶数
 */
public class Teat6_Printing_Odd_Even {

    public static void main(String[] args) {
        Printer printer = new Printer();

        Thread thread1 = new Thread(() -> {
            while(true){
                printer.printEven();
            }
        });

        Thread thread2 = new Thread(() -> {
            while(true){
                printer.printOdd();
            }

        });

        thread1.start();
        thread2.start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    private  static  class Printer  {
        private volatile int num = 1;

        private Object lock = new Object();

        public   void printOdd(){
            synchronized (lock){
                if(num % 2 == 1){
                    System.out.println(Thread.currentThread().getName() + "打印：" + num);
                    num++;
                }
                lock.notify();
            }
        }

        public synchronized void printEven(){
            synchronized (lock){
                if(num % 2 == 0){
                    System.out.println(Thread.currentThread().getName() + "打印：" + num);
                    num++;
                }
                lock.notify();
            }
        }
    }

}


