// MDN 제공 Fetch API 기본 활용법
// 예제에서 원하는 대로 출력됨
// async function logJSONData() {
//   // fetch API : JS에서 네트워크 요청을 보낼 때 사용하는 기본 API
//   const response = await fetch('https://jsonplaceholder.typicode.com/users');
//   const jsonData = await response.json(); // 응답을 json으로 변환
//   console.log(jsonData); // 변환 데이터 출력
// }

// logJSONData();

// error 처리 코드를 포함시키기 위해
// try {} catch (){} 구문 사용

async function init() {
  try {
    const response = await fetch('https://jsonplaceholder.typicode.com/users');
    const users = await response.json(); //json형태의 데이터를 JS 객체 형태로 변환
    console.log(users);
  } catch (err) {
    console.error(err);
  }
}

init();
