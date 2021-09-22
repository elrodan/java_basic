public class TopManager implements Employee {
    public static final int NECESSARY_INCOME = 10000000;
    private int salary = 60000;
    private Company company;

    public TopManager(Company company) {
        setCompany(company);
    }

    public int getMonthSalary() {
        if (company.getIncome() >= NECESSARY_INCOME) {
            return (int) (salary + (salary * 1.5));
        } else {
            return salary;
        }
    }

    @Override
    public void setCompany(Company company) {
        this.company = company;
    }
}
