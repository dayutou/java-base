package cn.dayutou.javabase.jvm.classloader;

/**
 * 线程上下文加载器
 *
 * 获取类加载器的第三种方法
 */
public class Test3 {
    public static void main(String[] args) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        System.out.println(loader);
    }
}
