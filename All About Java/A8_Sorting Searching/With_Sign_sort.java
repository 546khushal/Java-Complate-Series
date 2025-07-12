/*Given an array of positive and negative integer,
segregate them  in linear time and constant space.
The output should print all negative number , followed by  all positive number
input:[19,-20,7,-4, -13, 11, -5, 3]
output:[-20 -4 -13 -5 7 11 19 3] 
*/
public class With_Sign_sort{
    static void PrintArray(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void Sort(int[] arr,int n){
        int left=0;
        int right=n-1;
        while(left<=right){
            if (arr[left] < 0) {
                left++; // Negative number is in the correct place
            } else if (arr[right] >= 0) {
                right--; // Positive number is in the correct place
            } else {
                // Swap arr[left] and arr[right]
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }
    public static void main(String[] args){
        int[] arr={19,-20,7,-4,-13,11,-5,3};
        Sort(arr,arr.length);
        PrintArray(arr,arr.length);
    }
    
}