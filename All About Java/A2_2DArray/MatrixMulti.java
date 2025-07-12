import java.util.*;

public class MatrixMulti {
    static Scanner sc = new Scanner(System.in);

  
    static int[][] Multiplication(int[][] arr1, int[][] arr2, int r1, int c1, int r2, int c2) {
        if (r2 != c1) {
            System.out.println("Wrong Input - Multiplication not possible");
            return null;
        }

        int[][] res = new int[r1][c2]; 
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for(int k=0;k<c1;k++){
                    res[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return res;
    }

    // Method to read a matrix
    static void ReadArray(int[][] arr, int row, int col) {
        System.out.println("Enter " + row * col + " elements: ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
    }

    // Method to print a matrix
    static void PrintArray(int[][] arr) {
        if (arr == null) {
            System.out.println("No Matrix to Display");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter Rows for Matrix 1: ");
        int r1 = sc.nextInt();
        System.out.println("Enter Columns for Matrix 1: ");
        int c1 = sc.nextInt();
        int[][] arr1 = new int[r1][c1];

        System.out.println("Enter elements for Matrix 1:");
        ReadArray(arr1, r1, c1);
        System.out.println("Matrix 1:");
        PrintArray(arr1);

        System.out.println("Enter Rows for Matrix 2: ");
        int r2 = sc.nextInt();
        System.out.println("Enter Columns for Matrix 2: ");
        int c2 = sc.nextInt();
        int[][] arr2 = new int[r2][c2];


        System.out.println("Enter elements for Matrix 2:");
        ReadArray(arr2, r2, c2);
        System.out.println("Matrix 2:");
        PrintArray(arr2);

        int[][] res = Multiplication(arr1, arr2, r1, c1, r2, c2);

        System.out.println("Resultant Matrix:");
        PrintArray(res);
    }
}
