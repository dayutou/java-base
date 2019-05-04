package cn.dayutou.javabase.jvm.classload;

/**
 * 理解类加载时机
 *
 */
public class Test8{
    public static void main(String[] args) {
        System.out.println(MyChild8.name1);
    }
}

class MyParent8{
    public  static String name1 = "hello  MyParent8";
    static{
        System.out.println("MyParent8 static block");
    }
}


/**
 * 并不需要等到被首次主动使用时，才加载。
 * JVM规范中，允许预加载。
 * 且如果在加载中遇到错误（如：类缺失），必须在首次主动使用时，报错。
 * 这意味着，如果类一直未使用，则不报错。
 */
class MyChild8 extends MyParent8{
    static{
        System.out.println("MyChild8 static block");
    }
}

