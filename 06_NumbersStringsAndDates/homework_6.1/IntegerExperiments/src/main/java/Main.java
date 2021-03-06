package main.java;

public class Main {

    public static void main(String[] args) {
        Container container = new Container();
        container.count += 7843;

        int sum = sumDigits(7843);

        System.out.println(sum);
    }

  /* Реализуйте метод sumDigits который возвращает сумму цифр числа, пример:
  передано 12345, метод должен вернуть 15
  если передано null, то должен вернуть -1

  Запустите тесты TestSumDigits для проверки корректности работы метода

  не меняйте название метода, его возвращаемое значение и модификаторы доступа (public).
  В противном случае тестовый метод не сможет проверить ваш код
   */

    public static int sumDigits(Integer number) {
        int sum = 0;
        if (number == null) {
            return -1;
        } else {
            String temp = number.toString();
            for (int i = 0; i < temp.length(); i++) {
                sum += Character.getNumericValue(temp.charAt(i));
            }
            return sum;
        }
    }
}
