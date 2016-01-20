package main.java.testCode;

import org.junit.Test;

/**
 * Created by xiaokai on 2015/12/17.
 */
public class RefactorClass  {

    public static void main(String[] args) {

    }

    @Test
    public void print() throws Exception{
        String name="Tom";
        int age = new Person().invoke();
        System.out.println("name "+name+",age "+age);
    }

    private class Person {
        public int invoke() {
            return 10;
        }
    }
}
