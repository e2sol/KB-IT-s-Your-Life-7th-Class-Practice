// fetch의 기본 사용법 (get 방법)
// // 출력 결과 : Promise { <pending> }
// fetch('https://jsonplaceholder.typicode.com/users')
//   .then((response) => {
//     console.log(response.json());
//   })
//   // fetch 요청 자체가 실패한 경우를 제외하고서는 catch로 error가 넘어가지 않음
//   .catch((error) => console.error('Error : ', error));

// 교재 코드
// 예제 답안처럼 출력
fetch('https://jsonplaceholder.typicode.com/users')
  .then((response) => response.json())
  .then((data) => console.log(data))
  .catch((err) => console.log(err));
