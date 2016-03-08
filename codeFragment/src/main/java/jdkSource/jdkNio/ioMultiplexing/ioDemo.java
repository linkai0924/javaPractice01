package jdkSource.jdkNio.ioMultiplexing;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xiaokai on 2016/3/2.
 */
public class ioDemo {

//    1 << 4;
    public static void main(String[] args){
        Map<Integer,String> integerStringMap=new HashMap<>();
        Map<Integer,String> integerStringMap2=integerStringMap;
        integerStringMap.put(1,"test1");
        integerStringMap.put(2,"test2");
        integerStringMap.put(3,"test3");

        System.out.println(integerStringMap);
        System.out.println(integerStringMap2);
        integerStringMap.remove(1);
        System.out.println(integerStringMap);

    }
}
