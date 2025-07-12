import java.util.*;

public class Rotate {
    static Scanner sc = new Scanner(System.in);

    static void rotateArray(int[][] arr1, int r, int c) {
        //transpose
        TransposeMatrix(arr1,r,c);
        //reverse each row of transpose matrix3
        for(int i=0;i<r;i++){
            reverseArray(arr1[i]);
        } 
    }

    // Method to compute the in-place transpose of a square matrix
    static void TransposeMatrix(int[][] matrix, int r1, int c1) {
        if (r1 != c1) {
            System.out.println("In-place transpose is only possible for square matrices!");
            return;
        }
        for (int i = 0; i < r1; i++) {
            for (int j = i + 1; j < c1; j++) {
                // Swap matrix[i][j] and matrix[j][i]
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
    }
    static void reverseArray(int[] arr){
        int i=0,j=arr.length-1;
        while(i<j){
            int tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
            i++;
            j--;
        }

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

        
            rotateArray(arr1, r1, c1);
            System.out.println("ROtate Matrix ");
            PrintArray(arr1);
        
    }
}
