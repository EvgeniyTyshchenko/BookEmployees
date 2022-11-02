import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        EmployeeBook employeeBook = new EmployeeBook();

        // Базовая сложность

        employeeBook.getListOfAllEmployees();
        System.out.println("---------");
        employeeBook.сalculateTotalSalaryPayment();
        employeeBook.findEmployeeMinWage();
        employeeBook.findEmployeeMaxWage();
        employeeBook.calculateAverageSalary();
        System.out.println("---------");
        employeeBook.getFullNameOfAllEmployees();
        System.out.println("---------");

        // Повышенная сложность

        Employee[] listOfDepartment = employeeBook.showDepartment("Отдел продаж");
        EmployeeBook employeeBook1 = new EmployeeBook(listOfDepartment);
        System.out.println("Сотрудники работающие в выбранном отделе " + Arrays.toString(listOfDepartment));
        System.out.println("---------");
        employeeBook1.findEmployeeMinWage();
        employeeBook1.findEmployeeMaxWage();
        employeeBook1.сalculateTotalSalaryPayment();
        employeeBook1.calculateAverageSalary();
        System.out.println("---------");
        employeeBook1.getSalaryIndexation(1);
        employeeBook1.getListOfAllEmployees();
        employeeBook1.getNamesEmployeesFromDepartment("Отдел продаж");
        System.out.println("---------");
        employeeBook.getSalaryIndexation(3);
        employeeBook.getListOfAllEmployees();
        System.out.println("---------");
        employeeBook.findEmployeesWithSalaryBelowSpecified(85_000);
        System.out.println();
        employeeBook.findEmployeesWithSalaryHigherSpecified(100_000);

        // Очень сложно

        System.out.println("---------");
        employeeBook.deleteEmployee("Петров Владимир Игоревич");
        employeeBook.getListOfAllEmployees();
        System.out.println("---------");
        employeeBook.addNewEmployee("Зубакин Валентин Фёдорович", "Отдел продаж", 75_000);
        employeeBook.getListOfAllEmployees();
        System.out.println("---------");
        employeeBook.changeEmployeeSalary("Иванов Петр Сергеевич", 110_000);
        employeeBook.getListOfAllEmployees();
        System.out.println("---------");
        employeeBook.changeEmployeeDepartment("Рябинин Виктор Евгеньевич", "Отдел закупок");
        employeeBook.getListOfAllEmployees();
        System.out.println("---------");
        employeeBook.getEmployeeNamesByDepartments();
    }
}