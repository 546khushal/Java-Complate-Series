/*Given the rotated Sorted array of integers, which contains distinct element,
and an integer target return index of the target if it is in the array
Otherwise return -1.
input [3,4,5,1,2] target=4;
output 4

Note: use O(logn) not use linear O(n)
 */
class Distinct_rotated{
    
    
    static int Rotated_search(int[] a,int target){
        int low=0,high=a.length-1;
        while(low<=high){
            int mid= low+(high-low)/2;
            if(a[mid]==target)
                return mid+1;
            else if(a[mid]<a[high]){//mid to end is sorted
                if(target>a[mid] && target<=a[high]){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }else{ //st to mid is sorted
                if(target>=a[low] && target<a[mid]){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args){
        int[] arr={3,4,5,1,2};
        int target=11;
        int res =Rotated_search(arr,target);
        
        if(res==-1){
            System.out.println("Element not found");
        }else{
            System.out.printf("Rotated Element found at index %d ",res);
        }
    }

}
/*target 12
9   10 11  12  1  2  3 4 5 6 7  8   
st                mid           end
if(a[mid]<a[end])->mid to end is sorted
    if(taget>a[mid] && taget <=a[end]) st=mid+1
    else end=mid-1
else  dono me se ek part hi sorted hai ya dono sortes dono unsorted nhi ho skte
    st to mid is sorted
    if(target>=a[st] && target <a[mid]) end=mid-1
    else st=mid+1

 */




