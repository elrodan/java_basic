public class Main {
    public static void main(String[] args) {
        String pathMovementsCsv = "C:\\Users\\elrod\\IdeaProjects\\java_basics\\13_FilesAndNetwork\\homework_13.3\\src\\test\\resources\\movementList.csv";
        Movements movements = new Movements(pathMovementsCsv);
        movements.getCostBreakdown();
    }
}
