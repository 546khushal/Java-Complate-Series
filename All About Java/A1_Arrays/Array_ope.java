/* Write a Java Program To find largest of three number
 Author Name: Khushal kumar
 Roll No : 30
 Enrollment No : 
 Date And Time Creation : 10-01-2025 05:33
 */
import java.util.*;  //* or Scanner
public class Array_ope// Class Created  named : NestedExample 
 {
	static final int SIZE = 50; // Define constant SIZE
    static int[] arr = new int[SIZE];
    static int size = 0;
	
	public static void Menu(){
		System.out.println("\nArray Operations Menu ");
		System.out.println("\n1.Read");
		System.out.println("\n2.Print");
		System.out.println("\n3.Insert");
		System.out.println("\n4.Delete");
		System.out.println("\n5.Search");
		System.out.println("\n6.Sort");
		System.out.println("\n7.Exit");
		System.out.print("\nEnter your Choice : ");
	}
    public static void InsertMenu(){
		System.out.println("\nArray Insert Operations Menu ");
		System.out.println("\n1.Insert at begin");
		System.out.println("\n2.Insert at last");
		System.out.println("\n3.Insert at position");
		System.out.println("\n4.Exit");
		System.out.print("\nEnter your Choice : ");
	}
    public static void DeleteMenu(){
		System.out.println("\nArray Delete Operations Menu ");
		System.out.println("\n1.Delete at begin");
		System.out.println("\n2.Delete at last");
		System.out.println("\n3.Delete at position");
		System.out.println("\n4.Exit");
		System.out.print("\nEnter your Choice : ");
	}
    public static void SearchMenu(){
		System.out.println("\nSearch Operations Menu ");
		System.out.println("\n1.Linear Search");
		System.out.println("\n2.Binary Search");
		System.out.println("\n3.Exit");
		System.out.print("\nEnter your Choice : ");
	}
    public static void SortMenu(){
		System.out.println("\nSort Operations Menu ");
		System.out.println("\n1.Bubble Sort");
		System.out.println("\n2.Selection Sort");
        System.out.println("\n3.Insertion Sort");
        System.out.println("\n4.Heap Sort");
        System.out.println("\n5.Quick Sort");
        System.out.println("\n6.Merge Sort");
		System.out.println("\n7.Exit");
		System.out.print("\nEnter your Choice : ");
	}
	
	 public static void Read(Scanner sc) {
        System.out.print("\nEnter the number of elements you want to insert (max " + SIZE + "): ");
        size = sc.nextInt();
        if (size > SIZE) {
            System.out.println("\nSize exceeds maximum array size!");
            size = 0;
            return;
        }

        System.out.println("\nEnter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
    }
	
	public static void Print() {
        if (size == 0) {
            System.out.println("\nNo elements in the array.");
        } else {
            System.out.println("\nArray elements are:");
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println(); // Move to the next line after printing
        }
    }

    public static void InsertBegin(Scanner sc){
         if (size >= arr.length) {
        System.out.println("Array is full! Cannot insert.");
        return;
        }
        System.out.print("Enter the Element :");
        int element=sc.nextInt();
        for(int i=size ; i>0;i--){
            arr[i]=arr[i-1];
        }
        arr[0]=element;
        size++;
        System.out.println("Element inserted at the beginning successfully.");
        Print();
    }
    public static void InsertEnd(Scanner sc){
        if(size>=arr.length){
            System.out.println("Array is full! Cannot insert.");
            return;
        }
        System.out.print("Enter the Element :");
        int element=sc.nextInt();
        arr[size]=element;
        size++;
        System.out.println("Element inserted at the end successfully.");
        Print();

    }

    public static void InsertAtPosition(Scanner sc){
        if(size>=arr.length){
            System.out.println("Array is full! Cannot insert.");
            return;
        }
        System.out.print("Enter the Position :");
        int pos=sc.nextInt();
        System.out.print("Enter the Element :");
        int element=sc.nextInt();
        for(int i=size;i>=pos;i--){
            arr[i]=arr[i-1];
        }
        arr[pos-1]=element;
        size++;
        System.out.println("Element inserted at the position" + pos +" successfully.");
        Print();
    }

    public static void DeleteBegin(){
        if(size==0){
            System.out.println("Array is Empty! Cannot delete.");
            return;
        }else{
        arr[0]=arr[1];
        for(int i=0;i<size;i++){
            arr[i+1]=arr[i+2];
        }
        size--;
        System.out.println("Element deleted from the beginning successfully.");
        Print();
        }
    }

    public static void DeleteEnd(){
         if(size==0){
            System.out.println("Array is Empty! Cannot delete.");
            return;
        }else{
            size--;
            System.out.println("Element deleted from the ending successfully.");
            Print();
        }
    }

    public static void DeleteAtPosition(Scanner sc) {
        if (size == 0) {
            System.out.println("Array is Empty! Cannot delete.");
            return;
        }

        System.out.print("Enter position to delete element (1 to " + size + "): ");
        int pos = sc.nextInt();
        if (pos < 1 || pos > size) {
            System.out.println("Invalid position! Please enter a position between 1 and " + size + ".");
            return;
        }

        // Convert 1-based position to 0-based index
        pos = pos - 1;
        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        size--; 
        System.out.println("Element deleted from position (" + (pos + 1) + ") successfully.");
        Print(); 
    }

    public static int LinearSearch(int element){
        for(int i=0;i<size;i++){
            if(arr[i]==element){
                return i+1;
            }
            
        }
        return -1;
    }

    public static int BinarySearch(int element){
        int left=0, right = size-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid]==element){
                return mid;
            }
            else if(arr[mid]<element){
                left = mid +1;
            }
            else{
                right=mid - 1;
            }
        }
        return -1;
    }

    public static void BubbleSort(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        Print();
    }
    public static void SelectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int min = i;  
            for (int j = i + 1; j < size; j++) {  
                if (arr[j] < arr[min]) {  
                    min = j;  
                }
            }
            if (min != i) {
                int temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
            }
        }   
        Print();
    }

    public static void InsertionSort() {
        for (int i = 1; i < size; i++) {
            int key = arr[i];  // The current element to be inserted
            int j = i - 1;

            // Move elements of arr[0..i-1] that are greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }

            // Place the key after the last element that was greater than key
            arr[j + 1] = key;
        }
    }

    public static void QuickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high); // Partitioning index
            QuickSort(arr, low, pi - 1);       // Recursively sort elements before partition
            QuickSort(arr, pi + 1, high);      // Recursively sort elements after partition
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // Choose the last element as pivot
        int i = (low - 1);     // Index of smaller element

        for (int j = low; j < high; j++) {
            // If current element is smaller than or equal to pivot
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }




public static void main(String[] args) //Main Method 15 ways to define
	{	int ch,ich,dch,sch,soch;
		Scanner sc =new Scanner(System.in);
		
	
	do{
		Menu();
		ch=sc.nextInt();
		switch(ch){
			case 1://Read
			Read(sc);
			break;
			case 2://Print
			Print();
			break;
			case 3://Insert
                do{
		            InsertMenu();
		            ich=sc.nextInt();
		            switch(ich){
			        case 1://insert first
                    InsertBegin(sc);
			        break;
			        case 2://insert last
                    InsertEnd(sc);
			        break;
			        case 3://Insert at position
                    InsertAtPosition(sc);
			        break;
			        case 4://Exit
			        System.out.println("\nThank You from Insert!");
			        break;	
			        default:
			        System.out.println("Invalid Day");
			        }
		        }while(ich!=4);
			break;
			case 4://Deletion
             do{
		            DeleteMenu();
		            dch=sc.nextInt();
		            switch(dch){
			        case 1://delete first
                    DeleteBegin();
			        break;
			        case 2://delete last
                    DeleteEnd();
			        break;
			        case 3://delete at position
                    DeleteAtPosition(sc);
			        break;
			        case 4://Exit
			        System.out.println("\nThank You from Delete!");
			        break;	
			        default:
			        System.out.println("Invalid Day");
			        }
		        }while(dch!=4);
			break;
			case 5://Search
            do{
		            SearchMenu();
		            sch=sc.nextInt();
		            switch(sch){
			        case 1://linear search
                    System.out.print("Enter Element to Search: ");
                    int element = sc.nextInt();
                    int res = LinearSearch(element);

                    if (res != -1) { 
                    System.out.println("Element present at position: " + res);
                    } else { 
                    System.out.println("Element Not Present");
                    }

                
			        break;
			        case 2://Binary search
                    System.out.print("Enter Element to Search: ");
                    int ele = sc.nextInt();
                    int result = BinarySearch(ele);

                    if (result != -1) { 
                    System.out.println("Element present at position: " + (result+1));
                    } else { 
                    System.out.println("Element Not Present");
                    }
			        break;
			        case 3://Exit
			        System.out.println("\nThank You from search!");
			        break;	
			        default:
			        System.out.println("Invalid Day");
			        }
		        }while(sch!=3);
			break;
			case 6://Sort
            do{
		            SortMenu();
		            soch=sc.nextInt();
		            switch(soch){
			        case 1://Bubble sort
                    BubbleSort();
			        break;
			        case 2://selection sort
                    SelectionSort();
			        break;
                    case 3://insertion sort
                    InsertionSort();
			        break;
                    case 4://heap sort
			        break;
                    case 5://quick sort
                    QuickSort(arr, 0, size - 1);
                    System.out.println("Array after Quick Sort:");
                    Print();
			        break;
                    case 6://merge sort
			        break;
			        case 7://Exit
			        System.out.println("\nThank You from sort!");
			        break;	
			        default:
			        System.out.println("Invalid Day");
			        }
		        }while(soch!=7);
			break;
			case 7://Exit
			System.out.println("\nThank You!");
			break;	
			default:
			System.out.println("Invalid Day");
			}
		}while(ch!=7);
	} 
 }
