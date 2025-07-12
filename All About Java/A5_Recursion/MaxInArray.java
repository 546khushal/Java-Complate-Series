public class MaxInArray{
    static void printArray(int arr[],int index){
        if(index==arr.length){
            return;
        }
        
        System.out.print(arr[index]+" ");
        printArray(arr,index+1);
    }
    
    static int Max_In_Array(int arr[],int index){
        if(index==arr.length-1)return arr[index];
        int maxInRest = Max_In_Array(arr,index+1);
        //return Math.max(arr[index],maxInRest);
        if(arr[index]>maxInRest){
            return arr[index];
        }else{
            return maxInRest;
        }
    }
    public static void main(String[] args){
        //Scanner sc = new Scanner(System.in);
        int[] arr ={22,5,18,21,9};
        printArray(arr,0);
        System.out.println("\n");
        System.out.println(Max_In_Array(arr,0));
    }
}