/*
Search element in rotated sorted array with duplicate element. return true if the element is found else return false
input [0,0,0,1,1,1,2,0,0,0] target=2
output true;
 */
class Duplicate_Rotated{
    
    //jb st==mid==end to hm nhi pta lga pate hi sorted part konsa hai
    //st++,end--
    static int Rotated_search(int[] a, int target) {
        int low = 0, high = a.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            // Case 1: Found target
            if (a[mid] == target) {
                return mid+1; // Return index+1 as per requirement
            }
            
            // Case 2: When duplicates make it unclear which side is sorted
            // e.g., [3,1,2,3,3,3,3] or [2,2,2,0,2,2]
            if (a[low] == a[mid] && a[mid] == a[high]) {
                low++;
                high--;
                continue;
            }
            
            // Case 3: Right half (mid to high) is sorted
            if (a[mid] <= a[high]) {
                // Check if target lies in sorted right half
                if (target > a[mid] && target <= a[high]) {
                    low = mid + 1; // Search right
                } else {
                    high = mid - 1; // Search left
                }
            } 
            // Case 4: Left half (low to mid) is sorted
            else {
                // Check if target lies in sorted left half
                if (target >= a[low] && target < a[mid]) {
                    high = mid - 1; // Search left
                } else {
                    low = mid + 1; // Search right
                }
            }
        }
        return -1; // Not found
    }
    public static void main(String[] args){
        int[] arr={1,1,1,2,2,3,1};
        int target=2;
        int res =Rotated_search(arr,target);
        
        if(res==-1){
            System.out.println("Element not found");
        }else{
            System.out.printf("Rotated Element found at index %d ",res);
        }
    }

}






