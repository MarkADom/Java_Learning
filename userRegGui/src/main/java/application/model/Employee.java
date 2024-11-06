package application.model;
import javafx.beans.property.*;
import java.sql.Date;

public class Employee {

    //Declare Employees Table Columns
    private IntegerProperty employee_id;
    private StringProperty first_name;
    private StringProperty last_name;
    private StringProperty email;
    private StringProperty phone_number;
    private SimpleObjectProperty<Date> hire_date;
    private StringProperty job_id;
    private IntegerProperty salary;
    private DoubleProperty commission_pct;
    private IntegerProperty manager_id;
    private IntegerProperty department_id;

    //Constructor
    public Employee() {
        this.employee_id = new SimpleIntegerProperty();
        this.first_name = new SimpleStringProperty();
        this.last_name = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.phone_number = new SimpleStringProperty();
        this.hire_date = new SimpleObjectProperty<Date>();
        this.job_id = new SimpleStringProperty();
        this.salary = new SimpleIntegerProperty();
        this.commission_pct = new SimpleDoubleProperty();
        this.manager_id = new SimpleIntegerProperty();
        this.department_id  =new SimpleIntegerProperty();
    }

    //employee_id
    public int getEmployee_id() {
        return employee_id.get();
    }

    public IntegerProperty employee_idProperty() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id.set(employee_id);
    }

    //first_name
    public String getFirst_name() {
        return first_name.get();
    }

    public StringProperty first_nameProperty() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name.set(first_name);
    }

    //last_name
    public String getLast_name() {
        return last_name.get();
    }

    public StringProperty last_nameProperty() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name.set(last_name);
    }

    //email
    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    //phone_number
    public String getPhone_number() {
        return phone_number.get();
    }

    public StringProperty phone_numberProperty() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number.set(phone_number);
    }

    //hire_date
    public Date getHire_date() {
        return hire_date.get();
    }

    public SimpleObjectProperty<Date> hire_dateProperty() {
        return hire_date;
    }

    public void setHire_date(Date hire_date) {
        this.hire_date.set(hire_date);
    }

    //job_id
    public String getJob_id() {
        return job_id.get();
    }

    public StringProperty job_idProperty() {
        return job_id;
    }

    public void setJob_id(String job_id) {
        this.job_id.set(job_id);
    }

    //salary
    public int getSalary() {
        return salary.get();
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

    //commission_pct
    public double getCommission_pct() {
        return commission_pct.get();
    }

    public DoubleProperty commission_pctProperty() {
        return commission_pct;
    }

    public void setCommission_pct(double commission_pct) {
        this.commission_pct.set(commission_pct);
    }

    //manager_id
    public int getManager_id() {
        return manager_id.get();
    }

    public IntegerProperty manager_idProperty() {
        return manager_id;
    }

    public void setManager_id(int manager_id) {
        this.manager_id.set(manager_id);
    }

    //department_id
    public int getDepartment_id() {
        return department_id.get();
    }

    public IntegerProperty department_idProperty() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id.set(department_id);
    }

}


