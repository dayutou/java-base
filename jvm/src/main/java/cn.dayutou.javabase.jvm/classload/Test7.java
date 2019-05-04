package cn.dayutou.javabase.jvm.classload;

/**
 * 执行查看结果
 *
 * 关于父接口的初始化
 */
public class Test7 {
    public static void main(String[] args) {
        //System.out.println(MyChild7A.b);
        //System.out.println(MyChild7b.b);
        System.out.println(MyParent7C.b);
    }
}


class MyParent7A{
    static  int a = 5 / 0;
}

class MyChild7A extends MyParent7A{
    static int b = 1;
}

/*****************************************************************/

interface MyParent7B{
    int a = 5 / 0;
}

interface MyChild7b extends MyParent7B{
    static int b = 5;
}

class MyParent7C implements MyParent7B{
    static int b = 1;
}


/**
 *结论:
 * 当一个类在初始化时，并不要求其父接口初始化；
 * 当一个接口在初始化时，并不要求其父接口初始化
 * 只有真正使用到父接口时（如：引用接口内部常量），才会初始化
 * */