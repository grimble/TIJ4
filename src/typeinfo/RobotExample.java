package typeinfo;

import java.util.*;
import java.lang.reflect.*;

interface Robot {
    public String getModel();
    public String getName();
    public static class Test {
        public static void describe(Robot r) {
            System.out.format(
                    "Robot\nModel:\t%s\nName:\t%s\n",
                    r.getModel(),
                    r.getName()
            );
        }
    }
}

class SnowRemover implements Robot {
    String model;
    String name;
    public SnowRemover(String model, String name) {
        this.model= model;
        this.name= name;
    }
    public String getModel() { return String.format("%s %s", getClass().getSimpleName(), model); }
    public String getName() { return name; }
}

class NullRobotProxyHandler implements InvocationHandler {
    Object proxied;
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        return method.invoke(proxied, args);
    }
    class NullRobot implements Robot {
        Class robotClass;
        public NullRobot(Class<? extends Robot> robotClass) { this.robotClass = robotClass; }
        public String getModel() { return "Null " + robotClass.getSimpleName(); }
        public String getName() { return "undefined"; }
    }
    public NullRobotProxyHandler(Class<? extends Robot> robotClass) { proxied= new NullRobot(robotClass); }
    public static Robot create(Class<? extends Robot> robotClass) {
        return (Robot)Proxy.newProxyInstance(
                NullRobot.class.getClassLoader(),
                new Class[] {Robot.class},
                new NullRobotProxyHandler(robotClass));
    }
}

public class RobotExample {

    public static void main(String []args) {

        System.out.println("Robot example");

        Robot bots[]= {
                new SnowRemover("SR001", "Snowball"),
                NullRobotProxyHandler.create(SnowRemover.class)
        };

        for(Robot r : bots)
            Robot.Test.describe(r);

    }
}