package functionalInterface;

import java.lang.annotation.Repeatable;
import java.util.function.*;

public class Foo {

    static void binary() {
        BinaryOperator<Integer> binaryOperator = (num1, num2) -> num1 + num2;
    }

    static void unary() {
        UnaryOperator<Integer> plus10 = (i) -> i + 10;
        plus10.apply(1);
    }

    static void predicate() {
        Predicate<String> startsWithD = (s) -> s.startsWith("D");
        Predicate<Integer> isOdd = (i) -> i % 2 == 1;
    }

    static void supplier() {
        Supplier<Integer> get10 = () -> 10;
        System.out.println(get10.get());
    }

    static void consumer() {
        Consumer<Integer> print = (num) -> System.out.println("입력값: " + num);
        print.accept(10);
    }

    static void biFunction() {
        BiFunction<Integer, Integer, Integer> plus = (num1, num2) -> num1 + num2;
        System.out.println(plus.apply(1, 3));
    }

    static void defaultFunction() {
        Function<Integer, Integer> plus10 = num -> num + 10;
        Function<Integer, Integer> multiply = i -> i * 2;

        Function<Integer, Integer> multiply2AndPlus10 = plus10.compose(multiply); //multiply 한 후 plus
        Function<Integer, Integer> plus10AndMultiply2 = plus10.andThen(multiply);

        System.out.println(multiply2AndPlus10.apply(2));
        System.out.println(plus10AndMultiply2.apply(2));
    }

    private static void pureFunction() {
        int baseNum = 10; // final 이라 가정된 상태

        // 순수 함수
        RunSomething runSomething = (num) -> num + 10;

        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));
        System.out.println(runSomething.doIt(1));

        // 순수 함수 x
        RunSomething runSomething1 = num -> {
            //baseNum++;
            return num + baseNum;
        };
    }
}
