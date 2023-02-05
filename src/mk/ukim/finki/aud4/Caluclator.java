package mk.ukim.finki.aud4;

import java.util.Scanner;

public class Caluclator {

    static class Calculator {
        private double result;

        public Calculator() {
            this.result = 0.0;
        }

        public void calculate(String sign, double number) throws UnknownOperatorException {
            if (sign.equals("+")) {
                result += number;
            } else if (sign.equals("-")) {
                result -= number;
            } else if (sign.equals("*")) {
                result *= number;
            } else if (sign.equals("/")) {
                result /= number;
            }
            else throw new UnknownOperatorException();
        }

        //+2
        //+ 2
        public void calculatorStart() throws UnknownOperatorException {
            Scanner scanner = new Scanner(System.in);
            String line = "";
            System.out.println("The program started!");
            System.out.println("Result is " + result);
            do {
                line = scanner.nextLine();
                double number = Double.parseDouble(line.replaceAll(" ", "").substring(1));
                calculate(String.valueOf(line.charAt(0)), number);
                System.out.println("result " + line.charAt(0) + " " + number + " = " + result);
                System.out.println("Do you want to continue?(y/n)");
                line = scanner.nextLine();
            } while (!line.equals("n"));


        }


    }

    public static void main(String[] args) throws UnknownOperatorException {
        Calculator calculator = new Calculator();
        calculator.calculatorStart();
    }

}
