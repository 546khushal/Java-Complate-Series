Multilevel_Inheritance
/*
A class inherits from a class that has already inherited from another class.
(Grandparent → Parent → Child)
 */

class Animal{ 
    void eat(){System.out.println("eating...");} 
} 
class Dog extends Animal{ 
    void bark(){System.out.println("barking...");} 
} 
class BabyDog extends Dog{ 
    void weep(){System.out.println("weeping...");} 
} 
class Multilevel_Inheritance{
    public static void main(String args[]){ 
    BabyDog d=new BabyDog(); 
    d.weep(); 
    d.bark(); 
    d.eat(); 
    }
}

// Output:
// weeping... 
// barking... 
// eating... 