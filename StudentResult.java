import java.util.*;
class  Student
{
	
	String Sname;
	char Gender; 	
	int Rno,Sem,FCO,DBMS,CS,Total;
	float Per,Result;
	
	public void getData()	
	{
		Scanner sc= new Scanner(System.in);
		
		System.out.print("Enter Your RollNo  :");
		Rno= sc.nextInt();
		

		System.out.print("Enter Your Name :");
		sc.nextLine(); // Clear the leftover newline character
		Sname= sc.nextLine();
		
		System.out.print("Enter Your Gender :");
		Gender= sc.next().charAt(0);
		
		System.out.print("Enter Your Semester  :");
		Sem= sc.nextInt();
		
		System.out.print("Enter Mark FCO  :");
		FCO= sc.nextInt();
		
		System.out.print("Enter Mark DBMS  :");
		DBMS= sc.nextInt();
		
		System.out.print("Enter Mark CS  :");
		CS= sc.nextInt();
	}
	public void doTotal()
	{
			Total=FCO+DBMS+CS;
	}
	public void doPer()
	{
		Per=Total/3;
	}
	public void doResult()
	{
		System.out.println("========================================================================================================");
		System.out.println("RollNO                : "+ Rno);
		System.out.println("Student Name          : "+ Sname);
		System.out.println("Semester              : "+ Sem);
		System.out.println("Gender                : "+ Gender);
		System.out.println("========================================================================================================");
		
		System.out.println("DMBS          FCO         CS          TOTAL      Percenatage   ");
		System.out.println("========================================================================================================");
		System.out.println(DBMS + "             " + FCO + "          "+ CS +"            "+ Total +"           "+ Per);
		System.out.println("========================================================================================================");
		
	}
	
} 
class StudentResult
{
	public static void main(String[] args)
	{
		
		Student obj = new Student();
		obj.getData();
		obj.doTotal();
		obj.doPer();
		obj.doResult();
		
		Student obj2 = new Student();
		obj2.getData();
		obj2.doTotal();
		obj2.doPer();
		obj2.doResult();
		
		Student obj3 = new Student();
		obj3.getData();
		obj3.doTotal();
		obj3.doPer();
		obj3.doResult();
	}
}





