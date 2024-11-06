package entities;

import entities.enums.WorkerLevel;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    //Basic attributes
    private String name;
    private WorkerLevel level;
    private Double baseSalary;

    //Class association
    private Department department;

    //List instantiation: new arraylist on the attribute declaration
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public Department getDepartment() {
        return department;
    }

    //add the contract argument from the method to the list of contracts
    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    //remove the contract argument from the method to the list of contracts
    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income(int year, int month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for(HourContract c : contracts){
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month  = 1 + cal.get(Calendar.MONTH);
            if(year == c_year && month == c_month) {
                sum+= c.totalValue();
            }
        }
        return sum;
    }

}
