package designPatterns.c10_Decorator.sample01;

public class Changer implements Transform
{
	private Transform transform;
	
	public Changer(Transform transform)
	{
		this.transform=transform;
	}
	
	public void move()
	{
		transform.move();	
	}
}