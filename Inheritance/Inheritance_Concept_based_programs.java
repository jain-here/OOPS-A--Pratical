public class Inheritance_Concept_based_programs {

    public static void main(String[] args) {
        // --- Q17: Single Inheritance (Zoo Application) ---
        System.out.println("--- Q17: Single Inheritance (Zoo Application) ---");
        Lion myLion = new Lion();
        myLion.eat();   // Inherited from Animal
        myLion.roar();  // Specific to Lion
        System.out.println();

//================================================================================================

        // --- Q18: Single Inheritance (Vehicle System) ---
        System.out.println("--- Q18: Single Inheritance (Vehicle System) ---");
        Car myCar = new Car();
        myCar.move();       // Inherited from Vehicle
        myCar.fuelType();   // Specific to Car
        System.out.println("Inheritance promotes code reuse here by allowing Car to use the move() method from Vehicle without rewriting it.\n");

//================================================================================================



        // --- Q19: Multilevel Inheritance (Pet Management) ---
        System.out.println("--- Q19: Multilevel Inheritance (Pet Management) ---");
        Puppy myPuppy = new Puppy();
        myPuppy.eat();   // Inherited from Animal
        myPuppy.bark();  // Inherited from Dog
        myPuppy.weep();  // Specific to Puppy
        System.out.println();



        //================================================================================================



        // --- Q20: Multilevel Inheritance (Academic System) ---
        System.out.println("--- Q20: Multilevel Inheritance (Academic System) ---");
        GraduateStudent gradStudent = new GraduateStudent();
        gradStudent.name = "John Doe";
        gradStudent.studentID = "S12345";
        gradStudent.displayInfo(); // Overridden method shows all info
        gradStudent.submitThesis();
        System.out.println();

        //================================================================================================



        // --- Q21: Multilevel Inheritance (Smart Home) ---
        System.out.println("--- Q21: Multilevel Inheritance (Smart Home) ---");
        CeilingFan myFan = new CeilingFan();
        myFan.turnOn();     // Inherited from Appliance
        myFan.rotate();     // Inherited from Fan
        myFan.setSpeed(3);  // Specific to CeilingFan
        System.out.println("This design modularizes code by separating general appliance logic, fan-specific logic, and ceiling fan-specific logic into different classes.");
    }
}


//================================================================================================
//================================================================================================
//================================================================================================
//================================================================================================



// --- Q17 & Q19 Base Class ---
// Using a single Animal class for both Q17 and Q19 for efficiency
class Animal {
    void eat() {
        System.out.println("This animal eats food.");
    }
}

// --- Q17: Single Inheritance ---
class Lion extends Animal {
    void roar() {
        System.out.println("The lion roars.");
    }
}

// --- Q18: Single Inheritance ---
class Vehicle {
    void move() {
        System.out.println("This vehicle moves.");
    }
}

class Car extends Vehicle {
    void fuelType() {
        System.out.println("This car runs on gasoline.");
    }
}

// --- Q19: Multilevel Inheritance ---
class Dog extends Animal { // Level 1
    void bark() {
        System.out.println("The dog barks.");
    }
}

class Puppy extends Dog { // Level 2
    void weep() {
        System.out.println("The puppy weeps.");
    }
}

// --- Q20: Multilevel Inheritance ---
class Person { // Base Class
    String name;

    void displayInfo() {
        System.out.println("Name: " + name);
    }
}

class Student extends Person { // Level 1
    String studentID;

    @Override
    void displayInfo() {
        super.displayInfo(); // Call parent method
        System.out.println("Student ID: " + studentID);
    }
}

class GraduateStudent extends Student { // Level 2
    void submitThesis() {
        System.out.println("Thesis submitted.");
    }
}


// --- Q21: Multilevel Inheritance ---
class Appliance { // Base Class
    void turnOn() {
        System.out.println("Appliance is turned on.");
    }
}

class Fan extends Appliance { // Level 1
    void rotate() {
        System.out.println("Fan is rotating.");
    }
}

class CeilingFan extends Fan { // Level 2
    void setSpeed(int speed) {
        System.out.println("Ceiling fan speed set to " + speed);
    }
}