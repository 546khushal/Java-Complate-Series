//1...... string function
import java.util.*;
public class practice_set3_4{
    //1...... string function
    static void use_string_fn(){
        String name="   KHUSHAl suthar   ";
        System.out.println("Length:"+ name.length());
        System.out.println("Lower case:"+ name.toLowerCase());
        System.out.println("upper case:"+ name.toUpperCase());
        System.out.println("trim:"+ name.trim());
        System.out.println("sub string:"+ name.substring(8));
        System.out.println("sub string:"+ name.substring(8,15));
        System.out.println("replace:"+ name.replace('s','k'));
        System.out.println("startswith:"+ name.startsWith("vfd"));
        System.out.println("endswith:"+ name.endsWith("  "));
        System.out.println("charAt:"+ name.charAt(3));
        System.out.println("indexOf:"+ name.indexOf("K"));
        System.out.println("indexOf:"+ name.indexOf("K",5));
        System.out.println("lastindexOf:"+ name.lastIndexOf("suth"));
        System.out.println("lastindexOf:"+ name.lastIndexOf("suth",2));
        System.out.println("equals:"+ name.equals("suth"));
        System.out.println("lastindex \n Of:"); //newline
        System.out.println("lastindex\tOf:"); //tab
        System.out.println("brothor\'s:"); //singlequate
        System.out.println("lastindex \\ Of:"); //backslace
        String letter = "Dear Khushal,\n\n"  // Newline for paragraph spacing
                      + "\tThis Java course is nice.\n\n"  // Tab for indentation
                      + "Thanks,\n"
                      + "Your Name";
                      System.out.println(letter);
    }
    
    //calculate income tax paid by an employee to the govt.as pr 2.5-5.0L->5%, 5.0-10.0->20%,above->30%;
    static void tax(int salary){
        int tax=0;
        if(salary>250000 && salary<=500000 ){
            tax=(salary*5)/100;
        }
        else if(salary>500000 && salary<=1000000){
            tax=(salary*20)/100;
        }
        else if(salary>1000000){
            tax=(salary*30)/100;
        }
        System.out.println("Your Total Salary is:"+ salary);
        System.out.println("Tox paid to govtis:"+ tax);
        System.out.println("Your Salary after paid tax is:"+ (salary-tax));

    }
    //WAP to find out day of the week 1->monday,2->tuesday....
    static void weekdays(int d){
        String day;
        switch(d){
            case 1:
                day="Monday";
                break;
            case 2:
                day="Tuesday";
                break;
            case 3:
                day="wednesday";
                break;
            case 4:
                day="Thrusday";
                break;
            case 5:
                day="Friday";
                break;
            case 6:
                day="saturday";
                break;
            case 7:
                day="Sunday";   
                break; 
            default:
                day="invalid"; 
                break;           
        }
        System.out.println(day);
    }

    //4......check leap year
     static void leapyear(int year){
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                if (year % 400 == 0) {
                    System.out.printf("Year %d is a leap year!%n", year);
                } else {
                    System.out.printf("Year %d is not a leap year!%n", year);
                }
            } else {
                System.out.printf("Year %d is a leap year!%n", year);
            }
        } else {
            System.out.printf("Year %d is not a leap year!%n", year);
        }
    }
       
    


 

    
    public static void main(String[] args){
    //1...... string function
        use_string_fn();
    //2.....tax
        Scanner sc=new Scanner(System.in);
        // System.out.println("enter salary here:");
        // int t = sc.nextInt();
        // tax(t);  
    //3......... weekday
        // System.out.println("enter day(1-7)here:");
        // int wd=sc.nextInt();
        // weekdays(wd);

    //4.....check leapyear or nor
        System.out.println("enter year here to check leay year or not :");
        int y=sc.nextInt();
        leapyear(y);

    }
}