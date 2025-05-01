import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        /*
         * int[] marks = { 12, 13, 14, 15, 16 };
         * // System.out.println(marks[0]);
         * // System.out.println(marks[1]);
         * // System.out.println(marks[2]);
         * // System.out.println(marks[3]);
         * // System.out.println(marks[4]);
         * System.out.println(marks.length);
         * for (int i = 0; i < marks.length; i++) {
         * System.out.println(marks[i]);
         * 
         * }
         * //using scanner take array from user
         * int[] ar = new int[6];
         * Scanner sc = new Scanner(System.in);
         * System.out.println("enter ar value=");
         * for (int i = 0; i < ar.length; i++) {
         * ar[i] = sc.nextInt();
         * }
         * System.out.println("ar value is=");
         * for (int i = 0; i < ar.length; i++) {
         * System.out.println(ar[i]);
         * 
         * }
         */

        // 2d array
        int[][] flat;
        flat = new int[2][3];
        Scanner sc = new Scanner(System.in);
        System.out.println("enter ar value=");
        for (int i = 0; i < flat.length; i++)
            for (int j = 0; j < flat[i].length; j++) {
                flat[i][j] = sc.nextInt();
            }
        System.out.println("array is=");
        for (int i = 0; i < flat.length; i++) {
            for (int j = 0; j < flat[i].length; j++) {
                System.out.print(flat[i][j]);
                System.out.print("     ");
            }
            System.out.print("\n ");
        }
    }

}
