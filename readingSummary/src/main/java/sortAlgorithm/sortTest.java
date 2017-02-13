package sortAlgorithm;

/**
 * Created by xiaokai on 2017/2/10.
 */
public class sortTest {

    public static void main(String[] args) {
        int[] a = {3, 1, 5, 7, 2, 4, 9, 6};
//        for(int i=0;i<n){
//
//        }

    }

    void InsertSort(int a[], int n) {
        for (int i = 0; i < n; i++) {
            if (a[i] < a[i - 1]) {
                int j = i - 1;
                int x = a[i];
                while (x < a[j]) {
                    a[j + 1] = a[j];
                }
            }

        }
    }
}
