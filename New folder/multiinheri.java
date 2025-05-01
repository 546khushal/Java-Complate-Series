class a {
    String i;
    int s, m, e;

    void showd() {
        System.out.println("science=" + s);
        System.out.println("math=" + m);
        System.out.println("english=" + e);
    }
}

class b extends a {
    int t;

    void total() {
        t = s + m + e;
        System.out.println("total=" + t);
    }
}

class c extends b {
    int p;

    void per() {
        // this.showd();
        // this.total();
        p = t / 3;

        System.out.println("percentage=" + p + "%");

    }
}

class multiinheri {
    public static void main(String[] args) {
        c obj = new c();
        obj.s = 83;
        obj.m = 94;
        obj.e = 88;
        obj.showd();
        obj.total();
        obj.per();
    }

}