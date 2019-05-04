package cn.dayutou.javabase.jvm.classload;

/**
 * 执行main，看结果，并思考
 *
 * 追踪类加载顺序，并思考
 */
public class Test7_Section_2 {
    static{
        System.out.println("Test7_Section_2 static block");
    }

    public static void main(String[] args) {
        System.out.println(Child.b);
    }
}

class Parent{
    static int a = 3;
    static{
        System.out.println("Parent static block");
    }
}

class Child extends  Parent{
    static int b = 4;
    static{
        System.out.println("Child static block");
    }
}

