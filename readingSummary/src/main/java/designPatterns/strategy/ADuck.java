package designPatterns.strategy;


import designPatterns.strategy.fly.FlyNoWay;
import designPatterns.strategy.fly.FlyWithWings;
import designPatterns.strategy.quack.MuteQuack;
import designPatterns.strategy.quack.Squeak;

public class ADuck extends Duck {
	public ADuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Squeak();
	}

	public void display() {
		System.out.println("I'm a duck model.");
	}

	public void changeBehavior() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}

	public static void main(String[] args) {
		ADuck aDuck = new ADuck();
		aDuck.display();
		aDuck.swim();
		aDuck.performFly();
		aDuck.performQuack();
		aDuck.changeBehavior();
		aDuck.performFly();
		aDuck.performQuack();
	}
}
