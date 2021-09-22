public class Manager implements Employee {
    private int salary = 50000;
    private int sales;

    public Manager() {
        sales = (int) (Math.random() * (140000 - 115000) + 115000);
        salary += sales * 0.05;
    }

    public int getSales() {
        return sales;
    }

    @Override
    public int getMonthSalary() {
        return salary;
    }
}
