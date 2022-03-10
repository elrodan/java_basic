import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Movements {

    private String pathMovementsCsv;
    private List<String[]> parseLines;
    private BankStatement bankStatement;

    public Movements(String pathMovementsCsv) {
        this.pathMovementsCsv = pathMovementsCsv;
        parseLines();
        bankStatement = new BankStatement();
        setBankStatement();
    }

    public double getExpenseSum() {
        return getSum(7);
    }

    public double getIncomeSum() {
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
    }
}
