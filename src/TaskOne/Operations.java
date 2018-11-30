package TaskOne;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Operations {
    public float getResult(OperationFloat operationFloat) throws ExecutionException, InterruptedException {
        FutureTask<Float> futureTask = new FutureTask<>(operationFloat);
        Thread thread = new Thread(futureTask);
        System.out.println("Thread started. ");
        thread.start();
        float result = 0;

            result = futureTask.get();
//            Thread.sleep(2000);

        System.out.println("Thread finished. ");
        return result;
    }

    public boolean getResult(OperationBoolean operationBoolean) throws ExecutionException, InterruptedException {
        FutureTask<Boolean> futureTask = new FutureTask<>(operationBoolean);
        Thread thread = new Thread(futureTask);
        System.out.println("Thread started. ");
        thread.start();
        boolean result = false;
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

            result = futureTask.get();

        System.out.println("Thread finished. ");
        return result;
    }
}
