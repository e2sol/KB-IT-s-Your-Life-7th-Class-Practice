// path 내장 모듈을 이용하여 경로 요소 'some', 'work', 'ex.txt'를 결합

// path 내장 모듈 불러오기
const path = require('path');

// path.join()을 이용하여 경로 요소 결합
const fullpath = path.join('some', 'work', 'ex.txt');

// 합쳐진 경로 요소를 출력
console.log(fullpath);

// 파일명을 포함한 절대 경로를 출력
console.log('\n파일명 포함 절대 경로: ', __filename);
console.log('\n파일명 미포함 절대 경로: ', __dirname);

// 파일의 경로만 출력
console.log('\ndirname 사용 파일 경로: ', path.dirname(__filename));

// 파일의 이름(확장자 포함) 출력
console.log('\n파일 이름: ', path.basename(__filename));

// 파일의 이름(확장자 미포함) 출력
console.log(
  '\n파일 이름(확장자 제외): ',
  path.basename(__filename, path.extname(__filename)),
);

// 파일의 확장명 출력
console.log('\n파일 확장자: ', path.extname(__filename));

// 파일의 경로 요소 전체를 출력
console.log('\n', path.parse(__filename));
