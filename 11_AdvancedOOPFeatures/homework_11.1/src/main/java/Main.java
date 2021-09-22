package main.java;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Main {

    public static final String STAFF_TXT = "data/staff.txt";

    public static void main(String[] args) {
        List<Employee> staff = Employee.loadStaffFromFile(STAFF_TXT);
        System.out.println(staff);
    }

    public static void sortBySalaryAndAlphabet(List<Employee> staff) {
        staff.sort((o1, o2) -> Objects.equals(o1.getSalary(), o2.getSalary()) ? o1.getName().compareTo(o2.getName()) : o1.getSalary().compareTo(o2.getSalary()));
    }
}