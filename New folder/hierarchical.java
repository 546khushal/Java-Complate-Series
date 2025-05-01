class a {
    int a, b;

    void res(int c) {
        System.out.println(c);
    }
}

class b extends a {
    int c;

    void sum(int x, int y) {
        a = x;
        b = y;
        c = a + b;
        System.out.println("sum of" + a + " and " + b + "=");
        res(c);
    }
}

class c extends a {
    int c;

    void mul(int x, int y) {
        a = x;
        b = y;
        c = a * b;
        System.out.println("mul of" + a + " and " + b + "=");
        res(c);
    }
}

public class hierarchical {
    public static void main(String ar[]) {
        int a = 2, b = 4;
        b obj = new b();
        obj.sum(a, b);
        c obj2 = new c();
        obj2.mul(a, b);
    }

}
