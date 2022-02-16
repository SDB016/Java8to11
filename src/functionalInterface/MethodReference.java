package functionalInterface;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodReference {

    //임의 객체의 인스턴스 메소드 참조
    void instanceMethod2() {
        String[] names = {"java", "spring", "jpa"};
        Arrays.sort(names, String::compareToIgnoreCase);
        Arrays.sort(names, String::compareTo);
    }

    // 특정 객체의 인스턴스 메소드 참조
    void instanceMethod1() {
        //UnaryOperator<String> hi = (s) -> "hi" + s;
        UnaryOperator<String> hi = Greeting::hi;
        hi.apply("me");

        Supplier<Greeting> newGreeting = Greeting::new; // noArgument Constructor
        final Greeting greeting = newGreeting.get();

        Function<String, Greeting> abcGreeting = Greeting::new; // String argument Constructor

        Greeting greet = new Greeting();
        UnaryOperator<String> hello = greet::hello;
        hello.apply("abc");
    }
}

class Greeting {
    private String name;

    public Greeting() {

    }

    public Greeting(String name) {
        this.name = name;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }
}

