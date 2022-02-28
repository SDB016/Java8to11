package streamPractice.basic;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("java");
        names.add("jpa");
        names.add("spring");
        names.add("mysql");

        // Lazy 하기 때문에 실행 안됨
        names.stream()
                .map(s->{
                    System.out.println(s.toUpperCase());
                    return s.toUpperCase();
                });

        System.out.println();
        System.out.println("==========");

        names.parallelStream().map(s -> {
            System.out.println(s.toUpperCase() + ' ' + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());

        System.out.println();

        names.stream().map(s -> {
            System.out.println(s.toUpperCase() + ' ' + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
    }
}
