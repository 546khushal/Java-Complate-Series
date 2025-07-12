/*A rotated Sorted array is a sorted array on which rotation operation has been performed some number of times . 
given a rotated sorted array, 
find the index of the minimum element in 
the Follow 0-based indexing.

it is guaranteed that all the element  in the array are unique.
input Array=[3,4,5,1,2]
output 3
kha se rotate hua jha chota element hia vhi se hua hoga
*/

//Approach 1st find min O(n)linear
//Approach 2nd  isme 2 part sorted hai 3,4,5   1,2 yha binary search use krna 
class SearchIn_Rotate{
    /**Iteration 1: low=0, high=11 → mid=5 → a[5]=3 ≤9 → ans=5, high=4
    Iteration 2: low=0, high=4 → mid=2 → a[2]=12 >9 → low=3
    Iteration 3: low=3, high=4 → mid=3 → a[3]=1 ≤9 → ans=3, high=2
    Loop ends (low > high)
    Return ans=3 (a[3]=1 is smallest) */
    
    static int Rotated_search(int[] a){
        int n=a.length;
        int ans=-1;
        int low=0,high=n-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(a[mid]>a[n-1]){
                low=mid+1;
            }
            else if(a[mid]<=a[n-1]){
                ans=mid;
                high=mid-1;
            }
        }
        return ans;
    }
    public static void main(String[] args){
        int[] arr={10, 11, 12, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        int res =Rotated_search(arr);
        
        if(res==-1){
            System.out.println("Element not found");
        }else{
            System.out.printf("Rotated Element found at index %d ",res);
        }
    }

}