package PartTwo_Task8_IShow;

public class MyArray implements IShow {
    private int[] arr;

    public MyArray(int[] arr) {
        this.arr = arr;
    }

    @Override
    public void Print() {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Число равно: " + arr[i]);
        }
    }

    @Override
    public void Print(String info) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Число равно: " + arr[i] + " " + info);
        }
    }
}
