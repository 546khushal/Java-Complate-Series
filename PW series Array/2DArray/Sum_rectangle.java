
//Given a matrix a of dimension n x m and 2 coordinates(11,r1)and(12,r2).
//retrun the sum of the rectangle from (11,r1) to (12,r2)
import java.util.*;
public class Sum_rectangle{
    static Scanner sc = new Scanner(System.in);
    //sum of Rectangle using brute force method
    static int Rectangle_Sum(int[][] matrix, int l1,int r1,int l2,int r2){
        int sum=0;
        for(int i=l1;i<=l2;i++){
            for(int j=r1;j<=r2;j++){
                sum+=matrix[i][j];
            }

        }

        return sum;
    }
    //method 2:pre-calculating the horizontal sum for each row in the matrix
    static void findPreficSumMatrix(int[][] matrix){
        int r=matrix.length;
        int c=matrix[0].length;
        //traverse horizontaly to calcu row wise prefin sum
         for(int i=0;i<r;i++){
            for(int j=1;j<c;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
        //traverse vertically to calculate column wise sum
        for(int j=0;j<c;j++){
            for(int i=1;i<r;i++){
                matrix[i][j]+=matrix[i-1][j];
            }
        }
    }

    /*static void findPreficSumMatrix(int[][] matrix){
        int r=matrix.length;
        int c=matrix[0].length;
        //traverse horizontaly to calcu row wise prefin sum
         for(int i=0;i<r;i++){
            for(int j=1;j<c;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }
       
    }
    static int Rectangle_Sum2(int[][] matrix, int l1,int r1,int l2,int r2){
        int sum=0;
        findPreficSumMatrix(matrix);
        for(int i=l1;i<=l2;i++){
            //r1 to re sum of row
            if(r1>=1)
                sum+=matrix[i][r2]-matrix[i][r1-1];
            else
                sum+=matrix[i][r2];
        }

        return sum;
    }*/
    //method 3: prefix sum over columns and rows both
    
    static int Rectangle_Sum3(int[][] matrix, int l1,int r1,int l2,int r2){
        int ans=0, sum=0,up=0,left=0,leftup=0;
        findPreficSumMatrix(matrix);
        sum=matrix[l2][r2];
        if(r1>=1)
            left=matrix[l2][r1-1];
        if(l1>=1)
            up=matrix[l1-1][r2];
        if(l1>=1 && r1>=1)
            leftup=matrix[l1-1][r1-1];
        ans=sum-up-left+leftup;


        return ans;
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
        int[][] rectangle = new int[r][c];
        int total= r*c;
        System.out.println("Enter "+total+" values");
        ReadArray(rectangle,r,c);
        PrintArray(rectangle);
        System.out.println("Enter rectangle boundaries l1,r1,l2,r2: ");
        int l1= sc.nextInt();
        int r1= sc.nextInt();
        int l2= sc.nextInt();
        int r2= sc.nextInt();
        System.out.println("Rectangle Sum : "+ Rectangle_Sum(rectangle,l1,r1,l2,r2));
        //System.out.println("Rectangle Sum method 2: "+ Rectangle_Sum2(rectangle,l1,r1,l2,r2));
        System.out.println("Rectangle Sum method 3: "+ Rectangle_Sum3(rectangle,l1,r1,l2,r2));

    }
}