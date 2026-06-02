// 실행하기
// 터미널 열기 단축키 : ctrl + shift + `
// cmd로 변경 후 파일이 있는 곳으로 이동 (cd)
// node 파일명.js
// !!꼭 저장하고 실행하기!!
// const col = require(`ansi-colors`);

function hello(name) {
  console.log(`${col.green(name)} 님, 안녕하세요?`);
}

hello('홍길동');
