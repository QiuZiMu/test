import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Hello{
    String sayHello(String str);
    boolean saySignal(boolean b);
}

class HelloImpl implements Hello{

    @Override
    public String sayHello(String str) {
        return "HelloImpl "+str;
    }

    @Override
    public boolean saySignal(boolean b) {
        return b;
    }
}

class StaticProxiedHello implements Hello{
    private Hello hello=new HelloImpl();

    @Override
    public String sayHello(String str) {

        return hello.sayHello("静态代理执行"+str);
    }

    @Override
    public boolean saySignal(boolean b) {
        return hello.saySignal(b);
    }
}

class LogInvocationHandler implements InvocationHandler{
    private Hello hello;
    public LogInvocationHandler(Hello hello){
        this.hello=hello;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理执行"+method.getName());
        return method.invoke(hello,args);
    }
}

public class ProxyTest {
    public static void main(String[] args) {
        //静态代理
        StaticProxiedHello hello=new StaticProxiedHello();
        System.out.println(hello.sayHello("hello"));

        //动态代理
        Hello hello1=(Hello) Proxy.newProxyInstance(
                ProxyTest.class.getClassLoader(),
                new Class<?>[]{Hello.class},
                new LogInvocationHandler(new HelloImpl())
        );
        System.out.println(hello1.sayHello("hello1"));
        System.out.println(hello1.saySignal(true));

    }
}