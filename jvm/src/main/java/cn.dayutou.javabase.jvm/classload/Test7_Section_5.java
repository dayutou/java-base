package cn.dayutou.javabase.jvm.classload;

/**
 * 使用并查看结果，思考
 */
public class Test7_Section_5 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = classLoader.loadClass("cn.dayutou.javabase.jvm.classload.CL");
        System.out.println(clazz);

        clazz = Class.forName("cn.dayutou.javabase.jvm.classload.CL");
        System.out.println(clazz);
    }
}

class CL{
    static{
        System.out.println("Class CL");
    }
}
