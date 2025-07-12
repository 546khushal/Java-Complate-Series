/*
1  2  3  
8  9  4
7  6  5
 */
import java.util.*;
public class SprialMatrix2 {
    static Scanner sc = new Scanner(System.in);

    static int[][] generateSpiralMatrix(int n) {
        int[][] matrix = new int[n][n];
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
        int current = 1; 

        while (current <= n * n) { 
            // topRow -> leftCol to rightCol
            for (int j = leftCol; j <= rightCol && current <= n * n; j++) {
                matrix[topRow][j] = current++; // Correct
            }
            topRow++;

            // rightCol -> topRow to bottomRow
            for (int i = topRow; i <= bottomRow && current <= n * n; i++) {
                matrix[i][rightCol] = current++; // Correct
            }
            rightCol--;

            // bottomRow -> rightCol to leftCol
            for (int j = rightCol; j >= leftCol && current <= n * n; j--) {
                matrix[bottomRow][j] = current++; // Correct
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for (int i = bottomRow; i >= topRow && current <= n * n; i--) {
                matrix[i][leftCol] = current++; // Correct
            }
            leftCol++;
        }
        return matrix;
    }

    static void PrintArray(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("Enter n: ");
        int n = sc.nextInt(); // Ensure n is positive, or handle negative cases
        int[][] matrix = generateSpiralMatrix(n);
        System.out.println("Spiral Order: ");
        PrintArray(matrix);
    }
}
