package designPatterns.c08_Bridge.sample01;

public class Client {
    public static void main(String a[]) {
        Color color;
        Pen pen;

        color = (Color) XMLUtilPen.getBean("color");
        pen = (Pen) XMLUtilPen.getBean("pen");

        pen.setColor(color);
        pen.draw("鲜花");
    }
}