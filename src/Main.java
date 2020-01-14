import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

//Author : Tolegenov Nurbol

public class Main {

    public static void main(String[] args) {
        System.out.println("Введите данные (пример: 1 + 2, I + II):");
        String input = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }


        String inputTrim = input.trim();
        String inputR = inputTrim.replaceAll("[\\s]{2,}", " ");
        String[] tok = inputR.split(" ");


        if (tok.length == 3 && ((tok[0].matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$") && tok[2].matches("^M{0,4}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$")) || (tok[0].matches("[0-9]+") && (tok[2].matches("[0-9]+"))))) {
            Calculator calculator = new Calculator(tok[0], tok[2], tok[1]);
            CalculatorService calculatorService = new CalculatorService();
            if (calculatorService.checkCalculator(calculator) == 0) {
                System.out.println("Ошибка! Калькулятор умеет работать только с целыми числами как с арабскими, так и с римскими: от 0 до 10");
            } else {
                if (calculatorService.checkOperation(calculator)) {
                    if (calculatorService.checkCalculator(calculator) == 1) {
                        calculatorService.operationArabCalculator(calculator);
                    } else {
                        calculatorService.operationRomanCalculator(calculator);
                    }
                } else {
                    System.out.println("Aрифметическая операция не соответствует!");
                }
            }
        } else {
            System.out.println("Неверный ввод!");
        }
    }
}
