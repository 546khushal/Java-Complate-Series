package school;
import java.util.*;

abstract class Person{
    private String name;
    private int age;
    
    public Person(String name,int age){
        this.name = name;
        this.age=age;
    }

    //Encapsulation
    public String getName(){return name; }
    public int getAge(){ return age; }

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    
    //Abstract method
    public abstract void displayInfo();
}


