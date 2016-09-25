package designPatterns.c23_TemplateMethod.sample01;

public class Transfer extends BankTemplateMethod
{
	public void transact()
	{
		System.out.println("转账");
	}
}