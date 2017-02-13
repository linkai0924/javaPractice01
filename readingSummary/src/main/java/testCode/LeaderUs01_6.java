package testCode;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by xiaokai on 2017/2/7.
 */
public class LeaderUs01_6 {

    public static void main(String[] args) {
        //Arrays.parallelSort在数组超过多少时候才开启并行排序？采用位运算，给出推导过程
        int[] list = new int[100];
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            list[i] = random.nextInt(100);
        }
//        System.out.println(list);
        Arrays.parallelSort(list);
//        Arrays.sort(list);
//        System.out.println(list);
        System.out.println(Integer.valueOf(1 << 13));


    }
}
