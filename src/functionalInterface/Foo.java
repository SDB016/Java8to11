package functionalInterface;

public class Foo {
    public static void main(String[] args) {
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
