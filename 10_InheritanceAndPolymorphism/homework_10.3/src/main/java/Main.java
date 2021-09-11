package main.java;

public class Main {
    public static void main(String[] args) {
        Client first = new PhysicalPerson();
        first.put(1000);
        first.take(200);
        System.out.println(first.getAmount());
        Client second = new IndividualBusinessman();
        second.put(8000);
        second.take(200);
        System.out.println(second.getAmount());
        Client third = new LegalPerson();
        third.put(2000);
        third.take(300);
        System.out.println(third.getAmount());
    }
}
