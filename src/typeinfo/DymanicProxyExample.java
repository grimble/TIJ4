package typeinfo;

import java.lang.reflect.*;

interface RealObjectInterface {
    void doSomething();
    void somethingElse(String arg);
}

class RealObject implements RealObjectInterface {
    public void doSomething() { System.out.println("doSomething"); }
    public void somethingElse(String arg) {
        System.out.println("somethingElse " + arg);
    }
}

class RealObjectProxy implements InvocationHandler {
    private Object proxied;
    public RealObjectProxy(Object proxied) {
        this.proxied = proxied;
    }
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(
                String.format(
                        "**** proxy: %s, method: %s, args: %s",
                        proxy.getClass().getSimpleName(), method,  args
                )
        );
        if(args != null)
            for(Object arg : args)
                System.out.println(" " + arg);
        return method.invoke(proxied, args);
    }
}

class RealObjectConsumer {
    public void consume(RealObjectInterface ro) {
        ro.doSomething();
        ro.somethingElse("blablabla");
    }
}

public class DymanicProxyExample {

    public static void main(String []args) {

        System.out.println("Hello World");

        RealObjectInterface rop= (RealObjectInterface)
                Proxy.newProxyInstance(
                        RealObjectInterface.class.getClassLoader(),
                        new Class[]{ RealObjectInterface.class },
                        new RealObjectProxy(new RealObject()));

        (new RealObjectConsumer()).consume(rop);

    }
}