package cn.dayutou.javabase.jvm.load;

public class Test3 {
    public static void main(String[] args) {
        /**
         * 这里name3，是由MyParent3定义的变量，对于MyChild3是没有直接访问的。
         * 因此，不会触发对MyChild3的初始化
         */
        System.out.println(MyChild3.name3);
    }
}

class MyParent3{
    public  static   String name3 = "hello  MyParent3";
    static{
        System.out.println("MyParent3 static block");
    }
}

class MyChild3 extends MyParent3{
    public  static  String name2 = "hello  MyChild3";
    static{
        System.out.println("MyChild3 static block");
    }
}

