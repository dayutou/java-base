package cn.dayutou.javabase.jvm.classload;

/**
 * 运行main，查看程序输出内容，并思考
 */
public class Test5 {
    public static void main(String[] args) {
        /**
         * 首次主动使用
         */
        System.out.println(new MyParent5());
        /**
         * 主动使用
         */
        System.out.println(new MyParent5());
    }
}


class MyParent5{
    static{
        System.out.println("MyParent5 static block");
    }
}