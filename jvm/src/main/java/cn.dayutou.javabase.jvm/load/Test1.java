package cn.dayutou.javabase.jvm.load;

/**
 * 静态类加载 ——— 主动引用
 */
public class Test1 {
    public static void main(String[] args) {
        System.out.println(MyParent1.name1);
    }
}

class MyParent1{
    public  static String name1 = "hello  MyParent1";
    static{
        System.out.println("MyParent1 static block");
    }
}
