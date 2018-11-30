package TaskOne;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Operations {
    public float getResult(OperationFloat operationFloat) throws InterruptedException, ExecutionException, TimeoutException {
        FutureTask<Float> futureTask = new FutureTask<>(operationFloat);
        Thread thread = new Thread(futureTask);
        System.out.println("Thread started. ");
        thread.start();
        float result = 0;

            result = futureTask.get(2000L, TimeUnit.MILLISECONDS);

        System.out.println("Thread finished. ");
        return result;
    }

    public boolean getResult(OperationBoolean operationBoolean) throws ExecutionException, InterruptedException, TimeoutException {
        FutureTask<Boolean> futureTask = new FutureTask<>(operationBoolean);
        Thread thread = new Thread(futureTask);
        System.out.println("Thread started. ");
        thread.start();
        boolean result = false;

            result = futureTask.get(2000L, TimeUnit.MILLISECONDS);

        System.out.println("Thread finished. ");
        return result;
    }
}
