import java.util.Scanner;
class removeDuplicate{
    public int removeDuplicates(int[] nums) {
      if(nums.length==0)return 0;
       int k=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[k++]=nums[i];
            }
        }
        return k;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        
        // Input array elements
        int[] nums = new int[n];
        System.out.println("Enter " + n + " sorted elements (with duplicates): ");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        removeDuplicate obj = new removeDuplicate();
        int newLength = obj.removeDuplicates(nums);
        System.out.println("Array after removing duplicates:");
        for (int i = 0; i < newLength; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}