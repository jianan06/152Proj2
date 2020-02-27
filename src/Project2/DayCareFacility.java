package Project2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DayCareFacility {
    private ArrayList<Child> students = new ArrayList<Child>();
    private ArrayList<DayCareWorker> employees = new ArrayList<DayCareWorker>();
    private Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        var dayCareFacility = new DayCareFacility();
        dayCareFacility.runDayCare();


    }
    public void printMenu(){
        System.out.println("[1]Admit Child.");
        System.out.println("[2]Hire Worker");
        System.out.println("[3]Students Go To School");
        System.out.println("[4]Run Fire Drill");
        System.out.println("[5]End Program");
        System.out.println("[6]End of Year");
        System.out.println("[7]Do Accounting");
    }
    public void AdmitChild(Scanner inputReader) {
        if(employees.size()>=1) {
            System.out.println("What is the child's name?");
            var name = inputReader.nextLine();
            System.out.println("What is the child's age?");
            var age = inputReader.nextLine();
            System.out.println("Does the child have a sibling in the program? Y or N?");
            var answer = inputReader.nextLine();
            var check = false;
            if (answer.toLowerCase().equals("y")) {
                check = true;
            }
            Child child = new Child(name, check, Integer.parseInt(age));
            students.add(child);
            Random rand = new Random();
            var randNum = rand.nextInt(employees.size());
            employees.get(randNum).addChild(child);
        }
        else{
            System.out.println("You need to hire workers first.");
        }
    }
    private void hireWorker(){
        System.out.println("What is the name of the worker?");
        var name = reader.nextLine();
        System.out.println("What is the starting salary?");
        var startSalary = reader.nextLine();
        employees.add(new DayCareWorker(Integer.parseInt(startSalary),name));

    }
    private void studentgotoSchool(){
       for(DayCareWorker worker : employees){
           for(Child c : students){
               if(c.getAge()>=6) {
                   worker.RemoveChild(c.getID());
                   students.remove(c);
               }
           }

       }
    }
    private void runFireDrill(){
        for(DayCareWorker worker : employees)
            worker.performFireDrill();
    }
    private void endofYear(){
        for(int i = 0; i < students.size(); i++){
            students.get(i).setAge(students.get(i).getAge()+1);
            students.get(i).setYearsOfAttendance(students.get(i).getYearsOfAttendance()+1);
        }
        for(int j = 0; j < employees.size();j++){
            employees.get(j).performanceReview();
        }

    }
    private void doAccounting(){
        double totalBill = 0.0;
        double totalSalary = 0.0;
        for(Child children : students){
            totalBill= totalBill + children.calculateBill();
        }
        for(DayCareWorker dayCareWorker : employees){
            totalSalary = totalSalary + dayCareWorker.getSalary();
        }
        if(totalSalary < totalBill)
            System.out.println("We profited this year.");
        else
            System.out.println("We lost money this year.");
    }

    public void runDayCare(){
        Scanner inputReader = new Scanner(System.in);
        while(true) {
            printMenu();
            var answer = inputReader.nextLine();
            if (answer.equals("1")) {
                AdmitChild(inputReader);
            } else if (answer.equals("2")) {
                hireWorker();
            } else if (answer.equals("3")) {
                studentgotoSchool();
            } else if (answer.equals("4")) {
                runFireDrill();
            } else if (answer.equals("5")) {
                System.exit(0);
            } else if (answer.equals("6")) {
                endofYear();
            } else if (answer.equals("7")) {
                doAccounting();
            } else
                System.out.println("Invalid Input");
        }
    }

}
