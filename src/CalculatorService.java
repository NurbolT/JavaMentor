import java.util.HashMap;

public class CalculatorService {
    private String[] Arab = {"0","1","2","3","4","5","6","7","8","9","10"};
    private String[] Roman = {" ", "I","II","III","VI","V","VI","VII","VIII","IX","X"};
    private String[] operation = {"+", "-", "/", "*"};

    public int checkCalculator(Calculator calculator){
        int ok = 0;
        for(int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (calculator.getNumber1().equals(Arab[i]) && calculator.getNumber2().equals(Arab[j])) {
                    ok = 1;
                } else if (calculator.getNumber1().equals(Roman[i]) && calculator.getNumber2().equals(Roman[j])) {
                    ok = 2;
                }
            }
        }
        return ok;
    }

    public boolean checkOperation(Calculator calculator){
        boolean ok = false;
        for(int i = 0; i < 4; i++){
            if(calculator.getOperation().equals(operation[i])){
                ok = true;
            }
        }
        return ok;
    }

    public void operationArabCalculator(Calculator calculator){
        if(calculator.getOperation().equals("+")) {
            int result = Integer.parseInt(calculator.getNumber1()) + Integer.parseInt(calculator.getNumber2());
            System.out.println(result);
        }else if(calculator.getOperation().equals("-")) {
            int result = Integer.parseInt(calculator.getNumber1()) - Integer.parseInt(calculator.getNumber2());
            System.out.println(result);
        }else if(calculator.getOperation().equals("*")) {
            int result = Integer.parseInt(calculator.getNumber1()) * Integer.parseInt(calculator.getNumber2());
            System.out.println(result);
        }else if(calculator.getOperation().equals("/")) {
            if(calculator.getNumber2().equals("0")){
                System.out.println("Деление на ноль невозможно!");
            }else{
                double result = (double) Integer.parseInt(calculator.getNumber1()) / Integer.parseInt(calculator.getNumber2());
                System.out.println(result);
            }
        }
    }

    public void operationRomanCalculator(Calculator calculator){
        int number1 = 0, number2 = 0;
        for(int i = 0; i < 11; i++){
            for(int j = 0; j < 11; j++){
                if(calculator.getNumber1().equals(Roman[i]) && calculator.getNumber2().equals(Roman[j])){
                    number1 = i;
                    number2 = j;
                }
            }
        }

        int result = 0;
        if(calculator.getOperation().equals("+")) {
            result = number1 + number2;

        }else if(calculator.getOperation().equals("-")) {
            result = number1 - number2;

        }else if(calculator.getOperation().equals("*")) {
            result = number1 * number2;

        }else if(calculator.getOperation().equals("/")) {
            result = number1 / number2;

        }
        String resultRoman = "";
        if(result < 0){
            result = result*(-1);
            resultRoman = "-";
        }

         int[] bases = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
         HashMap<Integer, String> map = new HashMap<Integer, String>();
            map.put(1, "I");
            map.put(4, "IV");
            map.put(5, "V");
            map.put(9, "IX");
            map.put(10, "X");
            map.put(40, "XL");
            map.put(50, "L");
            map.put(90, "XC");
            map.put(100, "C");
            map.put(400, "CD");
            map.put(500, "D");
            map.put(900, "CM");
            map.put(1000, "M");

          for (int i : bases){
             while (result >= i){
                resultRoman += map.get(i);
                result -= i;
              }
          }
        System.out.println(resultRoman);
    }
}
