class a {
    int rno;
    String name;
    int fees;

    a(int r, String n) {
        rno = r;
        name = n;

    }

    a(int r, String n, int f) {
        this(r, n);
        fees = f;

    }

    void display() {
        System.out.println(rno + "  " + name + "  " + fees);

    }

}

class thisp {
    public static void main(String[] args) {
        a obj = new a(1, "hello", 6000);
        obj.display();

    }
}