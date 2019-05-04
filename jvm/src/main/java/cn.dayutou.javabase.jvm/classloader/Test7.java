package cn.dayutou.javabase.jvm.classloader;


import sun.misc.Launcher;

/**
 * 扩展类加载器、系统类加载器的类型，是由谁加载的
 */
public class Test7 {
    public static void main(String[] args) {
        System.out.printlConnectn(ClassLoader.class.getClassLoader());
        System.out.println(Launcher.class.getClassLoader());
    }
}


/**
 * 內建于JVM的启动类加载器会加载java.lang.ClassLoader以及其他的Java平台类
 *
 * 启动类加载器 不是java类。
 * 其他的所有类加载器，都是java类。
 */