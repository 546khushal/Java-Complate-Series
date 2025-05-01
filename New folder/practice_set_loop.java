import java.util.*;
public class practice_set_loop{
    //1.......print pattern tringle rev
    static void pattern_tringle_r(int value){
        for(int i=value;i>=1;i--){
            for(int j=i;j>=1;j--){
            System.out.printf("*");
        }
        System.out.println("");
        }
        
    }
    //2.......sum first n even number using while loop
    static void sum_even(int num){
        int sum=0;
        int evennum=2;
        int count=0;
        while (count < num) {
            sum += evennum; // Add the current even number to sum
            count++;    // Increment the count
            evennum += 2;   // Move to the next even number
        }
        System.out.println("The sum of the first " + num + " even numbers is: " + sum);
  

    }
    //3......multiplication table
    static void table(long num){
        for(int i=1;i<=10;i++){
             System.out.printf("%2d x %2d = %3d%n", num, i, num * i);
        }
    }

    //4........factorial using for loop
    static void factorial(int a){
        if(a==0){
         System.out.printf("factorial of %d is: 1%n",a );
         return;
        }
       int facto=1;
        for (int i = 1; i <= a; i++) {
            facto *= i; // Update the factorial result
        }
        System.out.printf("Factorial of %d is: %d%n", a, facto);
    }

    //5.....sum of number occuring in the multiplication 8
    static void sum_multi_n(int n){
        int totalsum=0;
        for(int i=1;i<=n;i++){
            int multi=8*i;
            int sumofdigit=sumdigits(multi);
            System.out.printf("8 x %2d = %3d , sum of digit= %d%n",i,multi,sumofdigit);
            totalsum += sumofdigit;
        }
        System.out.println("total sum :"+totalsum);        
    } 
    static int sumdigits(int number){
        int sum=0;
        while(number!=0){
            sum+=number%10; //add last digist
            number /=10;  //remove last digit
        }
        return sum;
    }



    //6.....sum of series1-2+3-4+5...
    static void gseries(int n){
        int even=0;
        int odd=0;
        for(int  i=1;i<=n;i++){
        if(i%2==0){
            even += i;
        }
        else{
            odd +=i;
        }
        }
        int ans=odd-even;
        System.out.println(ans);
    }

    //7.....raise to the power a and b
    static void pwr(int a, int b){
        long i=1,ans=1;
        while(i<=b){
            ans *= a;
            i++;
        }
        System.out.println(ans);
    }


    //8.....pattern ractangle
    static  void pattern1(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=17;j++){
            System.out.printf("*");
        }
        System.out.println();
    }
    }

    //9.....pattern *******
    //              *     *
    //              *******
    static  void pattern2(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=17;j++){
            if(i==1 || i==n || j==1 || j==17){
            System.out.printf("*");
            }
            else{
               System.out.printf(" "); 
            }
        }
        System.out.println();
    }
    }

    //10.....tringle     *
    //                  ***
    static void tringle(int r){
        for(int i=1;i<=r;i++){
            for(int j=r;j>i;j--){
                System.out.print(" ");
                 }
                for(int p=1;p<=(2*i-1);p++){
                    System.out.print("*");
               
            }
            System.out.println();
        }
    }
    //11..... pattern3 1 2 1 2 1
    //                 2 1 2 1 2
    static void pattern3(int r){
        for(int i=1;i<=r;i++){
            for(int j=1;j<=5;j++){
                if((i+j)%2==0){
                System.out.print(" 1 ");
                }
                else{
                System.out.print(" 2 ");
                }
            }
            System.out.println();
        }
    }

    //12.....pattern4 123456
    //                234561
    static void pattern4(int n){
        for(int i=1;i<=n;i++){
            for(int j=i;j<=n;j++){
                System.out.print(j);
            }
             for(int k=1;k<=i;k++){
                System.out.print(k);
            }
            System.out.println();
        }
    }

    //13......pattern5    1
    //                   121
    //                  12321
    static void pattern5(int n){
        for(int i=1;i<=n;i++){
            for(int j=n;j>i;j--){
                System.out.print(" ");
            }
            for(int l=1;l<=i;l++){
                System.out.print(l);
            }
             for(int k=i-1;k>=1;k--){
                System.out.print(k);
            }
            
            System.out.println();
        }
    }

    //14.....pattern6 1
    //                12
    //                123
    static void pattern6(int r){
        for(int i=1;i<=r;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    //15.....pattern7    1
    //                 2   2
    static void pattern7(int r){
        for(int i=1;i<=r;i++){
            for(int j=r;j>i;j--){
                System.out.print(" ");
            }
            System.out.print(i);
            if (i == r) {
                for (int k = 1; k < r; k++) {
                    System.out.print(" " + i);
                }
            } else if (i > 1){
                for(int k=1; k < 2 * (i - 1);k++){
                        System.out.print(" ");
                }
                 System.out.print(i);
            }
             System.out.println();   
        }
    }




    //16...........fibonacci series
    static void fibonacci(int n){
        int n1=0, n2=1, next=0;
        
        System.out.print("Fibonacci series: " + n1 + " " + n2);
        for(int i=2;i<n;i++){
            next=n1+n2;
            System.out.print(" " + next);
            n1=n2;
            n2=next;
            }
        
        System.out.println();


    }

    







    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
    //1.......print pattern tringle rev
        // System.out.println("enter value for tringle reverse:");
        // int value = sc.nextInt();
        // pattern_tringle_r(value);
    //2.......sum first n even number using while loop
        // System.out.println("enter n number for sum :");
        // int num = sc.nextInt();
        // sum_even(num);

    //3......multiplication table
        // System.out.println("enter number to print table :");
        // Long num = sc.nextLong();
        // table(num);
    
    //4.......factorial using for loop
        // System.out.println("enter number to fing factorial :");
        // int n = sc.nextInt();
        // factorial(n);
    
    //5.....sum of number occuring in th multiplication n
        // System.out.println("enter number for limit :");
        // int n = sc.nextInt();
        // sum_multi_n(n);

        //SUM OF DIGIT
        // int ans= sumdigits(345);
        // System.out.println(ans);
    
    //6.....sum of series1-2+3-4+5...
        // gseries(9);
    
    //7.....raise to the power a and b
        // pwr(2,35);

    //8.....pattern ractangle
        //pattern1(4);
    
    //9.....pattern *******
    //              *     *
    //              *******
        // pattern2(7);

    //10.....tringle     *
    //                  ***
        //tringle(4);

    

    //11..... pattern3 1 2 1 2 1
    //                 2 1 2 1 2
        //pattern3(4);


    //12.....pattern4 123456
    //                234561
        //pattern4(5);



    //13......pattern5    1
    //                   121
    //                  12321
        //pattern5(6);


    //14.....pattern6 1
    //                12
    //                123
        //pattern6(4);

    

    //15.....pattern7    1
    //                 2   2
        //pattern7(4);


    //16...........fibonacci series
         fibonacci(45);
    

    }




}