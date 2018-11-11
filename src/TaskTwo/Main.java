package TaskTwo;

import java.util.Scanner;

public class Main {
    public static boolean finishThread = false;
    public static boolean finishThreadPool = false;

    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number N: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        long startTime = System.currentTimeMillis();

        // fill array with one stream
        Arrays arrays = new Arrays();
        int[] arr = arrays.getArraySingleThread(80_000_000);
        long duration = System.currentTimeMillis() - startTime;
        System.out.println("Filing duration " + duration);
        System.out.println();

        ThreadRun threadRun = new ThreadRun(n, arr);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!finishThread) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
            }
        });
        thread.start();
        thread.join();

        // режим ThreadPool
        threadRun.getThreadPool(n, arr);
        Thread threadPool = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!finishThreadPool) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println();
        }
        });
        threadPool.start();
    }
}