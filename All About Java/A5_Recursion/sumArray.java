public class sumArray{
    static void printArray(int arr[],int index){
        if(index==arr.length){
            return;
        }
        
        System.out.print(arr[index]+" ");
        printArray(arr,index+1);
    }
    
    static int sumArray(int arr[],int index){
        if(index==arr.length-1)return arr[index];
        return sumArray(arr,index+1)+arr[index];
    }
    public static void main(String[] args){
        //Scanner sc = new Scanner(System.in);
        int[] arr ={2,5,3,1,9};
        printArray(arr,0);
        System.out.println("\n");
        System.out.println(sumArray(arr,0));
    }
}