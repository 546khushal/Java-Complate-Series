import java.util.Scanner;

public class arrayas {
    public static void main(String[] args) {
        int a[];
        a = new int[5];
        int count = 0, sum = 0;
        System.out.println("enter array=");
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < a.length; i++)

        {
            a[i] = sc.nextInt();
            if (a[i] % 2 == 0) {
                count++;
                System.out.println("array =" + a[i]);

            }
        }
        System.out.println("count=" + count);
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i];

        }

        System.out.println("sum is =" + sum);
    }

}
