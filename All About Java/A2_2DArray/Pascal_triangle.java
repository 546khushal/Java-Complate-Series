/*Given an integer n, return the first m rows of pascal's
triangle.
hr 1 no. uske upper wale 2 no. ka sum hoga

1}  p[i][j]=p[i-1][j]+p[i-1][j-1]
2}  In Every row,first and last element =1
3}  jaggad Array
*/
import java.util.*;
public class Pascal_triangle{
    static Scanner sc = new Scanner(System.in);

    static int[][] pascal(int n){
        int[][] ans = new int[n][];
        
        for(int i=0;i<n;i++){
            //ith row has i+1 column
            /*
                ans[0]=new int[1]
                ans[1]=new int[2]
             */
            ans[i]=new int[i+1];
            //1st and last element of every row is 1
            ans[i][0]=ans[i][i]=1;
            for(int j=1;j<i;j++){
                ans[i][j]=ans[i-1][j-1]+ans[i-1][j];
            }
        }

        return ans;
    }

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
        System.out.println("Enter n: ");
        int n=sc.nextInt();
        int[][] ans=pascal(n);
       
        
        PrintArray(ans);
    }   
}