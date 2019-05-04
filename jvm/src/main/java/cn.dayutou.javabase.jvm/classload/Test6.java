package cn.dayutou.javabase.jvm.classload;

/**
 * 运行main，查看程序输出内容，并思考
 */
public class Test6 {
    public static void main(String[] args) {
        /**
         * 数组
         */
        MyParent6[] myParent6s = new MyParent6[1];
        System.out.println(myParent6s.getClass());

        MyParent6[][] myParent_2 = new MyParent6[1][1];
        System.out.println(myParent_2.getClass());
    }
}


class MyParent6{
    static{
        System.out.println("MyParent6 static block");
    }
}

/**
 * 数组实例，其类型是JVM在运行期动态生成，
 * 表示为 [Lcn.dayutou.javabase.jvm.classload.MyParent6
 *       [[Lcn.dayutou.javabase.jvm.classload.MyParent6;
 * 这种形式，其父类形式Object
 * 用[表示维度
 *
 * 助记符：
 * anewarray：表示创建一个引用类型数组
 * newarray： 表示创建一个原始类型数组
 *
 */
