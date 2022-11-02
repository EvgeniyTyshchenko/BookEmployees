import java.util.Objects;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook(Employee[] employees) {
        this.employees = employees;
    }
    EmployeeBook() {
        employees = new Employee[10];
        employees[0] = new Employee("Иванов Петр Сергеевич", "Отдел продаж", 85_570);
        employees[1] = new Employee("Романов Дмитрий Васильевич", "Отдел технического обслуживания оборудования", 60_390);
        employees[2] = new Employee("Мотько Татьяна Ивановна", "Отдел закупок", 110_800);
        employees[3] = new Employee("Назаров Роман Дмитриевич", "Отдел технического обслуживания оборудования", 70_140);
        employees[4] = new Employee("Костенко Виталий Владимирович", "Отдел рекламы и PR", 125_400);
        employees[5] = new Employee("Матвеенко Анастасия Витальевна", "Отдел кадров", 90_850);
        employees[6] = new Employee("Вильгельм Татьяна Викторовна", "Отдел закупок", 100_160);
        employees[7] = new Employee("Петров Владимир Игоревич", "Отдел продаж", 73_980);
        employees[8] = new Employee("Ларина Виктория Васильевна", "Отдел кадров", 93_260);
        employees[9] = new Employee("Рябинин Виктор Евгеньевич", "Отдел продаж", 105_170);
    }
    public void getListOfAllEmployees() {
        System.out.println("Cписок сотрудников со всеми имеющимися по ним данными:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
    public void сalculateTotalSalaryPayment() {
        double totalSalaryPayment = 0;
        for (int i = 0; i < employees.length; i++) {
            totalSalaryPayment = totalSalaryPayment + employees[i].getEmployeeSalary();
        }
        System.out.printf("%s: %.2f %s \n", "Cумма затрат на зарплаты в месяц", totalSalaryPayment, "руб.");
    }
    public void findEmployeeMinWage() {
        double minWage = employees[0].getEmployeeSalary();
        for (int i = 0; i < employees.length; i++) {
            if (minWage > employees[i].getEmployeeSalary()) {
                minWage = employees[i].getEmployeeSalary();
            }
        }
        System.out.printf("%s: %.2f %s \n", "Минимальная зарплата сотрудника", minWage, "руб.");
    }
    public void findEmployeeMaxWage() {
        double maxWage = employees[0].getEmployeeSalary();
        for (int i = 0; i < employees.length; i++) {
            if (maxWage < employees[i].getEmployeeSalary()) {
                maxWage = employees[i].getEmployeeSalary();
            }
        }
        System.out.printf("%s: %.2f %s \n", "Максимальная зарплата сотрудника", maxWage, "руб.");
    }
    public void calculateAverageSalary() {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getEmployeeSalary();
        }
        System.out.printf("%s: %.2f %s \n", "Среднее значение зарплат", sum / employees.length, "руб.");
    }
    public void getFullNameOfAllEmployees() {
        System.out.println("ФИО всех сотрудников:");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getId() + ": " + employees[i].getFullName());
        }
    }
    public double getSalaryIndexation(double index) {
        System.out.println("Индексация заработной платы на " + index + " %");
        index = index / 100 + 1;
        for (int i = 0; i < employees.length; i++) {
            employees[i].setEmployeeSalary(employees[i].getEmployeeSalary() * index);
        }
        return index;
    }
    public Employee[] showDepartment (String requiredDepartment) {
        ArrayList<Employee> employeeOFDepartment = new ArrayList<Employee>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment().equals(requiredDepartment)) {
                employeeOFDepartment.add(employees[i]);
            }
        }
        Employee[] department = employeeOFDepartment.toArray(new Employee[0]);
        return department;
    }
    public void getNamesEmployeesFromDepartment(String requiredDepartment) {
        System.out.printf("%s%s%s \n", "Все сотрудники выбранного отдела (", requiredDepartment, "):");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getDepartment().equals(requiredDepartment)) {
                System.out.printf("%s: %s, %.2f %s \n",  employees[i].getId(), employees[i].getFullName(), employees[i].getEmployeeSalary(), "руб.");
            }
        }
    }
    public void findEmployeesWithSalaryBelowSpecified(double employeeSalary) {
        System.out.printf("%s %.2f %s \n", "Все сотрудники с зарплатой меньше", employeeSalary, "руб.:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getEmployeeSalary() < employeeSalary) {
                System.out.printf("%s: %s, %.2f \n",  employees[i].getId(), employees[i].getFullName(), employees[i].getEmployeeSalary());
            }
        }
    }
    public void findEmployeesWithSalaryHigherSpecified(double employeeSalary) {
        System.out.printf("%s %.2f %s \n", "Все сотрудники с зарплатой выше", employeeSalary, "руб.:");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getEmployeeSalary() >= employeeSalary) {
                System.out.printf("%s: %s, %.2f \n",  employees[i].getId(), employees[i].getFullName(), employees[i].getEmployeeSalary());
            }
        }
    }
    public void addNewEmployee(String fullName, String department, double employeeSalary) {
        System.out.printf("%s: %s%s %s%s%.2f %s \n", "Трудоустроился", fullName, ", в", department, ", заработная плата ", employeeSalary, "руб.");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                Employee newEmployee = new Employee(fullName, department, employeeSalary);
                employees[i] = newEmployee;
            }
        }
    }
    public void deleteEmployee(String fullName) {
        System.out.println("Уволился: " + fullName);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i] = null;
            }
        }
    }
    public void changeEmployeeSalary(String fullName, double employeeSalary) {
        System.out.printf("%s %s%s %.2f %s \n", "У сотрудника", fullName, ", изменена заработная плата. Фактическая оплата труда составляет:", employeeSalary, "руб.");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i].setEmployeeSalary(employeeSalary);
            }
        }
    }
    public void changeEmployeeDepartment(String fullName, String department) {
        System.out.println("Сотрудник " + fullName + " переведён в " + department);
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getFullName().equals(fullName)) {
                employees[i].setDepartment(department);
            }
        }
    }
    public void getEmployeeNamesByDepartments() {
        HashSet<String> department = new HashSet<>();
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                department.add(employees[i].getDepartment());
            }
        }
        for (String str : department) {
            System.out.println(str + ":");
            new EmployeeBook(showDepartment(str)).getListOfAllEmployees();
        }
    }
    @Override
    public String toString() {
        return Arrays.toString(employees);
    }
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        EmployeeBook employeeBook = (EmployeeBook) object;
        return Arrays.equals(employees, employeeBook.employees);
    }
    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }
}