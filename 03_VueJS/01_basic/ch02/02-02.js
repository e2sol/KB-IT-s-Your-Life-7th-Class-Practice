/*  ### let
    - 블록 단위로 유효범위가 지정되는 변수
    - 중복 선언 불가
*/

let msg = 'GLOBAL'; // global 변수
function outer() {
  // function이라는 새로운 블록 생성
  let msg = 'OUTER';
  console.log(msg); // outer() 범위 내 선언된 msg 값이 출력
  if (true) {
    let msg = 'BLOCK';
    console.log(msg);
  }
}

outer();

// 실행결과
// OUTER
// BLOCK
