//Rate in a maze quetion 2 [4 direction ]
class Q2_FourDirectionMazePath{
    static int maze(int sr, int sc, int er, int ec, boolean[][] isVisited) {
            // Boundary check and visited check
            if(sr < 0 || sc < 0 || sr > er || sc > ec || isVisited[sr][sc]) 
                return 0;
                
            if(sr == er && sc == ec) 
                return 1;
            
            isVisited[sr][sc] = true;
            
            int down = maze(sr+1, sc, er, ec, isVisited);  // Down
            int right = maze(sr, sc+1, er, ec, isVisited); // Right
            int up = maze(sr-1, sc, er, ec, isVisited);    // Up
            int left = maze(sr, sc-1, er, ec, isVisited);  // Left
            
            isVisited[sr][sc] = false;  // Backtrack
            
            return down + right + up + left;
    }

    // Printing All Paths (Backtracking)
   static void print(int sr,int sc,int er,int ec,String s,boolean[][] isVisited){
        if(sr < 0 || sc < 0 || sr > er || sc > ec) return;  // Out of grid
        if(isVisited[sr][sc]) return;  // Already visited
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        isVisited[sr][sc] = true;

        //go right
        print(sr,sc+1,er,ec,s+"R",isVisited);
        //go down
        print(sr+1,sc,er,ec,s+"D",isVisited);
        //go left
        print(sr,sc-1,er,ec,s+"L",isVisited);
        //go up
        print(sr-1,sc,er,ec,s+"U",isVisited);
        //backtracking
        isVisited[sr][sc] = false;  // Backtrack: Unmark visited
   }
    

   
    public static void main(String[] args) {
        int rows = 3, cols = 3;
        boolean[][] isVisited = new boolean[rows][cols];
        
        // Count paths
        int totalPaths = maze(0, 0, rows-1, cols-1, isVisited);
        System.out.println("Total paths: " + totalPaths);
        
        // Print paths
        System.out.println("All paths:");
        print(0, 0, rows-1, cols-1, "", isVisited);
    }
}