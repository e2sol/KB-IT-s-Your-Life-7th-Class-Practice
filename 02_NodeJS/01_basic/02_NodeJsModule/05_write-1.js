// example.txt를 읽어서 text-1.txt로 저장하기
const fs = require('fs');

// 동기 함수
const text1 = fs.readFileSync('./example.txt', 'utf-8');
// 첫번째 인자에 파일 확장자 명까지 작성할 것
fs.writeFileSync('./text-1.txt', text1);

// 비동기 함수
fs.readFile('./example.txt', 'utf-8', (err, txt) => {
  if (err) {
    console.error(err);
  }
  fs.writeFile('./text-2.txt', txt, (err) => {});
});
