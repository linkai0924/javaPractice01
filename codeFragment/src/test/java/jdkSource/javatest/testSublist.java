package jdkSource.javatest;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaokai on 2016/12/1.
 */
public class testSublist {


    public static void main(String[]  args){
        List<Long> longs=new ArrayList<>();
        for(long i=1;i<=600;i++){
            longs.add(i);
        }
        List<Long> longs2=longs.subList(0,300);
        System.out.println(longs);
        System.out.println(longs2);

    }
}
