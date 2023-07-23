package Task7_8;

import java.util.*;
import java.util.function.IntFunction;

public class MyArray implements IShow, IMath, ISort {
    private int[] arr;

    public MyArray(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void Print() {
        System.out.println(Arrays.toString(arr));
    }

    @Override
    public void Print(String info) {
        for (int j : arr) {
            System.out.println("Число равно: " + j + " " + info);
        }
    }

    @Override
    public int Max() {
        OptionalInt max = Arrays.stream(this.arr).max();
        if (max.isPresent()) {
            return max.getAsInt();
        }
        return 0;
    }

    @Override
    public int Min() {
        OptionalInt min = Arrays.stream(this.arr).min();
        if (min.isPresent()) {
            return min.getAsInt();
        }
        return 0;
    }

    @Override
    public float Avg() {
        OptionalDouble avg = Arrays.stream(this.arr).average();
        if (avg.isPresent()) {
            return (float) avg.getAsDouble();
        }
        return 0;
    }

    @Override
    public void SortAsc() {
        Arrays.sort(arr);
    }

    @Override
    public void SortDesc() {
        int[] sortedDesc = Arrays.stream(arr)
                .boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        System.arraycopy(sortedDesc, 0, arr, 0, sortedDesc.length);
    }
}
