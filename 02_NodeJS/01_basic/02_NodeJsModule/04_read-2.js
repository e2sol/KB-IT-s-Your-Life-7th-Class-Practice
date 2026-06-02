// example.txt의 내용을 읽어 화면에 출력
const fs = require('fs');

// 동기 함수 사용
// const text = fs.readFileSync('./example.txt'); // 인코딩 미 지정 시 파일이 깨짐
const text1 = fs.readFileSync('./example.txt', 'utf-8'); // 인코딩 지정

console.log('동기 함수 텍스트\n', text1);

// 비동기 함수 사용
fs.readFile('./example.txt', 'utf-8', (err, txt) => {
  if (err) {
    console.error(err);
  }
  console.log('\n비동기 함수 텍스트\n', txt);
});
