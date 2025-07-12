/*
You have 'n'(n <= 10^5) boxes of chocolate. Each box contains a[i] (a[i] <= 10000) chocolates. 
You need to distribute these boxes among 'm' students such that the maximum number of chocolates allocated to a student is minimum.

a) One box will be allocated to exactly one student.
b) All the boxes should be allocated.
c) Each student has to be allocated at least one box.
d) Allotment should be in contiguous order, for instance, a student cannot be allocated box 1 and box 3, skipping box 2.

Calculate and return that minimum possible number.

Assume that it is always possible to distribute the chocolates.

The first line of input will contain the value of n, the number of boxes.
The second line of input will contain the n numbers denoting the number of chocolates in each box.
The third line will contain the m, number of students.
Input
4
12 34 67 90
2
Output 113
 */
class Distribute_chocolates{
    //O(n)
    static boolean isDivisionPossible(int[] a, int m,int maxChocAllowed){
            int numOfStudent =1;// Start with first student
            int choc=0;//number of choc current student has
            for(int i=0;i<a.length;i++){
                // If any single box exceeds max allowed, distribution impossible
                if(a[i]>maxChocAllowed)return false;
                // Check if we can add current box to current student's allocation
                if(choc+a[i]<=maxChocAllowed){
                    choc+=a[i];
                }else{
                    numOfStudent++;// Need a new student for this box
                    choc=a[i];// New student starts with this box
                }
            }
            return numOfStudent<=m;// If we've exceeded student count, distribution impossible
            // if(numOfStudent>m)return false;
            // return true;
    }
   //time complexity: O(n*logn) 
    static int distribute(int[] a,int m){
        if(a.length<m)return -1;
        int ans = 0;
        int st = 1;  // Minimum possible answer (at least one chocolate)
        int end = (int)1e9;  // Upper bound (can be sum of all chocolates)
        /**int totalSum = 0;
        for (int num : a) totalSum += num;
        int end = totalSum; */
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isDivisionPossible(a,m,mid)){//fun O(n) time
                ans=mid;// Found a possible solution
                end=mid-1;// Try for smaller maximum

            }else{
                st=mid+1;// Need to increase maximum
            }
        }
        return ans;
    }
    
    public static void main(String[] args){
        
        // int[] a={12,34,67,90};//output 113
        //int[] a={5,3,1,4,2};//output 6
        //int m=2;//student
        //int m=3;
        int[] a={3,7,1,9,6,2};
        int m=3;
        System.out.println(distribute(a,m));

    }
}
/*
2 student hai ya to s1               s2 
    case 1:         [12]->12         [34,67,90]->191
    case 2:         [12,23]->46      [67,90]->157
    case 3:         [12,34,67]->113  [90]->90
 max: 191,157,113 all cases ->min 113       minimal maxima              
 
3student[5,3,1,4,2] 
         c1      c2      c3     c4     c5
s1      0(5)     0(5)    01(8)   0(5)  01(8)   
s2      1(3)    12(4)   23(5)   123(8) 2(1)  
s3      234(7)   34(6)   4(2)     4(2)  34(6)
max    7,6,8,8,8
min from max(minimam maxima )->6 answer
 */