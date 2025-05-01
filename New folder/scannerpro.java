import java.util.Scanner;

class scannerpro {
    public static void main(String args[]) {
        System.out.println("enter your name");
        Scanner sc = new Scanner(System.in);

        System.out.println("enter first");
        String a = sc.nextLine();

        System.out.println("enter second");
        String b = sc.nextLine();

        System.out.println(a + " " + b);

    }
}