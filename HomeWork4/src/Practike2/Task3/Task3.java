package Practike2.Task3;

public class Task3 {
    public static void main(String[] args) {
        Calc max = (a,b,c)->Math.max(a, Math.max(b,c));
        System.out.println(max.comparingNumbers(5,6,7));
        Calc min = (a,b,c)->Math.min(a, Math.min(b,c));
        System.out.println(min.comparingNumbers(5,6,7));
    }
}
