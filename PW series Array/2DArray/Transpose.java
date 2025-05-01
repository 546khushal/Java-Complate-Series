import java.util.*;

public class Transpose {
    static Scanner sc = new Scanner(System.in);

    // Method to compute the transpose of a matrix (returns new matrix)
    static int[][] TransposeMatrix(int[][] arr1, int r1, int c1) {
        int[][] res = new int[c1][r1];
        for (int i = 0; i < c1; i++) {
            for (int j = 0; j < r1; j++) {
                res[i][j] = arr1[j][i];
            }
        }
        return res;
    }

    // Method to compute the in-place transpose of a square matrix
    static void TransposeMatrix_InPlace(int[][] matrix, int r1, int c1) {
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

        if (r1 == c1) {
            // Perform in-place transpose
            TransposeMatrix_InPlace(arr1, r1, c1);
            System.out.println("Resultant Matrix (In-place Transpose):");
            PrintArray(arr1);
        } else {
            // Perform normal transpose (new matrix)
            int[][] res = TransposeMatrix(arr1, r1, c1);
            System.out.println("Resultant Matrix (New Transposed Matrix):");
            PrintArray(res);
        }
    }
}
