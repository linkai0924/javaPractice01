package testCode;

/**
 * Created by xiaokai on 2017/2/7.
 */
public class LeaderUs01 {

    public static void main(String[] args) {

        byte[][] array = new byte[10240][10240];
        Long begin = System.currentTimeMillis();
        int sum = 0;
        for (int i = 0; i < 10240; i++) {
            for (int j = 0; j < 10240; j++) {
                sum += array[j][i];
            }
        }

        Long end = System.currentTimeMillis();
        System.out.println("sum = " + sum + " time = " + (end - begin));
    }
}
