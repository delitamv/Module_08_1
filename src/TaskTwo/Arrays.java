package TaskTwo;

import java.util.ArrayList;
import java.util.List;

public class Arrays {
    public List<Integer> getList(int size) {
        System.out.println("Start!!!");
        final List<Integer> result = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            result.add(i + 1);
        }
        System.out.println("Finish!!!");
        return result;
    }

    public int[] getArraySingleThread(int size) {
        System.out.println("Filling Array ");
        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = i++;
        }
        System.out.println("Finish ");
        return result;
    }
    // counting the amount broken down into parallel streams
    public double getSumMultipleThread(int[] array, int count) throws InterruptedException {
        List<Thread> list = new ArrayList<>(count);
        final double[] sum = new double[count];

        for (int i = 0; i < count; i++) {
            int length = array.length / count;
            final int left = length * i;
            final int right = left + length;
            final int index = i;

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    sum[index] = getSum(array, left, right);
                }
            });
            thread.setPriority(Thread.MAX_PRIORITY);
            thread.start();
            list.add(thread);
        }
        for (Thread temp : list) {
            temp.join();
        }
        double totalSum = 0;
        for (double temp1 : sum) {
            totalSum += temp1;
        }
        return totalSum;
    }

    public double getSum(int[] array, int left, int right) {
        double sum = 0;
        for (int i = left; i < right; i++) {
            sum += Math.sin(array[i]) + Math.cos(array[i]);
        }
        return sum;
    }
}
