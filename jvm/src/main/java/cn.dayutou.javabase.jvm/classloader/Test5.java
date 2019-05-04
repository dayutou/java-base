package cn.dayutou.javabase.jvm.classloader;

import java.io.*;
import java.util.ResourceBundle;

/**
 * 自定义类加载器-01
 */
public class Test5 extends ClassLoader {
    private String classLoaderName;

    private String path = "";
    private static final String fileExtension = ".class";

    public Test5( String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    public Test5(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = loadClassData(name);
        return this.defineClass(name,classData,0,classData.length);
    }

    public byte[] loadClassData(String name)  {
        InputStream inputStream = null;
        byte[] data = null;
        ByteArrayOutputStream outputStream = null;

        String className = name.replace(".","\\");
        try {
            inputStream = new FileInputStream(new File(this.path+ className + fileExtension));
            outputStream = new ByteArrayOutputStream();

            int ch = 0;
            while(-1 != (ch = inputStream.read())){
                outputStream.write(ch);
            }
            data = outputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }
        return data;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        test1();
        test2();
    }


    public static void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Test5 testLoader = new Test5("TestLoader");
        Class<?> clazz = testLoader.loadClass("cn.dayutou.javabase.jvm.classloader.Test1");
        Object ob = clazz.newInstance();
        System.out.println(ob);
        System.out.println(ob.getClass().getClassLoader());
    }

    public static void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Test5 testLoader = new Test5("TestLoader");
        //加载其他路径下的class文件
        testLoader.setPath("E:\\java_workspace\\java-data-structure\\target\\classes\\");
        Class<?> clazz = testLoader.loadClass("cn.wan.practice.tree.BST");
        Object ob = clazz.newInstance();
        System.out.println(ob);
        System.out.println(ob.getClass().getClassLoader());
    }
}
