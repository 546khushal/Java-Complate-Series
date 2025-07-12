/*
Search the target value in a 2d integer matrix of dimentions n x m and return true if found,
else return false this has the following properties:
1. Integer in each row are sorted from top to buttom and left to right
  j--  <--Smaller(left)
        2   4  6  8    |
        5   6  7 20    | greater(bottom i++)
        7  11 13 25   \/
        12 14 17 30 

*/
class SearchIn_2DMatrix2{
   static boolean Search(int[][] a,int target){
        // Handle empty matrix case
        if (a == null || a.length == 0 || a[0].length == 0) {
            return false;
        }
        int n = a.length;    // number of rows
        int m = a[0].length; // number of columns
        int i = 0;
        int j =  m - 1;

        while(i< n && j>=0){
            if(a[i][j]==target)return true;
            if(target<a[i][j]){
                j--;//move left
            }
            else{
                i++;//move bottom
            }
        }
        return false;
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
        int[][] arr={{2,4,6,8},{ 5,6,7,20},{7,11,13,25},{12,14,17,30}};
        PrintMatrix(arr,4,4);
        
        
        if(!Search(arr,11)){
            System.out.println("Element not found");
        }else{
            System.out.printf(" Element found ");
        }
    }

}
/*
  j--  <--Smaller(left)
        2   4  6  8    |
        5   6  7 20    | greater(bottom i++)
        7  11 13 25   \/
        12 14 17 30 
i=0,j=m-1
  lets sart from 8 target 11 ->8(11 big) to bottom 20
                               20(11 small) to left 7
                                7(11 big) to bottom 13
                                13(11 small) to left 11 return
  */

