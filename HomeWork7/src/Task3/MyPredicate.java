package Task3;

@FunctionalInterface
public interface MyPredicate<T> {
    T test(T number1, T number2, T number3, T number4);
}
