/*
function call itselt with diffrent parameter
The Recursion Spell
1-> Identify the smaller problem->let recursion solve it
2-> self work -> Do your Work
3->Identify the base case->Smallest problem for which the answer is obvious

*/



import java.util.*;
public class print_inc{
    static void printIncreasing(int n){
        if(n==1){
            System.out.println(n);
            return;
        }
        printIncreasing(n-1);
        System.out.println(n);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        printIncreasing(n);
    }
}