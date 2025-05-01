interface a {
    void show();

}

class b implements a {
    public void show() {
        System.out.println("hello");

    }
}

public class interf {
    public static void main(String[] args) {
        b obj = new b();
        obj.show();

        a obj1 = new b();
        obj1.show();

        obj1 = obj;
        obj1.show();

    }

}
