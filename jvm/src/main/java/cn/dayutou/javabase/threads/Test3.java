package cn.dayutou.javabase.threads;

import java.util.Optional;
import java.util.stream.IntStream;

public class Test3 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() ->{
            IntStream.range(1,200).forEach(i -> System.out.println(Thread.currentThread().getName() + i));
        });

        Thread t2 = new Thread(() ->{
            IntStream.range(1,20).forEach(i -> System.out.println(Thread.currentThread().getName() + i));
        });

        t1.start();
        t1.join();

        t2.start();
        t2.join();

        Optional.of("All of tasks have finished").ifPresent(System.out::println);
    }
}
