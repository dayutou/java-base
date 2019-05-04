package cn.dayutou.javabase.jvm.classload;

import java.util.UUID;

/**
 * 运行main，查看程序输出内容，并思考
 *
 */
public class Test4 {
    public static void main(String[] args) {
        System.out.println(MyParent4.str);
    }
}

class MyParent4{
    /**
     * str常量，编译期无法确定，只有运行时，才可以确定。
     * 因此，在程序运行时，会导致主动使用常量所在类（MyParent4），而导致类初始化
     */
    public static final String str = UUID.randomUUID().toString();

    static{
        System.out.println("MyParent4 static block");
    }
}
