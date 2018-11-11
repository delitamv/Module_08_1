package TaskOne;

import java.util.concurrent.Callable;

public class OperationBoolean implements Callable<Boolean> {
    private String operation;
    private float a;
    private float b;

    public OperationBoolean(String operation, float a, float b) {
        this.operation = operation;
        this.a = a;
        this.b = b;
    }

    @Override
    public Boolean call() throws Exception {
        boolean result = false;
        switch (operation) {
            case "==":
                result = (a == b);
                break;
            case "<":
                result = (a < b);
                break;
            case ">":
                result = (a > b);
                break;
            default:
                result = false;
                System.out.println("Error " + operation);
                break;
        }
        return result;
    }
}
