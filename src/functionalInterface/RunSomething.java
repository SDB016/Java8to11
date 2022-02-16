package functionalInterface;

@FunctionalInterface
public interface RunSomething {

    int doIt(int num);

    static void printName() {
        System.out.println("Dongbin");
    }

    default void printAge(int age) {
        System.out.println("age: " + age);
    }
}
