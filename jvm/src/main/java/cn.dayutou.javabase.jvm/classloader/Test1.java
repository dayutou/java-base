package cn.dayutou.javabase.jvm.classloader;

/**
 * 类加载器 - 获取的第一种方法
 */
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz.getClassLoader());

        Class<?> clazz2 = Class.forName("cn.dayutou.javabase.jvm.classloader.c");
        System.out.println(clazz2.getClassLoader());
    }
}

class c{

}
