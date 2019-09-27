package aqs;

import java.util.concurrent.locks.Lock;

public class Main04{
    private static int m=0;
    private static Lock lock=new MLock01();
    public static void main(String[] args) throws InterruptedException{
        Thread[] threads=new Thread[100];
        for(int i=0;i<threads.length;i++){
            threads[i] = new Thread(() -> {
                try{
                    lock.lock();
                    for (int j = 0; j < 1000; j++) m++;
                }finally {
                    lock.unlock();
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
