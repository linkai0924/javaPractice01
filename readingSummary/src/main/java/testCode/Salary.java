package testCode;

import java.util.Random;

/**
 * Created by xiaokai on 2017/2/8.
 */
public class Salary {
    String name;
    int baseSalary;
    int bonus;

    public static void main(String[] args) {
        Random random = new Random();
        Salary salary = new Salary();
        salary.baseSalary = random.nextInt(100) % (100 - 5 + 1) + 5;
        salary.bonus = random.nextInt(10);

        System.out.println();
    }
}
