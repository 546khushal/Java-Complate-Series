import java.util.*;
public class Array2D{
    static Scanner sc = new Scanner(System.in);

    static void ReadArray(int[][] arr,int row,int col){
        System.out.println("Enter "+ row*col +" Element: ");
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
        int r=sc.nextInt();
        System.out.println("Enter Column: ");
        int c=sc.nextInt();
        int[][] arr2=new int[r][c];
        //int[][] arr2={{1,2,3},{4,5,6},{7,8,9}};
        ReadArray(arr2,r,c);
        PrintArray(arr2);
    }   
}