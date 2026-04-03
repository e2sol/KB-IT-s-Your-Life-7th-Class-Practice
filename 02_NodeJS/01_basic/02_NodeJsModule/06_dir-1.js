// 디렉토리에 test라는 디렉토리가 있는지 검사, 존재하지 않는 경우 디렉토리 제작
const fs = require('fs');

// 디렉토리 검사
const fileList = fs.readdirSync('./');
let check = 0;
for (let i = 0; i < fileList.length; i++) {
  let list = fileList[i];
  if (list == 'test') {
    check = 1;
  }
}
if (check == 1) {
  console.log('이미 test 디렉토리가 존재합니다');
} else {
  fs.mkdirSync('./test');
}
