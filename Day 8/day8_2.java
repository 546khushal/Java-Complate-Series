//  Raising a User-Defined Exception for Age Less Than 20

// User-defined exception for age validation
class InvalidAgeException extends Exception{
    public InvalidAgeException(String message){
    super(message);
    }
}
class Student{
    private int id;
    private String name;
    private int age;
    public Student(int id,String name,int age) throws InvalidAgeException{
        if(age<20){
            throw new InvalidAgeException("Age less then 20"); 
        }
        this.id=id;
        this.name=name;
        this.age=age;
    }
    public void display(){
        System.out.println("Student Id: "+ id +" Name: "+ name +" Age: "+age);
    }
}
public class day8_2{
    public static void main(String[] args){
        try{
            Student st=new Student(101,"Khushal",18);
            st.display();
        }catch(InvalidAgeException e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}