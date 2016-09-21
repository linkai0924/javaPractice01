package designPatterns.c03_AbstractFactory.sample01;

public interface EFactory {
    public Television produceTelevision();

    public AirConditioner produceAirConditioner();
}