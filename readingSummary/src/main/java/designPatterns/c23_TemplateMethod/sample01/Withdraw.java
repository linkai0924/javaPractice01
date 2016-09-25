package designPatterns.c23_TemplateMethod.sample01;

public class Withdraw extends BankTemplateMethod
{
	public void transact()
	{
		System.out.println("取款");
	}
}