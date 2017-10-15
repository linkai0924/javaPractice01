/**
 * Created by linkai on 2017/4/28.
 */
public class test {
    public static void main(String[] args){
        int size =100;
        for (int start = 0; true; start += size) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(start);
        }
    }
}
