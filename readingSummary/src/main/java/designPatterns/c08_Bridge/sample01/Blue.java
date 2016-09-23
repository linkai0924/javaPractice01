package designPatterns.c08_Bridge.sample01;

public class Blue implements Color {
    public void bepaint(String penType, String name) {
        System.out.println(penType + "蓝色的" + name + ".");
    }
}