package TaskTwo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadRun extends Thread {
    private int[] array;
    private static int currentMax = 1;
    private static long durationThread = 0;
    private int countThreads;
    private Object obj;
    private int id;

    public ThreadRun(int countThreads, int[] array) {
        this.countThreads = countThreads;
        this.array = array;
        work(countThreads, array);
    }

    public ThreadRun(int id, Object obj, int[] array, int countThreads) {
        this.array = array;
        this.countThreads = countThreads;
        this.obj = obj;
        this.id = id;
    }

    // thread creation
    private void work(int countThreads, int[] array) {
        durationThread = 0;
        Object obj = new Object();
        for (int i = currentMax; i <= countThreads; i++) {
            Thread thread = new ThreadRun(i, obj, array, countThreads);
            thread.start();
        }
    }

    // streams in strict sequence
    public void run() {
        synchronized (obj) {
            while (id > currentMax) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            currentMax++;
            try {
                calculate(array, id, false);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            obj.notifyAll();
        }
    }

    public double calculate(int[] array, int id, boolean threadPool) throws InterruptedException {
        long startTime = System.currentTimeMillis();
        int coreCount = Runtime.getRuntime().availableProcessors();

        Arrays arrays = new Arrays();
        double result = arrays.getSumMultipleThread(array, coreCount);
        long duration = System.currentTimeMillis() - startTime;
        durationThread += duration;
        System.out.println("Result = " + result);
        System.out.println("Calculating sum duration " + duration);
        if (id == countThreads) {
            System.out.println("Total duration of all threads: " + durationThread);
            if (threadPool) {
                Main.finishThreadPool = true;
            } else {
                Main.finishThread = true;
            }
        }
        return result;
    }

    public void getThreadPool(int n, int[] array) {
        durationThread = 0;
        countThreads = n;
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Callable<Double>[] callable = new Callable[n];
        for (int i = 0; i < callable.length; i++) {
            final int x = i + 1;
            callable[i] = new Callable<Double>() {
                @Override
                public Double call() throws Exception {
                    return calculate(array, x, true);
                }
            };
        }
    }
}
