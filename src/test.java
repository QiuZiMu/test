import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class test {
    private static ConcurrentHashMap<Integer,Integer> concurrentHashMap=new ConcurrentHashMap<>();
    private static AtomicInteger m=new AtomicInteger(0);
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(()->{
            for (int i = 0; i < 100; i++) {
                concurrentHashMap.put(Integer.valueOf(i), m.addAndGet(1));
            }
        });
        Thread thread1=new Thread(()->{
            for (int i = 0; i < 100; i++) {
                concurrentHashMap.put(Integer.valueOf(i), m.addAndGet(2));
            }
        });
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
        System.out.println(m);
        System.out.println(concurrentHashMap.values());
    }
}
