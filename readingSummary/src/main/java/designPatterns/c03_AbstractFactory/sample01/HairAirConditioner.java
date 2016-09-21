package designPatterns.c03_AbstractFactory.sample01;

public class HairAirConditioner implements AirConditioner {
    public void changeTemperature() {
        System.out.println("海尔空调温度改变中......");
    }
}