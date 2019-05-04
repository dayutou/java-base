package cn.dayutou.javabase.jvm.classloader;

/**
 * 数组类型的classloader
 */
public class Test4 {
    public static void main(String[] args) {
        long[] long1 = new long[10];
        System.out.println(long1.getClass().getClassLoader());

        Long[] longs = new Long[10];
        System.out.println(longs.getClass().getClassLoader()); 

        Person4[] persons = new Person4[1];
        System.out.println(persons.getClass().getClassLoader());
    }
}

class Person4{

}

/**
 * 数组类型，并不是有类加载器加载的，而是由JVM自动加载的
 * 数组类型获取getClassLoader，返回值和元素类型加载器一致
 */
