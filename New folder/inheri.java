class a {
    void sum(int a, int b) {
        System.out.println("sum=" + (a + b));

    }

}

class b extends a {
    void sub(int a, int b) {
        System.out.println("sub=" + (a - b));

    }
}

class inheri {
    public static void main(String[] args) {
        b obj = new b();
        obj.sub(5, 2);
        obj.sum(3, 4);

    }
}