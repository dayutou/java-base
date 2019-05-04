package cn.dayutou.javabase.jvm.classloader;

/**
 * 类加载器默认从哪里加载
 */
public class Test6 {
    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));

        System.out.println(System.getProperty("java.ext.dirs"));

        System.out.println(System.getProperty("java.class.path"));
    }
}


