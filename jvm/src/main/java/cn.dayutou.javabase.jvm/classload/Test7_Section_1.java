package cn.dayutou.javabase.jvm.classload;

/**
 * 第一部分结束练习
 *
 * 静态变量的申明顺序 对初始化结果的影响
 */
public class Test7_Section_1 {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        System.out.println( singleton1.counter1);
        System.out.println(singleton1.counter2);


        Singleton2 singleton2 = Singleton2.getInstance();
        System.out.println( singleton2.counter1);
        System.out.println(singleton2.counter2);
    }
}

class Singleton1{
    public static int counter1;
    public static int counter2 = 0;

    private static Singleton1 instance = new Singleton1();

    public Singleton1() {
        counter1++;
        counter2++;
    }


    public static Singleton1 getInstance() {
        return instance;
    }
}


class Singleton2{
    public static int counter1;


    private static Singleton2 instance = new Singleton2();

    public Singleton2() {
        counter1++;
        counter2++;
    }
    public static int counter2 = 0;


    public static Singleton2 getInstance() {
        return instance;
    }
}
