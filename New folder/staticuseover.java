class a {
    static int n1, n2;

    static void fun(int n) {
        int f = 1;
        n1 = n;
        for (int i = 1; i <= n1; i++) {
            f = f * i;
        }
        System.out.println("factorial= " + f);

    }
}

class staticuseover {
    public static void main(String[] args) {
        // a obj = new a();

        a.fun(6);
        // a.fun();
    }
}