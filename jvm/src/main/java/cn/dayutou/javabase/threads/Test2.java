package cn.dayutou.javabase.threads;


import sun.security.krb5.internal.TicketFlags;

/**
 * 银行叫号模拟
 * 讲解Runnable的作用
 *
 *
 * 面向对象，分离执行单元和业务逻辑单元。策略模式
 */
public class Test2 {

    public static void main(String[] args) {
        //Bank1.go();
        Bank2.go();
    }

    /**
     * 采用两个Thread子类实现
     */
    private static class Bank1{
        public static void go(){
            new Ticket1().start();
            new Ticket2().start();
        }
    }

    /**
     * 采用两个Thread，执行实现Runnable接口的叫号器
     */
    private static class Bank2{
        public static void go(){
            Ticket3 t = new Ticket3();
           new Thread(t).start();
           new Thread(t).start();
        }
    }


    /**
     * 柜台叫号器1
     */
    private static class Ticket1 extends Thread{
        private final int MAX_NUM = 50;

        private int num = 1;
        @Override
        public void run() {
            while(num < 50){
                System.out.println("当前号码：" + num + "当前叫号器：" + this.getName());
                num ++;
            }
        }
    }

    /**
     * 柜台叫号器2
     */
    private static class Ticket2 extends Thread{
        private final int MAX_NUM = 50;

        private int num = 1;
        @Override
        public void run() {
            while(num < 50){
                System.out.println("当前号码：" + num + "当前叫号器：" + this.getName());
                num ++;
            }
        }
    }


    /**
     * 采用 实现Runnable接口，的叫号器
     */
    private static class Ticket3 implements  Runnable{
        private final int MAX_NUM = 50;

        private int num = 1;

        public void run() {
            while(num < 50){
                System.out.println("当前号码：" + num + "当前叫号器：" + Thread.currentThread().getName());
                num ++;
            }
        }
    }

}




