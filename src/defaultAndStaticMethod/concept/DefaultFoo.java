package defaultAndStaticMethod.concept;

public class DefaultFoo implements Foo, Bar{

    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        Foo.printClassName(); // static 메소드 사용 가능

        return this.name;
    }

    /**
     * @implNote
     * Foo, Bar 처럼 같은 이름의 default 메소드가 있을 때 재정의 필요
     */
    @Override
    public void printNameUpperCase() {
        System.out.println("default 메소드도 재정의 가능");
    }

}
