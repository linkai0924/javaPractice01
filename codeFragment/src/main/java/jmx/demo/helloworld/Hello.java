package jmx.demo.helloworld;

/**
 * Created by xiaokai on 2016/1/20.
 */
public class Hello implements HelloMBean {

    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printHello() {
        System.out.println("Hello " + name);
    }

    @Override
    public void pringHelo(String theName) {
        System.out.println("Hello " + theName);
    }
}
