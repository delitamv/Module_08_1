package TaskOne;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Operations {
    public float getResult(OperationFloat operationFloat) {
        FutureTask<Float> futureTask = new FutureTask<>(operationFloat);
        Thread thread = new Thread(futureTask);
        System.out.println("Thread started. ");
        thread.start();
        float result = 0;
        try {
            result = futureTask.get();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished. ");
        return result;
    }

    public boolean getResult(OperationBoolean operationBoolean) {
        FutureTask<Boolean> futureTask = new FutureTask<>(operationBoolean);
        Thread thread = new Thread(futureTask);
        System.out.println("Thread started. ");
        thread.start();
        boolean result = false;
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            result = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished. ");
        return result;
    }
}
