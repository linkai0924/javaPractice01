package designPatterns.c07_Adapter.sample01;

public class Client {
    public static void main(String args[]) {
        Robot robot = (Robot) XMLUtil.getBean();
        robot.cry();
        robot.move();
    }
}