import java.util.*;

public class stringpro {

    public static void main(String[] args) {

        String name = "Khushal";
        String kh = "suthar";
        // int value = name.length(); //op=7
        // String value = name.toLowerCase(); //op=khushal
        String value = name.toUpperCase(); // op=KHUSHAL

        System.out.println(value);
        System.out.println(name.length());
        System.out.println(name.equals(kh));

        String nonTrimmString = " khushal ";
        System.out.println(nonTrimmString);
        System.out.println(nonTrimmString.trim());

        System.out.println(name.substring(3));
        System.out.println(name.substring(1, 4));

        System.out.println(name.replace('h', 'o'));

    }

}
