package aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main02 {
    public static int m=0;
    public static Lock lock=new ReentrantLock();
    public static void main(String[] args) throws Exception{
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