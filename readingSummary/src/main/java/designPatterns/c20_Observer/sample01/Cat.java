package designPatterns.c20_Observer.sample01;

public class Cat extends MySubject
{
	public void cry()
	{
		System.out.println("猫叫！");
		System.out.println("----------------------------");		
		
		for(Object obs:observers)
		{
			((MyObserver)obs).response();
		}
		
	}	   	
}