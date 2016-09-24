package designPatterns.c16_Interpreter;

public class ValueNode implements Node
{
	private int value;
	
	public ValueNode(int value)
	{
		this.value=value;
	}
		
	public int interpret()
	{
		return this.value;
	}
}