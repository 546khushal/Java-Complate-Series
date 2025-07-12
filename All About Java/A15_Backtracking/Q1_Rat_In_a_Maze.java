//rat in a maze quetion 1 [2 direction]
class Q1_Rat_In_a_Maze{

    //Counting Paths (Recursive Solution)
    static int maze(int sr,int sc,int er,int ec){
        if(sr>er || sc>ec)return 0;
        if(sr==er && sc==ec)return 1;
        int downWays = maze(sr+1,sc,er,ec); // Recursive Call: Move Down
        int rightWays = maze(sr,sc+1,er,ec);// Recursive Call: Move Right
        int totalWays = downWays + rightWays;
        return totalWays;
    }

    // Printing All Paths (Backtracking)
   static void print(int sr,int sc,int er,int ec,String s){
        if(sr>er || sc>ec)return;
        if(sr==er && sc==ec){
            System.out.println(s);
            return;
        }
        //go right
        print(sr,sc+1,er,ec,s+"R");
        //go down
        print(sr+1,sc,er,ec,s+"D");
   }
    

   
    public static void main(String[] args) {
        int rows =3;
        int cols = 3;
        int count = maze(1,1,rows,cols);
        System.out.println(count);

        print(1,1,rows,cols,"");
    }
}


/*
Recursion ek aisa process hai jisme:
    Ek function khud ko call karta hai (repeatedly)
    Base case pe rukta hai (jaise sr == er)
    Return value ka use karke result calculate karta hai
    
Backtracking recursion ka advanced version hai, jisme:
    Har possible path try kiya jata hai
    Agar path invalid hai → wapas aate hain (backtrack)
    "State" ko modify karke try karte hain
 */