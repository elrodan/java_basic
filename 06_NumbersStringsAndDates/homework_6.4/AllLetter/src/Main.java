public class Main {
    public static void main(String[] args) {
        String alfavit = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < alfavit.length(); i++) {
            System.out.println(alfavit.charAt(i) + " - " + Character.hashCode(alfavit.charAt(i)));
        }
    }
}
