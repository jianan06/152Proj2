package Project2;

import java.util.Random;

public class Child {
    public int age;
    public boolean siblingInProgram;
    public int yearsOfAttendance;
    public String Name;
    public int dayCareID;
    public static int nextID = 1000;


    public Child(String name, boolean sibInProg, int age){
        Name = name;
        siblingInProgram = sibInProg;
        this.age = age;
        yearsOfAttendance = 0;
        dayCareID = nextID;
        nextID++;

    }
    public String getName(){
        return Name;
    }

    public int getYearsOfAttendance() {
        return yearsOfAttendance = 0;
    }

    public int getDayCareID() {
        return nextID;
    }
    public double calculateBill(){
        double bill = 0.0;
        if (age<1) {
            bill = 400;
        }
        else if (age == 2){
            bill = 300;
        }
        else if (age<=4){
            bill = 200;
        }
        else{
            bill = 150;
        }
        if(siblingInProgram){
            bill = bill - (bill*.1);
            bill = bill - (yearsOfAttendance*10);
        }
        return bill;
    }

    public int getID() {
        return dayCareID;
    }
    public void setYearsOfAttendance(int newYear){
        yearsOfAttendance = newYear;
    }
    public void setAge(int newAge){
        age = newAge;
    }
    public int getAge(){
        return age;
    }
}
