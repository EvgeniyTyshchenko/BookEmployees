import java.util.Objects;

public class Employee {
    private final String fullName;
    private String department;
    private double employeeSalary;
    private static int counter = 1;
    private final int id;

    public Employee (String fullName, String department, double employeeSalary) {
        this.fullName = fullName;
        this.department = department;
        this.employeeSalary = employeeSalary;
        id = counter;
        counter ++;
    }

    public String getFullName() {
        return fullName;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public double getEmployeeSalary() {
        return employeeSalary;
    }
    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }
    public int getCounter() {
        return counter;
    }
    public int getId() {
        return id;
    }
    @Override
    public String toString() {
        return String.format("%d: %s, %s, %.2f %s", getId(), getFullName(), getDepartment(), getEmployeeSalary(),"руб.");
    }
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Employee employee = (Employee) object;
        return fullName.equals(employee.fullName) && department.equals((employee.department)) && employeeSalary == employee.employeeSalary && id == employee.id;
    }
    @Override
    public int hashCode() {
        return Objects.hash(fullName, department, employeeSalary, id);
    }
}