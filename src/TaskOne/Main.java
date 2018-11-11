package TaskOne;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number A: ");
        float a = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter a number B: ");
        float b = scanner.nextFloat();
        scanner.nextLine();
        System.out.print("Enter the character of one of the following operations:" +
                        " ( \"+\" ; \"-\" ; \"*\" ; \"/\" ; \"%\" ; \"==\" ; \"<\" ; \">\" ) ");
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
