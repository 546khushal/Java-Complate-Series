/* Write a Java Program To find largest of three number
 Author Name: Khushal kumar
 Roll No : 30
 Enrollment No : 
 Date And Time Creation : 10-01-2025 05:33
 */
import java.util.*;  //* or Scanner

public class Array_Opeartion // Class Created  named : NestedExample 
 {
	static int[] arr =new int[10];
	static int size=0;
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
	
	public static void Read(Scanner sc){
		if(size>=arr.length){
			System.out.println("\nArray is  Full! you Can't  insert value");
		}else{
			System.out.print("\nEnter element to insert : ");
			int element=sc.nextInt();	
			arr[size]=element;
			size++;
		}
	}
	
	public static void Print(){
		if(arr.length<=0){
			System.out.println("\nNo element In array");
		}else{
			for(int i=0;i<size;i++){
				System.out.print(arr[i]+" ");
			}
			//System.out.println();
		}
	}

public static void main(String[] args) //Main Method 15 ways to define
	{	int ch;
		
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
			break;
			case 4://Deletion
			break;
			case 5://Search
			break;
			case 6://Sort
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
