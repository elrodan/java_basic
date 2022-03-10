<<<<<<< HEAD
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

=======
>>>>>>> parent of af1f74c (15.9 Практическая работа №3)
public class Movements {

    public Movements(String pathMovementsCsv) {
    }

    public double getExpenseSum() {
        return 0.0;
    }

    public double getIncomeSum() {
<<<<<<< HEAD
        return getSum(6);
    }

    private void parseLines() {
        try {
            parseLines = Files.lines(Paths.get(pathMovementsCsv))
                    .skip(1)
                    .map(l -> l.replaceAll("\"(\\d+),(\\d+)\"", "$1.$2")
                            .split(",", 8))
                    .collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double getSum(int index) {
        return parseLines
                .stream()
                .mapToDouble(l -> Double.parseDouble(l[index]))
                .sum();
    }

    public BankStatement getBankStatement() {
        return bankStatement;
    }

    private void setBankStatement() {
        bankStatement.setExpenseSum(getExpenseSum());
        bankStatement.setIncomeSum(getIncomeSum());
        HashMap<String, Double> list = new HashMap<>();
        for (String[] l : parseLines) {
            if (!l[7].equals("0")) {
                if (list.containsKey(l[5].split("\\s{4}")[1].trim())) {
                    list.put(l[5].split("\\s{4}")[1].trim(), list.get(l[5].split("\\s{4}")[1].trim()) + Double.parseDouble(l[7]));
                } else {
                    list.put(l[5].split("\\s{4}")[1].trim(), Double.parseDouble(l[7]));
                }
            }
        }
        bankStatement.setOrganizationsExpense(list);
=======
        return 0.0;
>>>>>>> parent of af1f74c (15.9 Практическая работа №3)
    }
}
