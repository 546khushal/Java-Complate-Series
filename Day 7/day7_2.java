/*Create Interface Ione with class constant a having initial value 10.  
Create Interface Itwo with class constant b having initial value 20. 
Create Interface Ithree with class constant c having initial value 30. 
Interface Ithree must inherit Ione & Itwo (multiple inheritance).  
Crete class Test which implements Ithree. Test your program by creating an object of Test class and 
printing contents of a, b and c class constants.  */
interface Ione {
    int a = 10; // Class constant
}

interface Itwo {
    int b = 20; // Class constant
}

interface Ithree extends Ione, Itwo {
    int c = 30; // Class constant
}

class day7_2 implements Ithree {
    public void displayConstants() {
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        System.out.println("c: " + c);
    }

    public static void main(String[] args) {
        day7_2 obj = new day7_2();
        System.out.println("Testing Multiple Inheritance with Interfaces:");
        obj.displayConstants();
    }
}
