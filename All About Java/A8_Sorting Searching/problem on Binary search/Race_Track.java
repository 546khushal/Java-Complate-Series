/*
A new racing track for kids is being built in New York with 'n' starting spots. The spots are located along a straight line at positions x1, x2... xn(xi <=10^9). For each 'i', xi+1 > xi.

At a time only 'm' children are allowed to enter the race. Since the race track is for kids, they may run into each other while running. To prevent this, we want to choose the starting spots such that the minimum distance between any two of them is as large as possible. 
What is the largest minimum distance?

The first line of input will contain the value of n, the number of starting spots.
The second line of input will contain the n numbers denoting the location of each spot.
The third line will contain the value of m, number of children.
Input
5
12489  
3
Output 3
 */
class Race_Track{
    static boolean isPossible(int[] a,int m,int dist){
        int kidsPlaced=1;// Always place first kid at first spot
        int lastKid =a[0];// Position of last placed kid or yha last hi a[0] hai phla place
        for(int i=1;i<a.length;i++){
        // If current spot is >= 'dist' distance from last placed kid
            if(a[i]-lastKid>=dist){
                kidsPlaced++;
                lastKid=a[i];// Update last kid's position
            }
        }
        return kidsPlaced>=m;
    }
    /*
    Binary search O(log(max_distance))
    isPossible() function O(n)
    Total time Comlexity: O(n log(max_distance))
    O(n logN)

    Space Complexity:O(1) Uses only constant extra space
     */
    static int Track(int[] a,int m){
        if(m>a.length)return -1;
        int st = 1;          // Minimum possible distance (1 meter)
        int end = (int)1e9;  // Large upper bound (similar to Chocolate problem)
        int ans=0;// Stores maximum minimum distance found
        while(st<=end){
            int mid=st+(end-st)/2;
            if(isPossible(a,m,mid)){//can m kids be pleaced such that no 2 kids have distance lesser than mid
                ans=mid;
                st=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;

    }
    public static void main(String[] args){
        int[] a={1,2,4,8,9};
        int m=3;
        System.out.println(Track(a,m));
    }
}
/*
n(spot)=5,m(child)
.______.________.______.______. find maximal minima ?
1     2        4      8       9

DRY RUN with a = [1,2,4,8,9], m=3:

Initial: st=1, end=1e9, ans=0

Iteration 1:
mid = 500,000,000
isPossible: 
- Place at 1
- Next >= 500,000,001? No spots → kidsPlaced=1
Return false → end=499,999,999

Iteration 2:
mid = 250,000,000
Same issue → end=249,999,999
...
Until mid reaches realistic distances

When mid=3:
isPossible:
- Place at 1
- 4-1=3 >=3 → place at 4 (kidsPlaced=2)
- 8-4=4 >=3 → place at 8 (kidsPlaced=3)
Return true → ans=3, st=4

mid=4:
isPossible:
- Place at 1
- 8-1=7 >=4 → place at 8 (kidsPlaced=2)
- No next spot >=8+4=12
Return false → end=3

Loop ends (st=4 > end=3)
Final answer: 3


 */