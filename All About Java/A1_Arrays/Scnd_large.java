import java.util.*;

class calculation {
    public int S_large(int[] arr) {
        int n = arr.length;
        int max=Integer.MIN_VALUE;
        int max2=Integer.MIN_VALUE;
        
        for (int i = 0; i < n; i++) {
             if(arr[i]>max){
                max2=max;
                max=arr[i];
             }else if(arr[i]>max2 && arr[i]!=max){
                max2=arr[i]; // Update max2 only if it's not equal to max
            }
        }
        // If no second largest value was found, return -1
        return max2 == Integer.MIN_VALUE ? -1 : max2;
    }


    //seconf method
    public int findMax(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public int snc_l(int[] arr){
        int n = arr.length;
        int max=findMax(arr);
        for(int i=0;i<n;i++){
            if(arr[i]==max){
            arr[i]=Integer.MIN_VALUE;
            }
        }
        int smax=findMax(arr);
        return smax;
    }
    //second method end

}



public class Scnd_large {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Array Size:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        calculation obj = new calculation();
        System.out.println("The Second Largest number is: " + obj.S_large(arr));
        System.out.println("The Second Largest number(method 2) is: " + obj.snc_l(arr));
    }
}
