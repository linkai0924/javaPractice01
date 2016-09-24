package designPatterns.c10_Decorator.sample01;

public class Client
{
	public static void main(String args[])
	{
		Transform camaro;
		camaro=new Car();
		camaro.move();
		System.out.println("-----------------------------");
		
		Airplane bumblebee=new Airplane(camaro);
		bumblebee.move();
		bumblebee.fly();
	}
}