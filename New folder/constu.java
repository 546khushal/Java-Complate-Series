import java.util.Scanner;

class a {
    int a, b, c;

    a(int x, int y, int z) {
        a = x;
        b = y;
        c = z;

    }

    int sum() {
        int d = a + b + c;
        return d;

    }

}

class constu {
    public static void main(String[] args) {
        int q, w, e;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter num1=");
        q = sc.nextInt();
        System.out.println("enter num2=");
        w = sc.nextInt();
        System.out.println("enter num3=");
        e = sc.nextInt();

        a obj = new a(q, w, e);
        System.out.println("sum is=" + obj.sum());

    }
}
