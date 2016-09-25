package designPatterns.c20_Observer.sample01;

public class Mouse implements MyObserver
{
	public void response()
	{
		System.out.println("老鼠努力逃跑！");
	}
}