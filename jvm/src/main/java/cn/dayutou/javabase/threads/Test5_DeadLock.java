package cn.dayutou.javabase.threads;


/**
 * 死锁-模拟演示
 *
 * jstack 进程ID
 */
public class Test5_DeadLock {

    public static void main(String[] args) {
        Task1 t1 = new Task1();
        Task2 t2 = new Task2();

        t1.setTask2(t2);
        t2.setTask1(t1);

        new Thread(() -> {
            while(true){
                t1.m1();
            }
        }).start();

        new Thread(() -> {
            while(true){
                t2.m2();
            }
        }).start();

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static class Task1{
        private Object lock = new Object();

        private Task2 task2;

        public void setTask2(Task2 task2) {

            this.task2 = task2;
        }

        public void m1(){
            synchronized (lock){
                task2.m1();
            }
        }

        public void m2(){
            synchronized (lock){
                System.out.println("task1 m2");
            }
        }
    }

    private static class Task2{
        private Object lock = new Object();

        private Task1 task1;

        public void setTask1(Task1 task1) {
            this.task1 = task1;
        }

        public void m1(){
            synchronized (lock){
                System.out.println("task2 m1");
            }

        }

        public void m2(){
            synchronized (lock){
                task1.m2();
            }
        }
    }
}




