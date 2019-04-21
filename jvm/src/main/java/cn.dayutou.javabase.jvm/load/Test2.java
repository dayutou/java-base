package cn.dayutou.javabase.jvm.load;

/**
 *测试常量
 */
public class Test2 {
    public static void main(String[] args) {
        /**
         * 反编译看下指令
         * 执行：javap -c Test2.class
         *
         * 注意ldc这条指令，它表示，从常量池取出常量（String hello  MyParent2），并压栈
         *++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
         * Compiled from "Test2.java"
         * public class cn.dayutou.javabase.jvm.load.Test2 {
         *   public cn.dayutou.javabase.jvm.load.Test2();
         *     Code:
         *        0: aload_0
         *        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
         *        4: return
         *
         *   public static void main(java.lang.String[]);
         *     Code:
         *        0: getstatic     #2                  // Field java/lang/System.out:Ljava/io/PrintStream;
         *        3: ldc           #4                  // String hello  MyParent2
         *        5: invokevirtual #5                  // Method java/io/PrintStream.println:(Ljava/lang/String;)V
         *        8: return
         * }
         */
        System.out.println(MyParent2.name2);
    }
}

class MyParent2{
    /**
     * 在编译阶段，name2 会存入到调用这个常量的方法（println）所在的类（Test2）的常量池中。
     * 本质上，调用类，并没有直接引用到定义常量的类（MyParent2），
     * 因此不会触发定义了常量的类（MyParent2）的初始化
     *
     * 在这个测试用例中，甚至可以将MyParent2.class文件删除，也是不影响运行的
     */
    public  static final String name2 = "hello  MyParent2";
    static{
        System.out.println("MyParent2 static block");
    }
}
