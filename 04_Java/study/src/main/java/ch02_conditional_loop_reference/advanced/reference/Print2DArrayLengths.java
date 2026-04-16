package main.java.ch02_conditional_loop_reference.advanced.reference;

public class Print2DArrayLengths {
    public static void main(String[] args) {
        // 출력값을 작성해보자
        int[][] array = {
                {95, 86},
                {83, 92, 96},
                {78, 83, 93, 87, 88}
        };

        System.out.println(array.length); // 3
        System.out.println(array[2].length); // 5
    }
}
