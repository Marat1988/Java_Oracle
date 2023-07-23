package Practice2.Task3;

@FunctionalInterface
public interface Calc<T> {
    T comparingNumbers(T a, T b, T c);
}
