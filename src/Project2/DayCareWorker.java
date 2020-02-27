package Project2;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class DayCareWorker {
    private String Name;
    private float salary;
    private ArrayList<Child> childrenInGroup = new ArrayList<Child>();

    public String getName() {
        return Name;
    }

    public float getSalary() {
        return salary;
    }

    public DayCareWorker(float startingPay, String name) {
        Name = name;
        salary = startingPay;
    }

    public boolean addChild(Child child) {
        childrenInGroup.add(child);
        return true;
    }

    public Optional<Child> RemoveChild(int ID) {
       for(Child c : childrenInGroup){
           if(c.getID() == ID){
               childrenInGroup.remove(c);
               return Optional.of(c);
           }
       }
       return Optional.empty();
    }

    public void performanceReview() {
        var random = new Random();
        var performance = random.nextInt(6);
        if (performance == 1) {
            salary = salary + (salary * (float) 1);
        } else if (performance == 2) {
            salary = salary + (salary * (float) .01);
        } else if (performance == 3) {
            salary = salary + (salary * (float) .025);
        } else if (performance == 4) {
            salary = salary + (salary * (float) .035);
        } else if (performance == 5) {
            salary = salary + (salary * (float) .05);
        }
    }

    public void performFireDrill() {
        for (int i = 0; i < childrenInGroup.size(); i++) {
            System.out.println(childrenInGroup.get(i).getName() + " is safe");
        }
        System.out.println("They are all safe");
    }
}
