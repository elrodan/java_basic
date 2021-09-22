import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Company company = new Company();
        Operator operator = new Operator();

        for (int i = 0; i < 180; i++) {
            company.hire(new Operator());
        }
        List<Employee> workers = new ArrayList<>();
        for (int i = 0; i < 80; i++) {
            workers.add(new Manager());
        }

        for (int i = 0; i < 8; i++) {
            workers.add(new TopManager(company));
        }

        company.hireAll(workers);
        printEmployees(company);
        List<Employee> employees = company.getEmployees();

        for (int i = 0; i < employees.size()/2; i++) {
            company.fire(employees.get(i));
        }

        printEmployees(company);
    }

    private static void printEmployees(Company company) {
        System.out.println("Список самых высоких зарплат:");
        List<Employee> topSalaryStaff = company.getTopSalaryStaff(15);
        for (Employee e : topSalaryStaff) {
            System.out.println(e.getMonthSalary() + " руб.");
        }
        System.out.println(System.lineSeparator());
        System.out.println("Список самых низких зарплат:");
        List<Employee> lowSalaryStaff = company.getLowestSalaryStaff(30);
        for (Employee e : lowSalaryStaff) {
            System.out.println(e.getMonthSalary() + " руб.");
        }
        System.out.println(System.lineSeparator());
    }
}
