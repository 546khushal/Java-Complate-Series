/*Rat in a Maze quetion 3
A maze is an N*N binary matrix of blocks where the upper left block is known as the 
Source block , and the lower rightmost block is known as the Destination block.
if we consider the maze , then mza[0][0] is the Source and maze[N-1][N-1] is the
destination. Our main task is to reach the destination from the source. we have considered a  rat as a character that can move either forword or downwards.

in the maze matrix, a few dead bloack will be denoted by 0 and active block will
be denoted by 1. A rat can move only in the active blocks.

 */

class Q3_Rat_in_a_Maze{
    /**
     * Prints all possible paths from source (0,0) to destination (N-1,N-1)
     * @param sr - current row position (starts at 0)
     * @param sc - current column position (starts at 0)
     * @param er - destination row (N-1)
     * @param ec - destination column (N-1)
     * @param s - current path string (accumulates moves)
     * @param maze - the N*N grid with 0s (blocked) and 1s (open)
     */
    //normal recursion se hi huga kyuki isme koi 
    /*static void print(int sr,int sc,int er,int ec,String s,int[][] maze){
        // Base Case 1: If rat goes outside grid boundaries
        if(sr > er || sc > ec || sr < 0 || sc < 0) return;
        // Base Case 2: If rat reaches destination
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        // Base Case 3: If current cell is blocked (0)
        if(maze[sr][sc]==0)return;

         // Recursive Case 1: Move Right (R)
        print(sr,sc+1,er,ec,s+"R",maze);
        // Recursive Case 2: Move Down (D)
        print(sr+1,sc,er,ec,s+"D",maze);
    }*/

    //printBacktrack
    static void printBacktrack(int sr, int sc, int er, int ec, String s, int[][] maze, boolean[][] visited) {
        if(sr > er || sc > ec || sr < 0 || sc < 0) return;
        if(maze[sr][sc] == 0 || visited[sr][sc]) return; // Blocked or already visited
        if(sr == er && sc == ec) {
            System.out.println(s);
            return;
        }
        
        visited[sr][sc] = true; // Mark visited (State change)
        
        printBacktrack(sr+1, sc, er, ec, s+"D", maze, visited); // Down
        printBacktrack(sr, sc+1, er, ec, s+"R", maze, visited); // Right
        
        visited[sr][sc] = false; // Backtrack (Undo state change)
    }
     


    public static void main(String[] args) {
        int rows =4;
        int cols=6;
        int[][] maze ={{1,0,1,1,1,1},
                       {1,1,1,1,0,1},
                       {0,1,1,1,1,1},
                       {0,0,1,0,1,1}};
        //print(0,0,rows-1,cols-1,"",maze);

        
        boolean[][] visited=new boolean[rows][cols];
        printBacktrack(0,0,rows-1,cols-1,"",maze,visited);
    }

}