import java.util.*;
public class practice_set_array{
    //1.......count no. of accurence of element x in a given array
    static void count_in_array(int arr[],int x){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
                count++;
            }
            
        }
        System.out.println("Element " + x + " occurs " + count + " times in the array.");

    }


    //2......find last occurence of element index x in a given array
    static void last_occu(int arr[],int x){
        int last_index=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==x){
            last_index=i;
            }
        }
        System.out.println("The last occurrence of element " + x + " is at index " + last_index + ".");
    }

    //3.....count no. of element greater then x
    static void greater_check(int arr[],int x){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>x){
                count++;
            }
            
        }
        System.out.println("the "+ count +"element is greater then"+ x +".");
    }


    //4....check array sort or not
    static void array_check_sort(int arr[]){
        boolean issort=true;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i]>arr[i+1]){
                issort=false;
            }
            
        }
        if(issort){
            System.out.println("array is sorted! ");
        }
        else{
            System.out.println("array is not sorted! ");
            }
                 
    }

    //5......array sorting(bubble sort)
    static void array_sort(int arr[]){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-1-i;j++){
            if(arr[j]>arr[j+1]){
                int temp=arr[j];
                arr[j]=arr[j+1];
                arr[j+1]=temp;
            }
            }

        }
        for(int i=0;i<arr.length;i++){
        System.out.print(" "+ arr[i]);
        }
    }

    //6.......sum of array
    static void sum_array(int arr[]){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum =sum+ arr[i];
        }
        System.out.println("sum is:"+ sum);
    }

    //7.......max & min in array
    static void max_array(int arr[]){
        int max = Integer.MIN_VALUE; // Set max to the smallest possible integer
        int min = Integer.MAX_VALUE; // Set min to the largest possible integer
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
            
            
        }
        System.out.println("max is:"+max);
        System.out.println("max is:"+min);
    }

    //8......search in value 
        static void search_in_array(int arr[],int x){
            int ans=0;
            for(int i=0;i<arr.length;i++){
                if(arr[i]==x){
                    ans=i;
                }
            }
            System.out.println("found "+ x +" at index "+(ans+1) );
        }


    
    //9.......find total no. of pair in the array whose sum is equel to the given value x
        static void pair_sum(int arr[],int x){
            int ans=0;
            for(int i=0;i<arr.length;i++){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[i]+arr[j]==x){
                        ans++;
                    }
                }
            }
            System.out.println(ans +" pairs in array for target "+x);
        }

    //10......unique element in array
        static void unique(int arr[]){
            for(int i=0;i<arr.length;i++){
                for(int j=i+1;j<arr.length;j++){
                    if(arr[i]==arr[j]){
                        arr[i]=-1;
                        arr[j]=-1;
                    }
                }
            }
            int ans=-1;
            for(int i=0;i<arr.length;i++){  
                    if(arr[i]>0){
                        ans=arr[i];
                    }
                
            }
            System.out.println("unique element:" +ans);

        } 

    
    //11.....second largest value in array
    static void second_large(int arr[]){
        int max = Integer.MIN_VALUE; // Set max to the smallest possible integer
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        } 
        for(int j=0;j<arr.length;j++){
            if(arr[j]==max){
                arr[j]=Integer.MIN_VALUE;
            }
        }  
        int smax = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>smax){
                smax=arr[i];
            }
        } 
        System.out.println("second max value is: "+ smax);


         
    }



//12.........swap 2 number wiht temp and without temp 
    static void swap(int a,int b){
        System.out.println("before swap:"+ a+" "+b);
        int temp;
        temp=a;
        a=b;
        b=temp;
        System.out.println("After swap using temp:"+ a+" "+ b);
        a=a+b;
        b=a-b;
        a=a-b;
        System.out.println("After swap without temp:"+ a+" "+ b);
    }


    //13.....reverse an array(new array bnega usme reverse array store hoga)
      static void rev_array(int arr[]){
        int j=0;
        int n=arr.length;
        int ans[]=new int[n];
        for(int i=n-1;i>=0;i--){
          ans[j++]=arr[i];
        }
        System.out.println("New reverse array :");
        for(j=0;j<n;j++){
            System.out.print(ans[j]+" ");
        }
      }


    //14.....reverse an array(usi array mai reverse array store hoga)
    static void swapInArray(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
    }

    //15......rotate array by k step (k=3) 12345->34512 (here use extra space becouse we create a new array ans)
    static void  arrey__rotate_step(int arr[],int a){
        int n=arr.length;
        int k= a % n;
        int[] ans=new int[n];
        int j=0,i;
        for(i=n-k;i<n;i++){
            ans[j++]=arr[i];
        }
        for(i=0;i<n-k;i++){
            ans[j++]=arr[i];
        }
        System.out.print("new Rotate array: ");
        for(int p=0;p<n;p++){
            System.out.print(ans[p]+" ");
        }
    }


    //16......rotate array by k step (k=3) 12345->34512 (here use no extra space ->12|345 -> 21|543->54321)
    static void rotate_in_place(int arr[],int a){
        int n=arr.length;
        int k= a % n;
        rev_arr(arr,0,n-k-1);
        rev_arr(arr,n-k,n-1);
        rev_arr(arr,0,n-1);
    }
    static void rev_arr(int arr[],int i,int j){
        while(i<j){
            swapInArray(arr,i,j);  //already define swapInArray function above
            i++;
            j--;
        }
    }










    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        System.out.print("enter size for array:");
        int n=sc.nextInt();
        int [] arr=new int[n];
        System.out.print("enter the element of the array:");
        for(int i=0;i<arr.length;i++){
            System.out.print("\nenter "+ (i+1) +" Array element: ");
            arr[i]=sc.nextInt();
        }
    

    //1.......count no. of accurence of element x in a given array  
        // System.out.print("enter the element to check accurence in the array:"); 
        // int a=sc.nextInt();
        // count_in_array(arr,a);


    //2......find last occurence of element index x in a given array
        // System.out.print("enter element to check last accurence in the array:"); 
        // int a=sc.nextInt();
        // last_occu(arr,a);


    //3.....count no. of element greater then x
        // System.out.print("enter element  x to count greater in the array:"); 
        // int a=sc.nextInt();
        // greater_check(arr,a);


    //4......sort array sort or not 
       //array_check_sort(arr);  


    //5......array sorting
        //array_sort(arr); 

    //6.......sum of array
        //sum_array(arr);  

    //7....max & min in array
        //max_array(arr);

    //8......search in value 
        // System.out.print("enter element  x to search in the array:"); 
        // int a=sc.nextInt();
        // search_in_array(arr,a);

    //9........find total no. of pair in the array whose sum is equel to the given value x
        // System.out.print("enter element  target no. to find pair: "); 
        // int a=sc.nextInt();
        // pair_sum(arr,a);


    //10......unique element in array
        //unique(arr);

    //11.....second largest value in array
         //second_large(arr);

    //12.....swap 2 number wiht temp and without temp
        // System.out.print("enter 1st number: "); 
        // int a=sc.nextInt();
        // System.out.print("enter 2st number: "); 
        // int b=sc.nextInt();
        // swap(a,b);

    //13.....reverse an array
        //rev_array(arr);

    //14.....reverse an array(usi array mai reverse array store hoga)
        // int i=0,j=arr.length-1;
        // while(i<j){
        //     swapInArray(arr,i,j);
        //     i++;
        //     j--;
        // }
        // for(int k=0;k<arr.length;k++){
        //     System.out.print(arr[k]+" ");
        // }


    //15......rotate array by k step (k=3) 12345->34512
        // System.out.print("enter k for step : "); 
        // int k=sc.nextInt();
        // arrey__rotate_step(arr,k);

    //16......rotate array by k step (k=3) 12345->34512 (here use no extra space ->12|345 -> 21|543->54321)
        System.out.print("enter k for step : "); 
        int k=sc.nextInt();
        rotate_in_place(arr,k);
        for(int p=0;p<arr.length;p++){
           System.out.print(arr[p]+" ");
        }




    }

}