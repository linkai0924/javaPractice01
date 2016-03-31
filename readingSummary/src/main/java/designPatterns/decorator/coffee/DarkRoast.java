package designPatterns.decorator.coffee;


import designPatterns.decorator.Beverage;

public class DarkRoast extends Beverage {

	public DarkRoast() {
		description = "DarkRoast";
	}

	public double cost() {
		return .99;
	}
}

