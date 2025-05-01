import java.util.Scanner;

public class prime {
    public static void main(String[] args) {
        int a, b, i, j, temp = 0;
        Scanner sc = new Scanner(System.in);
        System.out.print("enter a value=");
        a = sc.nextInt();
        System.out.print("enter b value=");

        b = sc.nextInt();
        for (i = a; i <= b; i++) {
            for (j = 1; j <= i; j++) {
                if (i % j == 0) {
                    temp++;

                }
            }

            if (temp == 2) {
                System.out.println(i);

            }
            temp = 0;
        }
    }

}
