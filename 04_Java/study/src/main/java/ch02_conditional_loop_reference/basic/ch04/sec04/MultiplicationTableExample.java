package main.java.ch02_conditional_loop_reference.basic.ch04.sec04;

public class MultiplicationTableExample {
    public static void main(String[] args) {
        for(int i = 2;i<10;i++){
            System.out.printf("*** %d단 ***\n", i);
            for(int j = 1;j<10;j++){
                System.out.printf("%d X %d = %d\n", i, j, i*j);
            }
            System.out.println(" ");
        }
    }
}
