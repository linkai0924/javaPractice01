package designPatterns.c10_Decorator.sample01;

public final class Car implements Transform
{
	public Car()
	{
		System.out.println("变形金刚是一辆车！");
	}
	
	public void move()
	{
		System.out.println("在陆地上移动！");
	}
}