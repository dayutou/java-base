package cn.dayutou.javabase.threads;

/**
 * 强制停止线程
 * 即便是blocked的情况，while死循环的情况
 */
public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        test2();
    }


    public static void test1() throws InterruptedException {
        Thread t = new Thread(new CannotStopService());
        t.start();

        Thread.currentThread().sleep(1000L);

        t.interrupt();
        System.out.println("执行了interrupt");
    }


    public static void test() throws InterruptedException {
        Thread t = new Thread(new CannotStopService());

        t.start();

        Thread.currentThread().sleep(1000L);

        t.interrupt();
        System.out.println("执行了interrupt");
    }

    private static class CannotStopService implements Runnable{
        int a = 1;
        @Override
        public void run() {
            while(true){
                System.out.println(">>>>>>" + a++);
            }
        }
    }

    /**
     * 可以强制停止
     * 利用 守护线程，跟随父线程停止的特点
     * @throws InterruptedException
     */
    public static void test2() throws InterruptedException {
        ThreadService t =  new ThreadService(new CannotStopService()) ;

        t.excute();

        Thread.currentThread().sleep(1000L);

        t.stop();
        System.out.println("线程终止了");
    }

    private static class  ThreadService  {

        private boolean finished ;
        private Thread excuteThread;

        private CannotStopService service;

        public ThreadService(CannotStopService service) {
            this.service = service;
            this.excuteThread = new Thread(()->{
                Thread damonThread = new Thread(service);
                damonThread.setDaemon(true);

                damonThread.start();

                try {
                    //等待
                    damonThread.join();
                    finished = true;
                } catch (InterruptedException e) {

                }
            });
        }


        public void excute() {
            excuteThread.start();
        }

        public void stop() {
            excuteThread.interrupt();
        }
    }

}

