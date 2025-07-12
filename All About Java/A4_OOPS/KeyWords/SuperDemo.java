/*
The super keyword in java is a reference variable which is used to refer immediate parent class 
object. 
Usage of java super Keyword 
    1. super can be used to refer immediate parent class instance variable. 
    2. super can be used to invoke immediate parent class method. 
    3. super() can be used to invoke immediate parent class constructor. 
 */
class Animal{ 
String color="white"; 
} 
class Dog extends Animal{ 
    String color="black"; 
    void printColor(){ 
        System.out.println(color);//prints color of Dog class 
        System.out.println(super.color);//prints color of Animal class 
    } 
} 
class SuperDemo{ 
    public static void main(String args[]){ 
        Dog d=new Dog(); 
        d.printColor(); 
    }
} 
//output
// black
// white