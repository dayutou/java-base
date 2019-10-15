package cn.dayutou.javabase.threads;


/**
 * 创建启动线程
 */
public class Test1 {

    public static void main(String[] args) {
        readFromDataBase();
        writeDataToFile();

        new Thread("thread-1"){
            @Override
            public void run() {
                System.out.println("go ahead");
            }
        }.run();
    }



    private static void readFromDataBase(){
        try {
            println("Begin read data from db.");
            Thread.sleep(1000*10L);
            println("Read data done adn start handle it");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void writeDataToFile(){
        try {
            println("Begin write data to file");
            Thread.sleep(1000*20L);
            println("write data done  ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

     private static void println(String message){
         System.out.println(message);
     }
}
