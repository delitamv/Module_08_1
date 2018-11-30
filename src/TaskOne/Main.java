package TaskOne;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        float a = 0;
        float b = 0;
        System.out.print("Enter a number A: ");
        for (int i = 0; i < 1; i++) {
            if (scanner.hasNextFloat()) {
                a = scanner.nextFloat();
            } else {
                System.out.print("You did not enter an integer.");
                break;
            }
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a number B: ");
            if (sc.hasNextFloat()) {
                b = sc.nextFloat();
            } else {
                System.out.print("You did not enter an integer. ");
                break;
            }

            scanner.nextLine();
            System.out.print("Enter the character of one of the following operations:" +
                    " ( \"+\" ; \"-\" ; \"*\" ; \"/\" ; \"%\" ; \"==\" ; \"<\" ; \">\" ) ");
        }
        String operation = scanner.nextLine();

        Operations opr = new Operations();

            if (operation.equals("+") || operation.equals("-") || operation.equals("*") || operation.equals("/") || operation.equals("%")) {
                OperationFloat operationFloat = new OperationFloat(operation, a, b);
                System.out.println(a + " " + " " + operation + " " + b + " = " + opr.getResult(operationFloat));
            } else if (operation.equals("==") || operation.equals(">") || operation.equals("<")) {
                OperationBoolean operationBoolean = new OperationBoolean(operation, a, b);
                System.out.println(a + " " + " " + operation + " " + b + " = " + opr.getResult(operationBoolean));
            } else {
                System.out.println("Error. Bye!!!");
            }
        }
}
