package defaultAndStaticMethod.concept;

public interface Foo {

    void printName();

    /**
     * @implSpec
     * 이 구현체는 getName()으로 가져온 문자열을 대분자로 바꿔 출력한다.
     */
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    String getName();

    static void printClassName() {
        System.out.println("Foo");
    }
}
