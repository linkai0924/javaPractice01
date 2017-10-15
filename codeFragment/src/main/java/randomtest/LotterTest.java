package randomtest;

import java.lang.reflect.Array;
import java.util.HashSet;

/**
 * Created by linkai on 2017/7/15.
 */
public class LotterTest {

    Long BaseUser = 11L;

    int[] redBoll = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33};
    int[] blueBoll = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    int[] myRedBoll = {2, 5, 9, 12, 22, 25};
    int[] myBlueBoll = {1, 4, 5};


    public static void main(String[] args) {
        int i = 0;
        HashSet<Integer> blueSet = new HashSet<Integer>();
        randomSet(1, 33, 6, blueSet);
        System.out.println(blueSet);
//        while (true) {
//            for () {
//
//            }
//
//
//        }
    }

    /**
     * 随机指定范围内N个不重复的数
     * 利用HashSet的特征，只能存放不同的值
     *
     * @param min              指定范围最小值
     * @param max              指定范围最大值
     * @param n                随机数个数
     * @param HashSet<Integer> set 随机数结果集
     */
    public static void randomSet(int min, int max, int n, HashSet<Integer> set) {
        if (n > (max - min + 1) || max < min) {
            return;
        }
        for (int i = 0; i < n; i++) {
            // 调用Math.random()方法
            int num = (int) (Math.random() * (max - min)) + min;
            set.add(num);// 将不同的数存入HashSet中
        }
        int setSize = set.size();
        // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小
        if (setSize < n) {
            randomSet(min, max, n - setSize, set);// 递归
        }
    }
}
