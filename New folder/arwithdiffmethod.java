import java.util.Scanner;

class math {

    int n1, n2, n3;

    void add() {
        n3 = n1 + n2;
        System.out.println("add= " + n3);

    }

    void sub() {
        n3 = n1 - n2;
        System.out.println("sub= " + n3);

    }

    void multi() {
        n3 = n1 * n2;
        System.out.println("multi= " + n3);

    }

    void div() {
        n3 = n1 / n2;
        System.out.println("div= " + n3);

    }

}

class arwithdiffmethod {
    public static void main(String[] args) {
        int q, p;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter n1=");

        q = sc.nextInt();
        System.out.println("enter n2=");
        p = sc.nextInt();
        math obj = new math();
        obj.n1 = q;
        obj.n2 = p;
        obj.add();
        obj.sub();
        obj.multi();
        obj.div();

    }
}
