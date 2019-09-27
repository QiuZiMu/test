package aqs;

public class Main01 {
    public static int m=0;

    public static void main(String[] args) throws Exception{
        Thread[] threads=new Thread[100];
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(() -> {
                synchronized (Main01.class) {  //锁class对象
                    for (int j = 0; j < 1000; j++) m++;
                }
            });
        }
        for(Thread t:threads){
            t.start();
        }

        for(Thread t:threads){
            t.join();
        }
        System.out.println(m);
    }
}
