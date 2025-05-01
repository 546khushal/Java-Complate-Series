public class trycatch {
    public static void main(String[] args) {
        try {
            int x = 4;
            int y = 2;
            int z = x / y;
            System.out.println("result is=" + z);

        } catch (ArithmeticException e) {
            System.out.println("can not be zero");
        }
    }

}
