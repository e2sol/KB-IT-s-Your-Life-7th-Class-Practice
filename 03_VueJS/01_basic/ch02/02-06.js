/*  ### 가변 파라미터(Rest Parameter)
    - 전달된 인수를 매개변수로 매칭한 후, 매칭되지 않은 인수를 모아 배열로 지정
    - 1개만 지정 가능, 마지막에만 작성 가능
    - 형식 : function 함수명(arg1, arg2, ...argv){}
*/

function foodReport(name, age, ...foodList) {
  console.log(`${name}, ${age}`);
  console.log(foodList); // 백틱 내에서 ${}를 이용해 출력하면 대괄호[]와 각 요소의 따옴표가 생략되어 출력됨
}

foodReport('이몽룡', 20, '짜장면', '냉면', '불고기');
foodReport('홍길동', 16, '초밥');
