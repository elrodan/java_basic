import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movements {
    private ArrayList<String> accountType = new ArrayList<>();
    private ArrayList<String> accountNumber = new ArrayList<>();
    private ArrayList<String> currency = new ArrayList<>();
    private ArrayList<String> operationDate = new ArrayList<>();
    private ArrayList<String> transactionReference = new ArrayList<>();
    private final ArrayList<String> operationDescription = new ArrayList<>();
    private final ArrayList<String> income = new ArrayList<>();
    private final ArrayList<String> expense = new ArrayList<>();


    private static final String pathMovementsCsv = "C:\\Users\\elrod\\IdeaProjects\\java_basics\\13_FilesAndNetwork\\homework_13.3\\src\\test\\resources\\movementListFloat.csv";

    public Movements(String pathMovementsCsv) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(pathMovementsCsv));
            lines.remove(0);
            for (String line : lines) {
                String[] fragments = line.split("\\,");
                ArrayList<String> columnList = new ArrayList<>();
                for (int i = 0; i < fragments.length; i++) {
                    if (IsColumnPart(fragments[i])) {
                        String lastText = columnList.get(columnList.size() - 1);
                        columnList.set(columnList.size() - 1, lastText + "." + fragments[i]);
                    } else {
                        columnList.add(fragments[i]);
                    }
                }
                accountType.add(columnList.get(0));
                accountNumber.add(columnList.get(1));
                currency.add(columnList.get(2));
                operationDate.add(columnList.get(3));
                transactionReference.add(columnList.get(4));
                operationDescription.add(columnList.get(5));
                income.add(columnList.get(6).replace("\"", ""));
                expense.add(columnList.get(7).replace("\"", ""));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static boolean IsColumnPart(String text) {
        String trimText = text.trim();
        return trimText.indexOf("\"") == trimText.lastIndexOf("\"") && trimText.endsWith("\"");
    }

    public double getExpenseSum() {
        double sum = 0;
        for (String item : expense) {
            sum += Double.parseDouble(item);
        }
        return sum;
    }

    public double getIncomeSum() {
        double sum = 0;
        for (String item : income) {
            sum += Double.parseDouble(item);
        }
        return sum;
    }
    public void getCostBreakdown() {
        int size = operationDescription.size();
        double sumCost = 0;
        Map<String, Double> costBreakdown = new HashMap<>();
        for (int i = 0; i < size; i++) {
            sumCost += Double.parseDouble(expense.get(i));
            String subDescrOperFirst = operationDescription.get(i).substring(operationDescription.get(i).lastIndexOf(" "));
            for (int j = i + 1; j < size; j++) {
                String subDescrOperSecond = operationDescription.get(j).substring(operationDescription.get(j).lastIndexOf(" "));
                if (!subDescrOperFirst.equals(subDescrOperSecond))
                    continue;
                sumCost += Double.parseDouble(expense.get(j));
                operationDescription.remove(j);
                j--;
                size--;
            }
            String[] fragments = operationDescription.get(i).split("([?\\s\\[\\]])+");
            costBreakdown.put(fragments[1], sumCost);
            //System.out.println(fragments[1]);
        }
        /*for(Map.Entry<String, Double> item : costBreakdown.entrySet()){

            System.out.printf("Key: %s  Value: %s \n", item.getKey(), item.getValue());
        }*/
    }
}
