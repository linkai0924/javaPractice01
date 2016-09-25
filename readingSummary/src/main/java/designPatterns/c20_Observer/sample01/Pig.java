package designPatterns.c20_Observer.sample01;

public class Pig implements MyObserver
{
	public void response()
	{
		System.out.println("猪没有反应！");
	}
}