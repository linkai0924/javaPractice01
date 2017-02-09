package testCode;

import java.util.*;

/**
 * Created by xiaokai on 2017/2/8.
 */
public class Salary {
    String name;
    int baseSalary;
    int bonus;

    public static void main(String[] args) {
        Random random = new Random();
        List<Salary> salaryList = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Salary salary = new Salary();
            salary.baseSalary = random.nextInt(100) % (100 - 5 + 1) + 5;
            salary.bonus = random.nextInt(10);
            salary.name = getRandomString(5);
            salaryList.add(salary);
        }

        long begin = System.currentTimeMillis();
        Collections.sort(salaryList, new Comparator<Salary>() {
            @Override
            public int compare(Salary o1, Salary o2) {
                if ((o1.baseSalary * 13 + o1.bonus) > (o2.baseSalary * 13 + o2.bonus)) {
                    return -1;
                } else if ((o1.baseSalary * 13 + o1.bonus) < (o2.baseSalary * 13 + o2.bonus)) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        System.out.println("used time = " + (System.currentTimeMillis() - begin));
        for (int i = 0; i < 10; i++) {
            System.out.println(salaryList.get(i).name);
        }
    }

    static String getRandomString(int length) {
        String base = "abcdefghijklmnopqrstuvwxyz";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
}
