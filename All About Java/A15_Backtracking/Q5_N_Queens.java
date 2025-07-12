/*
The n-queens puzzle is the problem of placing n queens on an 
n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. 
You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' 
placement, where 'Q' and '.' both indicate a queen and an empty space, respectively. 
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

. Q . . 
. . . Q
Q . . .
. . Q .

. . Q .
Q . . .
. . . Q
. Q . .
*/
class Q5_N_Queens{
    public static void main(String[] args) {
        int n = 4;
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }

        solveNQueens(board,0);
    }
        
    public static void solveNQueens(char[][] board,int row)  {
        int n=board.length;
        if(row==n){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    System.out.print(board[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        for (int j = 0; j<n;j++){
            if(isSafe(board,row,j)) {
                board[row][j]='Q';
                solveNQueens(board,row+1);
                board[row][j]='.';//backtracking
            }
        }

    }
    static boolean isSafe(char[][] board,int row,int col) {
        int n = board.length;
        //check the row
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q')return false;
        }
        //check the col
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q')return false;
        }
        //check north east
        int i=row;
        int j=col;
        while(i>=0 && j<n){
            if(board[i][j]=='Q')return false;
            i--;
            j++;
        }
        //check south east
        i=row;
        j=col;
        while(i<n && j<n){
            if(board[i][j]=='Q')return false;
            i++;
            j++;
        }
        //check south west
        i=row;
        j=col;
        while(i<n && j>=n){
            if(board[i][j]=='Q')return false;
            i++;
            j--;
        }
        //check north west
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q')return false;
            i--;
            j--;
        }
        return true;
    }
}


//Same on leetcode
/*class Solution {
    public void NQueens(char[][] board,int row,List<List<String>> ans)  {
        int n=board.length;
        if(row==n){
            //copy 2D char array into list of String
            List<String> l = new ArrayList<>();
            for(int i=0;i<n;i++){
                String str = "";
                for(int j=0;j<n;j++){
                    str+=board[i][j];
                }
                l.add(str);
            }
            ans.add(l);
            return;
        }
        for (int j = 0; j<n;j++){
            if(isSafe(board,row,j)) {
                board[row][j]='Q';
                NQueens(board,row+1,ans);//recursion
                board[row][j]='.';//backtracking
            }
        }

    }
    
     boolean isSafe(char[][] board,int row,int col) {
        int n = board.length;
        //check the row
        for(int j=0;j<n;j++){
            if(board[row][j]=='Q')return false;
        }
        //check the col
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q')return false;
        }
        //check north east
        int i=row;
        int j=col;
        while(i>=0 && j<n){
            if(board[i][j]=='Q')return false;
            i--;
            j++;
        }
        //check south east
        i=row;
        j=col;
        while(i<n && j<n){
            if(board[i][j]=='Q')return false;
            i++;
            j++;
        }
        //check south west
        i=row;
        j=col;
        while(i<n && j>=n){
            if(board[i][j]=='Q')return false;
            i++;
            j--;
        }
        //check north west
        i=row;
        j=col;
        while(i>=0 && j>=0){
            if(board[i][j]=='Q')return false;
            i--;
            j--;
        }
        return true;
    }
    
    
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        List<List<String>> ans = new ArrayList<>();

        NQueens(board,0,ans);
        return ans;
    }



} */
