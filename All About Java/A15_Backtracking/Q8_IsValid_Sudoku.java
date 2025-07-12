/*Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition

Input: board = 
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true 
*/
//not backtracking here 
class Q8_IsValid_Sudoku{
    public static  boolean isValidSudoku(char[][] board){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]=='.')continue;
                char num=board[i][j];
                board[i][j]='.';
                if(isValid(board,i,j,num)==false)return false;
                board[i][j]=num;
            }
        }
        return true;

    }
    public static boolean isValid(char[][] board,int row,int col,char num){
        //check row
        for(int j=0;j<9;j++){
            if(board[row][j]==num)return false;
        }
        //check column
        for(int i=0;i<9;i++){
            if(board[i][col]==num)return false;
        }
        //check 3x3 box
        int startRow=row/3*3;
        int startCol=col/3*3;
        for(int i=startRow;i<startRow+3;i++){
            for(int j=startCol;j<startCol+3;j++){
                if(board[i][j]==num)return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        char[][] board = {
                        {'5','3','.','.','7','.','.','.','.'},
                        {'6','.','.','1','9','5','.','.','.'},
                        {'.','9','8','.','.','.','.','6','.'},
                        {'8','.','.','.','6','.','.','.','3'},
                        {'4','.','.','8','.','3','.','.','1'},
                        {'7','.','.','.','2','.','.','.','6'},
                        {'.','6','.','.','.','.','2','8','.'},
                        {'.','.','.','4','1','9','.','.','5'},
                        {'.','.','.','.','8','.','.','7','9'}
                    };
                    
        System.out.println(isValidSudoku(board));

    }
}