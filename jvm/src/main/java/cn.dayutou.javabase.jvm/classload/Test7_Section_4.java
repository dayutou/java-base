package cn.dayutou.javabase.jvm.classload;


/**
 * 使用并查看结果，思考
 */
public class Test7_Section_4 {

    public static void main(String[] args) {
        System.out.println(Child7_4.a);
        Child7_4.doSomething();
    }
}


class Parent7_4{
    static int a = 3;
    static{
        System.out.println("Parent7_4 static block");
    }

    static void doSomething(){
        System.out.println("doSomething");
    }
}

class Child7_4 extends  Parent7_4{
    static{
        System.out.println("Child7_4 static block");
    }
}