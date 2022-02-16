package functionalInterface;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class VariableCapture {
    private void run() {
        // 로컬 클래스, 익명 클래스, 람다에서 이 변수를 참조하면 effective final 로 바뀐다.
        int baseNumber = 10;

        // 로컬 클래스
        class LocalClass {
            void printBaseNumber() {
                int baseNumber = 11; // run 보다 printBaseNumber 의 스코프가 더 지엽적
                System.out.println(baseNumber); // 11
            }
        }

        // 익명 클래스
        IntConsumer intConsumer = new IntConsumer() {
            @Override
            public void accept(int baseNumber) {
                System.out.println(baseNumber); // accept 의 baseNumber 의 스코프가 더 지엽적
            }
        };

        // 람다
        // 람다와 run 의 스코프가 같다. 따라서 baseNumber assignment 불가능
        IntConsumer lambda = (i) ->
                System.out.println(i + baseNumber);

        //baseNumber++; // effective final 위반

        // IntConsumer wrongLambda = (baseNumber) ->
        //      System.out.println(baseNumber);


    }
}
