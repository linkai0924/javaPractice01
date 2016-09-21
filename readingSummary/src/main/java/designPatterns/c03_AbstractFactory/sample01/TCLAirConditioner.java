package designPatterns.c03_AbstractFactory.sample01;

public class TCLAirConditioner implements AirConditioner {
    public void changeTemperature() {
        System.out.println("TCL空调温度改变中......");
    }
}