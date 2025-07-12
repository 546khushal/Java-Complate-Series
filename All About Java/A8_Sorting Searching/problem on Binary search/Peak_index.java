/*
Given a mountain array 'a' of length greater than 3,return the index 'i'
such that arr[0]<arr[1]<...<arr[i-1]< arr[i] >arr[i+1]>..>arr[arr.lenght-1].
this index is known as the peak index.
Input Array=[0,4,1,0]
output 1

        5
      4   3 
    3       2
  2          
peak index 3(5 se mountain girne lga)
 */
class Peak_index{
    /*Iteration 1: st=0, end=5 → mid=2 → a[2]=4 < a[3]=5 → ans=3, st=3
    Iteration 2: st=3, end=5 → mid=4 → a[4]=3 ≮ a[5]=2 → end=3
    Iteration 3: st=3, end=3 → mid=3 → a[3]=5 ≮ a[4]=3 → end=2
    Loop ends (st > end)
    Return ans=3 (Peak at index 3) */
    static int PeakIndexInMountainArray(int[] a){
        int st=0,end=a.length-1;
        int ans=-1;
        while(st<=end){
            int mid=st+(end-st)/2;
            if(a[mid]<a[mid+1]){
                ans=mid+1;
                st=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    /*case 1: if(a[mid]>a[mid-1] && a[mid]>a[mid+1])return mid
            but above line Time comlexity linear 
            Peak Element (Termination Condition)
                   /\
                  /  \
                /    \
        CASE 2: Ascending Slope (3 Sub-cases)
            a) Normal ascending: mid < mid+1 < peak
                   /\
                  /  
                /    
            b) Peak at last element: mid < mid+1 == n-1
                   /\
                  /  \
                /    \
                      \
            c) Flat ascending then peak: mid == mid+1 < peak
                   /\
                  /  
                /____
        CASE 3: Descending Slope (3 Sub-cases)
            a) Normal descending: peak < mid < mid+1
                     /\
                      \  
                       \
            b) Peak at first element: 0 == peak > mid > mid+1
                 /\
                  \  
                   \
            c) Flat descending after peak: peak > mid == mid+1
                     /\
                    /  
                ____/
      
    */
static int FindPeakElement(int[] a) {
    int st = 0, end = a.length - 1;

    while (st <= end) {
        int mid = st + (end - st) / 2;

        // CASE 1: Peak Element (Termination Condition)
        if ((mid == 0 || a[mid] >= a[mid - 1]) && (mid == a.length - 1 || a[mid] >= a[mid + 1])) {
            return mid;
        }

        // CASE 2: Ascending Slope
        else if (mid < a.length - 1 && a[mid] < a[mid + 1]) {
            st = mid + 1;
        }

        // CASE 3: Descending or Flat Slope
        else {
            end = mid - 1;
        }
    }

    return -1; // Should not reach here for valid input
}




    public static void main(String[] args) {
        // Test cases
        int[] arr = {2, 3, 4, 5, 3, 2};
        System.out.println("Peak index: " + FindPeakElement(arr)); // Expected: 3

        int[] case1 = {1, 3, 5, 4, 2};      // Normal peak at index 2
        int[] case2a = {1, 3, 5, 7, 9};     // Monotonic increasing (last element is peak)
        int[] case2b = {1, 3, 5, 5, 4};     // Flat then peak
        int[] case3a = {9, 5, 4, 3, 1};     // Monotonic decreasing (first element is peak)
        // int[] case3b = {5, 4, 4, 3, 1};     // Flat descending
        int[] cas = {1, 2, 1, 3, 5, 6, 4}; 
        System.out.println("Case 1: " + FindPeakElement(case1));   // Expected: 2
        System.out.println("Case 2a: " + FindPeakElement(case2a)); // Expected: 4
        System.out.println("Case 2b: " + FindPeakElement(case2b)); // Expected: 2
        System.out.println("Case 3a: " + FindPeakElement(case3a)); // Expected: 0
        //System.out.println("Case 3b: " + FindPeakElement(case3b)); // Expected: 0
        System.out.println("Cas: " + FindPeakElement(cas)); //expeacted 1/5 index but correct 5
    }
}
