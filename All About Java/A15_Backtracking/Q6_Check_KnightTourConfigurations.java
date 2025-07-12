//PW Skill lecture 64
/*
There is a knight on an n x n chessboard. In a valid configuration, 
the knight starts at the top-left cell of the board and visits every cell on the board exactly once.

You are given an n x n integer matrix grid consisting of distinct integers 
 the range [0, n * n - 1] where grid[row][col] indicates that the cell (row, col) is the grid[row][col]th cell that the knight visited. The moves are 0-indexed.

Return true if grid represents a valid configuration of the knight's movements or false otherwise.

Input: grid = [[0,11,16, 5,20],
               [17,4,19,10,15],
               [12,1, 8,21, 6],
               [3,18,23,14, 9],
               [24,13,2, 7,22]]
Output: true
Explanation: The above diagram represents the grid. It can be shown that it is a valid configuration.
 */
class Q6_Check_KnightTourConfigurations{
    public static  boolean checkValidGrid(int[][] grid){
        if(grid[0][0]!=0)return false;
        return helper(grid,0,0,0);
    }
    public static boolean helper(int[][] grid,int row,int col,int num){
        int n = grid.length;
        //base case
        if(grid[row][col]==n*n-1)return true;
        int i,j;
        //2 up 1 right
        i=row-2;
        j=col+1;
        if(i>=0 && j<n && grid[i][j]==num+1){
                    return helper(grid,i,j,num+1);
            }
        //2 up 1 left
        i=row-2;
        j=col-1;
        if(i>=0 && j>=0 && grid[i][j]==num+1){
                    return helper(grid,i,j,num+1);
            }
        
        //2 down 1 right
        i=row+2;
        j=col+1;
        if(i<n && j<n && grid[i][j]==num+1){
                    return helper(grid,i,j,num+1);
            }
        //2 down 1 left
        i=row+2;
        j=col-1;
        if(i<n && j>=0 && grid[i][j]==num+1){
                    return helper(grid,i,j,num+1);
            }
        //2 right 1 up
        i=row-1;
        j=col+2;
        if(i>=0 && j<n && grid[i][j]==num+1){
            return helper(grid,i,j,num+1);
        }
        //2 right 1 down
        i=row+1;
        j=col+2;
        if(i<n && j<n && grid[i][j]==num+1){
            return helper(grid,i,j,num+1);
        }

        //2 left 1 up
        i=row-1;
        j=col-2;
        if(i>=0 && j>=0 && grid[i][j]==num+1){
            return helper(grid,i,j,num+1);
        }
        //2 left 1 down
        i=row+1;
        j=col-2;
        if(i<n && j>=0 && grid[i][j]==num+1){
            return helper(grid,i,j,num+1);
        }
        return false;

    }
    
    public static void main(String[] args) {
        int[][] arr = { {0,11,16, 5,20},
                        {17,4,19,10,15},
                        {12,1, 8,21, 6},
                        {3,18,23,14, 9},
                        {24,13,2, 7,22}};
        System.out.println(checkValidGrid(arr));

    }

}
/*
    Position [0][0] (value 0)
        Checks all 8 possible knight moves for value 1
        Finds value 1 at [2][1] (2 down, 1 left)
        Recurses to [2][1]
    Position [2][1] (value 1)
        Checks for value 2
        Finds value 2 at [4][2] (2 down, 1 right)
        Recurses to [4][2]
    Position [4][2] (value 2)
        Checks for value 3
        Finds value 3 at [3][0] (1 up, 2 left)
        Recurses to [3][0]
    Position [3][0] (value 3)
        Checks for value 4
        Finds value 4 at [1][1] (2 up, 1 right)
        Recurses to [1][1]
    Position [1][1] (value 4)
        Checks for value 5
        Finds value 5 at [0][3] (1 up, 2 right)
        Recurses to [0][3]
    Position [0][3] (value 5)
        Checks for value 6
        Finds value 6 at [2][4] (2 down, 1 right)
        Recurses to [2][4]
    Position [2][4] (value 6)
        Checks for value 7
        Finds value 7 at [4][3] (2 down, 1 left)
        Recurses to [4][3]
    Position [4][3] (value 7)
        Checks for value 8
        Finds value 8 at [2][2] (2 up, 1 left)
        Recurses to [2][2]
    Position [2][2] (value 8)
        Checks for value 9
        Finds value 9 at [3][4] (1 down, 2 right)
        Recurses to [3][4]
    Position [3][4] (value 9)
        Checks for value 10
        Finds value 10 at [1][3] (2 up, 1 left)
        Recurses to [1][3]
    Position [1][3] (value 10)
        Checks for value 11
        Finds value 11 at [0][1] (1 up, 2 left)
        Recurses to [0][1]
    Position [0][1] (value 11)
        Checks for value 12
        Finds value 12 at [2][0] (2 down, 1 left)
        Recurses to [2][0]
    Position [2][0] (value 12)
        Checks for value 13
        Finds value 13 at [4][1] (2 down, 1 right)
        Recurses to [4][1]
    Position [4][1] (value 13)
        Checks for value 14
        Finds value 14 at [3][3] (1 up, 2 right)
        Recurses to [3][3]
    Position [3][3] (value 14)
        Checks for value 15
        Finds value 15 at [1][4] (2 up, 1 right)
        Recurses to [1][4]
    Position [1][4] (value 15)
        Checks for value 16
        Finds value 16 at [0][2] (1 up, 2 left)
        Recurses to [0][2]
    Position [0][2] (value 16)
        Checks for value 17
        Finds value 17 at [1][0] (1 down, 2 left)
        Recurses to [1][0]
    Position [1][0] (value 17)
        Checks for value 18
        Finds value 18 at [3][1] (2 down, 1 right)
        Recurses to [3][1]
    Position [3][1] (value 18)
        Checks for value 19
        Finds value 19 at [1][2] (2 up, 1 right)
        Recurses to [1][2]
    Position [1][2] (value 19)
        Checks for value 20
        Finds value 20 at [0][4] (1 up, 2 right)
        Recurses to [0][4]
    Position [0][4] (value 20)
        Checks for value 21
        Finds value 21 at [2][3] (2 down, 1 left)
        Recurses to [2][3]
    Position [2][3] (value 21)
        Checks for value 22
        Finds value 22 at [4][4] (2 down, 1 right)
        Recurses to [4][4]
    Position [4][4] (value 22)
        Checks for value 23
        Finds value 23 at [3][2] (1 up, 2 left)
        Recurses to [3][2]
    Position [3][2] (value 23)
        Checks for value 24 (n²-1 = 25-1 = 24)
        This is the last number, returns true */


/*public static boolean checkValidGrid(int[][] grid) {
    if(grid[0][0] != 0) return false;
    int n = grid.length;
    boolean[][] visited = new boolean[n][n];
    return backtrack(grid, visited, 0, 0, 0);
}

private static boolean backtrack(int[][] grid, boolean[][] visited, 
                               int row, int col, int num) {
    int n = grid.length;
    
    // Base case: all cells visited
    if(num == n*n - 1) return true;
    
    visited[row][col] = true;
    
    // All 8 possible knight moves
    int[][] moves = {{-2,1}, {-1,2}, {1,2}, {2,1}, 
                     {2,-1}, {1,-2}, {-1,-2}, {-2,-1}};
    
    for(int[] move : moves) {
        int newRow = row + move[0];
        int newCol = col + move[1];
        
        if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < n &&
           !visited[newRow][newCol] && grid[newRow][newCol] == num + 1) {
            if(backtrack(grid, visited, newRow, newCol, num + 1)) {
                return true;
            }
        }
    }
    
    visited[row][col] = false; // backtrack
    return false;
} */