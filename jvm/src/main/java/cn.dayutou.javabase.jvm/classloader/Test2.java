package cn.dayutou.javabase.jvm.classloader;


/**
 * 类加载器的加载机制
 *
 * 双亲委派
 * 组合关系
 */
public class Test2 {
    public static void main(String[] args) {
        /**
         * 获取类加载器的第二种方法
         */
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println(classLoader);
        while(classLoader != null){
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}
