package jmx.demo.helloworld;

/**
 * Created by xiaokai on 2016/1/20.
 */
public interface HelloMBean {
    public String getName();

    public void setName(String name);

    public void printHello();

    public void pringHelo(String theName);

}
