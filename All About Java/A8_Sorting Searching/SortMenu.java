/*
Algorithm    Worst     Average    Best       Space Complexity    Stable
Bubble       O(n^2)    O(n^2)     O(n)       O(1)                Yes
Selection    O(n^2)    O(n^2)     O(n^2)     O(1)                No
Insertion    O(n^2)    O(n^2)     O(n)       O(1)                Yes
Merge        O(nlogn)  O(nlogn)   O(nlogn)   O(n)                Yes
Quick        O(n^2)    O(nlogn)   O(nlogn)   O(logn)             No
Radix        O(nk)     O(nk)      O(nk)      O(n+k)              Yes
Count        O(n+k)    O(n+k)     O(n)       O(n+k)              Yes
*/
import java.util.Scanner;
public class SortMenu{
    static void Menu(){
        System.out.println("*******Sort Menu*******");
        System.out.println("1. Bubble Sort");
        System.out.println("2. Selection");
        System.out.println("3. Insertion Sort");
        System.out.println("4. Shell Sort");
        System.out.println("5.Heap Sort");
        System.out.println("6.Quick Sort");
        System.out.println("7.Merge Sort");
        System.out.println("8.Radix Sort");
        System.out.println("9.Count Sort");
        System.out.println("10. PrintArray");
        System.out.println("11. Exit");
        System.out.print("Enter your choice here: ");
    }
    static void PrintArray(int[] arr,int n){
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    /*SC->O(1) TC->O(n^2) worst,best,avg */
    //flag use krne se best case yadi already sorted hai to O(n)
    /*statble and unstable sort
                5 4 3 2 3'
    stable      2 3 3' 4 5  yha 3 phle wala phle aaya 
    unstable    2 3' 3 4 5  isme fix nhi khi bhi aa skta hai
     Bublle sort is stable algorithms kyu equality check nhi krte
     in-place algo bhi hai koi nya array nhi banaya
     */
    static void BubbleSort(int[] arr,int n){
        for(int i=0;i<n-1;i++){
            boolean flag= false;
            for(int j=0;j<n-i-1;j++){
                if(arr[j]>arr[j+1]){
                    flag=true;//some swap has happened
                    int tmp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
            if(flag==false){//have any swaps happended
                return;
            }
        }
    }
    /*SC->O(1) TC->O(n^2) worst,best,avg
    stable algo nhi hai kyuki order change kr skti hai
    in-place algo hai
     */
    static void SelectionSort(int[] arr,int n){
        int min;
        for(int i=0;i<n-1;i++){
            min=i;
            for(int j=i+1;j<n;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int tmp=arr[i];
            arr[i]=arr[min];
            arr[min]=tmp;
        }
    }
    //TC best case O(n),worst case O(n^2),avg case O(n^2)
    //SC->O(1)
    //stable yes,in-place yes
    static void InsertionSort(int[] arr,int n){
        int i,j,key;
        for(i=1;i<n;i++){
            j=i;
            key=arr[i];
            while(j>0 && key <arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            arr[j]=key;
        }
    }
    /* Shell Sort implementation
       - Optimized version of Insertion Sort using gaps
       - Best case: O(n log n)
       - Worst case: O(n^2)
    */
    static void ShellSort(int[] arr,int n){
        int i,j,key,increment=3;
        while(increment>0){
            for(i=1;i<n;i++){
                j=i;
                key=arr[i];
                while(j>=increment && key <arr[j-increment]){
                    arr[j]=arr[j-increment];
                    j=j-increment;
                }
                arr[j]=key;
            }
            increment=increment/2;
        }
    }
    static void BuildHeap(int[] a,int n){
        int i,s,f,key;
        for(i=1;i<n;i++){
            key=a[i];
            s=i;
            f=(s-1)/2;
            while(s>0 && key>a[f]){
                a[s]=a[f];
                s=f;
                f=(s-1)/2;
            }
            a[s]=key;
        }
    }
    /* Heap Sort implementation
       - In-place and unstable sorting algorithm
       - Time Complexity: O(n log n)
    */
    static void HeapSort(int[] a,int n){
        int i,s,f,ivalue;
        BuildHeap(a,n);
        for(i=n-1;i>0;i--){
            ivalue=a[i];
            a[i]=a[0];//move the largest element to the end
            f=0;
            if(i==1)
                s=-1;
            else
                s=1;
            if(i>2 && a[2]>a[1])
                s=2;
            //restore the heap property
            while(s>=0 && ivalue<a[s]){
                a[f]=a[s];
                f=s;
                s=2*f+1;//left child
                if((s+1<i)&& (a[s]<a[s+1]))//check right child
                    s++;
                if(s>=i)
                    s=-1;
            }
            a[f]=ivalue;
        }
    }
    /* Quick Sort implementation
       - In-place sorting algorithm
       - Best/Avg case: O(n log n)
       - Worst case: O(n^2) (rare, depends on pivot selection)
    */
    static void QuickSort(int a[],int left,int right){
        int pivot,l_hold,r_hold,pt;
        pivot=a[left];
        l_hold=left;
        r_hold=right;
        while(left<right){
            while(pivot<=a[right] && left!=right){
                right--;
            }
            if(left!=right){
                a[left]=a[right];
                left++;
            }
            while(pivot>=a[left] && left!=right){
                left++;
            }
            if(left!=right){
                a[right]=a[left];
                right--;
            }
        }
        a[left]=pivot;// Place the pivot in its correct position
        pt=left;// Partition index after placement
        left=l_hold;
        right=r_hold;
        if(left<pt){
            QuickSort(a,left,pt-1);
        }
        if(right>pt){
            QuickSort(a,pt+1,right);
        }
    }
    
    static void Merge(int a[],int temp[],int left,int mid,int right){
        int i=left,j=mid,k=left;
        while(i<mid && j<=right){
            if(a[i]<=a[j]){
                temp[k++]=a[i++];
            }else{
                temp[k++]=a[j++];
            }
        }
        while(i<mid){
            temp[k++]=a[i++];
        }
        while(j<=right){
            temp[k++]=a[j++];
        }
        for(i=left;i<=right;i++){
            a[i]=temp[i];
        }
    }
    /* Merge Sort implementation
       - Stable sorting algorithm
       - Time Complexity: O(n log n)
       - Space Complexity: O(n) 
       - Not in-place
    */
    static void MergeSort(int a[],int temp[],int left,int right){
        int mid;
        if(right>left){
            mid=(right+left)/2;
            MergeSort(a,temp,left,mid);
            MergeSort(a,temp,mid+1,right);
                Merge(a,temp,left,mid+1,right);
        }
    }
    static int Max_In_Array(int a[],int size){
        int i,max=0;
        for(i=0;i<size;i++){
            if(a[i]>max){
            max=a[i];
            }
        }
        return max;
    }
    static int FindDigits(int no){
        int r,count=0;
        while(no>0){
            no/=10;
            count++;
        }
        return count;

    }
    /* Radix Sort implementation
       - Non-comparison sorting algorithm
       - Not inplace becouse use extra memory
       - Time Complexity: O(n * k) where k is the number of digits in the largest number
    */
    static void RadixSort(int a[],int size){
        int i,j,k,pos,exp=1,index;
        int[][] Bucket= new int[10][50];
        int[] counter=new int[10];
        int maxNo=Max_In_Array(a,size);
	    int noOfDigits=FindDigits(maxNo);
        for(i=1;i<=noOfDigits;i++){
            for(j=0;j<10;j++){
                counter[j]=0;
            }

            for(j=0;j<size;j++){
                pos=(a[j]/exp)%10;
                Bucket[pos][counter[pos]++]=a[j];
            }

            k=0;
            for(j=0;j<10;j++){
                for( index=0;index<counter[j];index++) {
                    a[k++]=Bucket[j][index];
                }
            }

            exp*=10;
        }
    }

    static void BasicCountSort(int[] arr,int n){
        //find largest element in arr
        int max=Max_In_Array(arr,n);
        int[] count = new int[max+1];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        int k=0;
        for(int i=0;i<count.length;i++){
            for(int j=0;j<count[i];j++){
                arr[k++]=i;
            }
        }
    }
    //TC  worst case (n+k)
    //    avg case (n+k)
    //    best xase (n)
    //SC->(n+k)
    static void CountSort(int[] arr,int n){
        int[] output = new int[n];
        //find largest element in arr
        int max=Max_In_Array(arr,n);
        int[] count = new int[max+1];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        //make prefix sum array of count array
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];
        }
        //find the index of each element in the original array and put it in output array
        for(int i= n-1;i>=0;i--){
            int idx  = count[arr[i]]-1;
            output[idx]=arr[i];
            count[arr[i]]--;
        }
        //copy all element of output to arr
        for(int i=0;i<n;i++){
            arr[i]=output[i];
        }
    }



    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int ch;
        int[] arr={3,7,2,35,5,76,22};
        int[] temp=new int[arr.length];
        do{
            Menu();
            ch=sc.nextInt();
            switch(ch){
            case 1:
                BubbleSort(arr,arr.length);
                PrintArray(arr,arr.length);
                break;
            case 2:
                SelectionSort(arr,arr.length);
                PrintArray(arr,arr.length);
                break;
            case 3:
                InsertionSort(arr,arr.length);
                PrintArray(arr,arr.length);
                break;
            case 4:
                ShellSort(arr,arr.length);
                PrintArray(arr,arr.length);
                break;
            case 5:
                HeapSort(arr,arr.length);
                PrintArray(arr,arr.length);
                break;
            case 6:
                QuickSort(arr,0,arr.length-1);
                PrintArray(arr,arr.length);
                break;
            case 7:
                MergeSort(arr,temp,0,arr.length-1);
                PrintArray(arr,arr.length);
                break; 
            case 8:
                RadixSort(arr,arr.length);
                PrintArray(arr,arr.length);
                break;  
            case 9:
                CountSort(arr,arr.length);
                PrintArray(arr,arr.length);
                break;     
            case 10:
                PrintArray(arr,arr.length);
                break;
            case 11:
                break;
            default:
                System.out.println("Invalid Choice!");
        }
        }while(ch!=11);
    }
    
}
