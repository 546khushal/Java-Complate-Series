/**
 * ASSOCIATION: Relationship between objects.
 * Types:
 * 1. Aggregation (Weak HAS-A)
 * 2. Composition (Strong HAS-A)
 */


// Aggregation Example
/*2 object ke bhich normal connetion
dono object Independent rup se exist kr skte hai

    Teacher aur student dono alag-alag reh sakte hain
    Temporary relationship ho sakta hai (class ke baad connection khatam)
*/
class Doctor {
    void treat(Patient p) {
        System.out.println("Doctor ilaz kr rha hai");
    }
}

class Patient {
    void consult(Doctor d) {
        System.out.println("patient pramarsh le rha hai");
    }
}

//Aggregation (Weak "HAS-A")
/*
 Ek object dusre object ka use karta hai, par dono independent hain


    Engine car ke bina bhi reh sakta hai
    UML mein ise khalee diamond se dikhate hain
    Real-life example: Classroom aur students - classroom band hone par bhi students rehte hain
 */
class Engine {
    void start() {
        System.out.println("Engine start ho gaya");
    }
}

class Car {
    Engine e; // Car mein engine hai
    
    Car(Engine eng) {
        this.e = eng; // Engine bahar se aaya
    }
    
    void Drive() {
        e.start();
        System.out.println("Car chal rahi hai");
    }
}


// Composition (Strong "HAS-A")
/*
Ek object poori tarah dusre par depend karta hai

    Heart human ke bina exist nahi kar sakta
    UML mein ise bhare hue diamond se dikhate hain
    Real-life example: Tree aur leaves - tree katne par leaves khatam
 */
class Heart {
    void beat() {
        System.out.println("Dil dhadak raha hai");
    }
}

class Human {
    Heart h = new Heart(); // Human ke andar heart banega
    
    void live() {
        h.beat();
        System.out.println("Insaan zinda hai");
    }
}

public class Association {
    public static void main(String[] args) {
        Doctor d = new Doctor();
        Patient p = new Patient();
        d.treat(p);//Doctor ilaz kr rha hai
        p.consult(d);//patient pramarsh le rha hai

        
        // Aggregation
        Engine e = new Engine();// Pehle engine bana not output
        Car c = new Car(e); // Phir car mein daala not output
        c.Drive();//Engine start ho gaya
                //Car chal rahi hai
        
        // Composition
        Human h = new Human(); // Human banate hi uske andar heart bana
        h.live();
    }
}