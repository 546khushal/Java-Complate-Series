import java.util.Scanner;

public class palin {
    public static void main(String args[]) {
        int m, n;
        int sum = 0, rev = 0;
        int p, q;
        // m = 797;

        System.out.println("enter number=");
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        p = m;

        while (m != 0) {
            n = m % 10;
            sum = sum + n;
            m = m / 10;

        }
        System.out.println("sum=" + sum);

        int tmp = p;
        while (p != 0) {
            q = p % 10;

            rev = rev * 10 + q;
            p = p / 10;

        }
        System.out.println("reverse=" + rev);
        if (rev == tmp) {
            System.out.println("number is palindromp.....!!");

        } else {

            System.out.println("not palindromp....!!");
        }
    }

}
