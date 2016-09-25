package designPatterns.c20_Observer.sample01;

public class Dog implements MyObserver
{
	public void response()
	{
		System.out.println("狗跟着叫！");
	}
}