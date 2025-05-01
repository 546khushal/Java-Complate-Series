/*Sprial matrix
top row
right coloumn
bottom row
left coloumn
1  2  3  
4  5  6
7  8  9
Spiral Order:
1 2 3 6 9 8 7 4 5
*/
import java.util.*;
public class SprialMatrix{
    static Scanner sc= new Scanner(System.in);
     static void PrintSpiralOrder(int[][] matrix, int r, int c) {
        int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
        int total = 0;
        while (total < r * c) {
            // topRow -> leftCol to rightCol
            for (int j = leftCol; j <= rightCol && total < r * c; j++) {
                System.out.print(matrix[topRow][j] + " ");
                total++;
            }
            topRow++;

            // rightCol -> topRow to bottomRow
            for (int i = topRow; i <= bottomRow && total < r * c; i++) {
                System.out.print(matrix[i][rightCol] + " ");
                total++;
            }
            rightCol--;

            // bottomRow -> rightCol to leftCol
            for (int j = rightCol; j >= leftCol && total < r * c; j--) {
                System.out.print(matrix[bottomRow][j] + " ");
                total++;
            }
            bottomRow--;

            // leftCol -> bottomRow to topRow
            for (int i = bottomRow; i >= topRow && total < r * c; i--) {
                System.out.print(matrix[i][leftCol] + " ");
                total++;
            }
            leftCol++;
        }
    }
    static void ReadArray(int[][] arr,int row,int col){
         for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                arr[i][j]= sc.nextInt();
            }
        }
    }
    static void PrintArray(int[][] arr){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        System.out.println("Enter Row: ");
        int r= sc.nextInt();
        System.out.println("Enter Coloumn: ");
        int c= sc.nextInt();
        int[][] matrix = new int[r][c];
        int total= r*c;
        System.out.println("Enter "+total+" values");
        ReadArray(matrix,r,c);
        PrintArray(matrix);
        System.out.println("Spiral Order: ");
        PrintSpiralOrder(matrix,r,c);


    }
}