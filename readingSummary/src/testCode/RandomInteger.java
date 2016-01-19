package testCode;

import java.util.Random;

/**
 * Created by xiaokai on 2016/1/8.
 */
public class RandomInteger {
    public static void main(String[] args) {
        Random randomGernerator = new Random();
        for (int i = 1; i <= 100; i++) {
            int randomint = randomGernerator.nextInt(i);
            System.out.println("randomint = " + randomint);
        }

    }
}
