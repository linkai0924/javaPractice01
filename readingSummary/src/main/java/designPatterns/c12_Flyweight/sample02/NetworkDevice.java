package designPatterns.c12_Flyweight.sample02;

public interface NetworkDevice {
    public String getType();

    public void use(Port port);
}