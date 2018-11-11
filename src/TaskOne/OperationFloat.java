package TaskOne;

import java.util.concurrent.Callable;

public class OperationFloat implements Callable<Float> {
    private String operation;
    private float a;
    private float b;

    public OperationFloat(String operation, float a, float b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    @Override
    public Float call() throws Exception {
        float result = 0;
        switch (operation) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            case "%":
                result = a % b;
                break;
            default:
                result = 0;
                System.out.println("Error " + operation);
                break;
        }
        return result;
    }
}
