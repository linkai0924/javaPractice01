package designPatterns.c08_Bridge.sample01;

public class Green implements Color {
    public void bepaint(String penType, String name) {
        System.out.println(penType + "绿色的" + name + ".");
    }
}