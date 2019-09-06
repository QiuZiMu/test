/**
 * 懒汉式模式上加入双重检测和volatile(防止指令重排导致其他线程能访问到未初始化的对象)
 */
public class DclTest {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println(DoubleCheckingLocking.getInstance());
        });
        t.start();
        System.out.println(DoubleCheckingLocking.getInstance());
    }
}

class DoubleCheckingLocking{
    private static volatile DoubleCheckingLocking instance;
    private DoubleCheckingLocking(){
    }
    public static DoubleCheckingLocking getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (DoubleCheckingLocking.class) {
            if (instance == null) {
                instance = new DoubleCheckingLocking();
            }
            return instance;
        }
    }
}
