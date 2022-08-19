import java.util.Scanner;

public class Main {
        public static void main(String[] args) throws Exception {
            Scanner calc = new Scanner(System.in); //Создали ввод с консоли методом Scanner
            System.out.println("Input:");
            String input  = calc.nextLine(); //Создали строку (переменная input) для ввода данных
            System.out.println("Output:");
            System.out.println(Calc.calc(input));

        }
}