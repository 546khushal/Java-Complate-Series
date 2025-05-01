abstract class a {
    abstract void show();
}

class b extends a {
    void show() {
        System.out.println("hello");

    }
}

class c extends a {
    void show() {
        System.out.println("khushal");

    }
}

class abstpro {
    public static void main(String[] args) {
        a obj;
        b obj2 = new b();
        obj = obj2;
        obj.show();
        c obj3 = new c();
        obj = obj3;
        obj.show();
        obj3.show();
    /*OUTPUT
    hello
    khushal
    khushal*/
    }
}