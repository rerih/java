There is a package java.util.function that has a number of useful interfaces.
The interface BiFunction declares two arguments (T, U) and a return value (R).

@FunctionalInterface
public interface BiFunction<T, U, R>

The BiFunction interface declares a method

R apply(T, U)
