// 작업 디렉토리의 파일 목록 출력
// 비동기 함수 사용 - readdir 함수
const fs = require('fs');

// fs.readdir(경로, 콜백)
// 콜백함수: (err, files)
// 경로를 통해 파일 목록을 읽을 폴더를 가져옴
// 콜백의 두번째 인자(files)에 파일 목록을 배열로 가져옴
fs.readdir('./', (err, files) => {
  if (err) {
    console.error(err);
    return;
  }
  console.log(files);
});
