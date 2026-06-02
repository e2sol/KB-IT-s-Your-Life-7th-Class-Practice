package main.java.ch02_conditional_loop_reference.basic.ch05.sec09;

public class ArrayCopyByForExample {
    public static void main(String[] args) {
        int[] oldIntArray = {1, 2, 3};
        int[] newIntArray = new int[5];

        for (int i = 0; i < newIntArray.length; i++) {
            if(i<oldIntArray.length && oldIntArray[i] != 0){
                newIntArray[i] = oldIntArray[i];
            }
            System.out.printf("%d, ", newIntArray[i]);
        }
    }
}
