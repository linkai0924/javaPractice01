package main.java.effectiveJava.Chapter04;

import java.util.Arrays;

/**
 * 第16条 复合优先于继承
 * Created by xiaokai on 2015/12/4.
 */
public class item16 {
    /**
     * 继承是实现代码重用的有力手段，但并永远是最佳手段。
     * 在包的内部使用继承是非常安全的，在那里之类和超类的实现都处在同一个程序员的控制之下。
     * 对于专门为了继承而设计，并且具有很好的文档说明的类来说，使用继承也是非常安全的。
     * 然后对普通的具体类，进行跨越包边界的继承，则是非常危险的。
     */
    public static void main(String[] args){

        InstrumentedHashSet s = new InstrumentedHashSet();
        s.addAll(Arrays.asList("snap", "crackie", "pop"));
        System.out.println("---------"+s.getAddCount());
    }




}
