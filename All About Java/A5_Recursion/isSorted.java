import java.util.Scanner;
public class isSorted{
    static String isSorted (int[ ] arr, int idx){
            if (idx>= arr.length-1) return "Sorted";
            if (arr[idx]>arr[idx+1]){
                return "Not Sorted";
            }
            return isSorted(arr, ++idx);
        }
        
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] arr ={1,2,3,4,5,6,7};
        
        System.out.println(isSorted(arr,0));
    }
}