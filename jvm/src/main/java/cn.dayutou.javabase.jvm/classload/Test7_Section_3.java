package cn.dayutou.javabase.jvm.classload;

/**
 * 执行main、查看结果并思考
 *
 */
public class Test7_Section_3 {
    static{
        System.out.println("Test7_Section_3 static block");
    }

    public static void main(String[] args) {
        Parent7_3 parent = null;
        System.out.println("-----------------------------");
        parent = new Parent7_3();
        System.out.println("-----------------------------");
        System.out.println(parent.a);
        System.out.println("-----------------------------");
        System.out.println(Child7_3.b);
    }
}

class Parent7_3{
    static int a = 3;
    static{
        System.out.println("Parent7_3 static block");
    }
}

class Child7_3 extends  Parent7_3{
    static int b = 4;
    static{
        System.out.println("Child7_3 static block");
    }
}