package designPatterns.c06_Builder.sample01;

public class SubMealBuilderA extends MealBuilder {
    public void buildFood() {
        meal.setFood("一个鸡腿堡");
    }

    public void buildDrink() {
        meal.setDrink("一杯可乐");
    }
}