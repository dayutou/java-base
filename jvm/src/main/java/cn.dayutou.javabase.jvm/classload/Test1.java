package cn.dayutou.javabase.jvm.classload;

/**
 * 运行main，查看程序结果，并思考
 *
 * 静态类加载 ——— 主动引用
 *
 * jvm参数：
 * -XX:+<option>  开启option选项
 * -XX:-<option>  关闭option选项
 * -XX:<option>=<value>  对option赋值
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
