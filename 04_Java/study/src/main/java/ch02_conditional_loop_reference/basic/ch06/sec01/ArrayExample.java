package main.java.ch02_conditional_loop_reference.basic.ch06.sec01;

public class ArrayExample {
    /* 배열(Array)
     * - 같은 자료형의 변수를 하나의 묶음으로 다루는 것 (자료구조)
     *
     * - 묶여진 변수들은 하나의 이름(배열명)으로 불려지고
     *   각 변수들은 index를 이용해서 구분하게 된다.
     *
     * - index의 번호는 0부터 시작하는 정수
     * */
    public static void main(String[] args) {
        // 변수 vs 배열

        // 1-1. 변수 선언
        int num;
        // Stack 영역에 int 자료형을 저장할 수 있는 공간 생성
        // 4byte를 생성(할당)하고 num이라는 이름을 부여

        // 1-2.  변수 대입
        num = 5;
        // 생성된 num이라는 변수 공간에 5를 대입

        // 1-3. 변수 사용
        System.out.println("num에 저장된 값 : " + num);
        // num이 작성된 자리에 num에 저장된 값을 읽어와서 출력

        System.out.println("-------------------------------------------");

        // 2-1. 배열 선언
        int[] arr;
        // Stack 영역에 int[](int배열) 자료형 공간을
        // 8byte 할당하고 arr이라는 이름을 부여 (참조형은 모두 8byte)

        // 2-2. 배열 할당
        arr = new int[3];
        // new : "new 연산자" 라고 하며
        //        Heap 메모리 영역에 새로운 공간(배열)을 할당

        // int[3] : int 자료형 변수 3개를 하나의 묶음으로 나타내는 배열

        // new int[3] : Heap 영역에 int 3칸짜리 int[]을 생성(할당)
        // Heap에는 비어있는 값을 넣을 수 없으므로 int의 기본값인 0이 자동 할당

        // ** 생성된 int[]에는 시작 주소가 담긴다!! **

        // arr   = new int[3];
        // int[] = int[] -> 같은 자료형이기 때문에 대입 연산 가능!

        // Heap 영역에 생성된 int[]의 시작 주소를 stack 영역에 생성된 arr 변수에 대입
        // -> arr 변수가 int[]를 참조하게 된다!

        // 2-3. 배열 요소에 값 대입
        // arr은 int[] 참조 변수지만, arr[0]은 int 자료형 변수이기 때문에 정수값 대입 가능
        for (int i = 0; i <arr.length ; i++) {
            arr[i] = (i+1)*10;
        }

        // 2-4. 배열 요소 값 출력
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}
