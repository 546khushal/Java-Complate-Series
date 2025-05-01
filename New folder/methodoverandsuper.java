class a {
    int a, b;

    a(int x, int y) {
        a = x;
        b = y;

    }

    void show() {
        System.out.println("a is=" + a);
        System.out.println("b is=" + b);
    }
}

class b extends a {
    int c;

    b(int x, int y, int z) {
        super(x, y);
        c = z;
    }

    void show() {
        System.out.println("c is=" + c);
        super.show();
    }
}

public class methodoverandsuper {
    public static void main(String[] args) {
        b obj = new b(2, 3, 4);
        obj.show();
    }
}
