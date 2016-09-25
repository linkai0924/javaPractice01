package designPatterns.c23_TemplateMethod.sample01;

public class Deposit extends BankTemplateMethod
{
	public void transact()
	{
		System.out.println("存款");
	}
}