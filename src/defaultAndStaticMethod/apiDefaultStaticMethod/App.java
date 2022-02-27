package defaultAndStaticMethod.apiDefaultStaticMethod;

import java.util.*;

public class App {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("spring");
        names.add("java");
        names.add("jpa");
        names.add("mysql");

        iteratorCollection(names);
        comparatorTest(names);
    }

    private static void iteratorCollection(List<String> names) {
        System.out.println("===spliterator===");
        final Spliterator<String> spliterator = names.spliterator();
        final Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        System.out.println("========");
        while (spliterator1.tryAdvance(System.out::println));

        names.removeIf(s -> s.startsWith("j"));

        System.out.println("===remove j===");
        names.forEach(System.out::println);
    }

    private static void comparatorTest(List<String> names) {
        final Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed().thenComparing(String::length));

        names.forEach(System.out::println);
    }
}
