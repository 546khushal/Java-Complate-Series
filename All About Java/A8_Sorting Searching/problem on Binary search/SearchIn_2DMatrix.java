/*
Search the target value in a 2d integer matrix of dimentions n x m and return index if found,
else return -1 this has the following properties:
1. Integer in each row are sorted from left to right
2. The first Integer of each row is greter than the last of the previous row
input matrix= [[1,3,5,7],[10,11,16,20],[23,30,34,60]] target = 3
output true

 1  3  5  7 
10 11 16 20
23 30 34 60 sorted

Approach1: O(mn) linear
Approach2: O(nlogm) check each row(log n) binary search
Approach3: O(log(nm)) all element in 1d array and apply Binary search
            but use extra space
final Approach: O(logmn) no extra spce
*/
class SearchIn_2DMatrix{
    /*
    Iteration 1: st=0, end=11 → mid=5 → a[1][1]=11 <16 → st=6
    Iteration 2: st=6, end=11 → mid=8 → a[2][0]=23 >16 → end=7
    Iteration 3: st=6, end=7 → mid=6 → a[1][2]=16 ==16 → Found! */
    static int Search(int[][] a,int target){
        // Handle empty matrix case
        if (a == null || a.length == 0 || a[0].length == 0) {
            return -1;
        }
        int n = a.length;    // number of rows
        int m = a[0].length; // number of columns
        int st = 0;
        int end = n * m - 1;

        while(st<=end){
            int mid=st+(end-st)/2;
            int midEle=a[mid/m][mid%m];// Convert 1D index to 2D coordinates

            if(midEle==target)return mid+1;
            if(target<midEle){
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        return -1;
    }
    
    static void PrintMatrix(int[][] arr,int row,int col){
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        int[][] arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        PrintMatrix(arr,3,4);
        int res =Search(arr,16);
        
        if(res==-1){
            System.out.println("Element not found");
        }else{
            System.out.printf("Rotated Element found at index %d ",res);
        }}

}
/*
 1(0m+0)  3(0m+1)  5(0m+2)  7(0m+3) 
 10(m+0)  11(m+1)  16(m+2)  20(m+3)
23(2m+0) 30(2m+1) 34(2m+2) 60(2m+3) target 16
i=i/m,      i%m
matrix ko 1,2,3,... index ki trh use kiya index nikala upper formula se
   row no   col no
st          mid         index        end
0          5(5/4,5%4)->(1,1)         11
6          8(8/4,8%4)->(2,0)         11 
            16<25 phle jao
6          6(6/4,6%/4)->(1,2)        7
            16=16 return ans

r=(rm+c)/m
c=(rm+c)%m 


*/