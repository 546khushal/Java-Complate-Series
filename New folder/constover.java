class a {
    int a, b, c, d;

    a() {
        a = 1;
        b = 2;

        d = a + b;
        System.out.println("sum is=" + d);
        System.out.print("multiple is=" + (a * b));

    }

    a(int x) {
        a = x;

        System.out.println("squar=" + (a * a));

    }

    a(int x, int y, int z) {
        a = x;
        b = y;
        c = z;
        d = a + b + c;
        System.out.println("sum is=" + d);
        System.out.print("multiple is=" + (a * b * c));

    }
}

class constover {

    public static void main(String[] args) {

        a obj = new a(2, 3, 4);
    }
}
