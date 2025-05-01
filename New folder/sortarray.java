import java.util.Scanner;

public class sortarray {
    public static void main(String[] args) {
        int a[], i, j;
        a = new int[5];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter array=");
        for (i = 0; i < a.length; i++) {
            a[i] = sc.nextInt();

        }
        for (i = 0; i < a.length; i++) {
            for (j = i + 1; j < a.length; j++) {
                int temp = 0;
                if (a[i] > a[j]) {
                    temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;

                }
            }

            System.out.println("sorted array=" + a[i]);

        }
    }

}
