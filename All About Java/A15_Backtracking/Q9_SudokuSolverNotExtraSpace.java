class Q9_SudokuSolverNotExtraSpace{
    static int check=0;
    public static void solveSudoku(char[][] board) {
    //char[][] grid = new char[9][9];
    //solve(board,0,0,grid);
    solve(board,0,0);
    check=0;
    /*for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                board[i][j]=grid[i][j];
            }
        }
    */
   }
   public static void solve(char[][] board,int row,int col){
    if(row==9){//is time pr bard is full and perfect
        check=1;
        /*for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                grid[i][j]=board[i][j];
            }
        }*/
        return;
    }
    else if(board[row][col]!='.'){
       if(col!=8) solve(board,row,col+1);
       else solve(board,row+1,0);
    }else{//board[row][col]=='.'
        for(char ch='1';ch<='9';ch++){
            if(isValid(board,row,col,ch)){
                board[row][col]=ch;
                if(col!=8) solve(board,row,col+1);
                else solve(board,row+1,0);
                if(check==1)return;
                board[row][col]='.';//backtracking
            }
        }
    }
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
    
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            System.out.print(board[i][j]+" ");
        }
        System.out.println();
    }
    System.out.println();
    
    solveSudoku(board);
    for(int i=0;i<9;i++){
        for(int j=0;j<9;j++){
            System.out.print(board[i][j]+" ");
        }
         System.out.println();
    }
    System.out.println();
    
    }
}