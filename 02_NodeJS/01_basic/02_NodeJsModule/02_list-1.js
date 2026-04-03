// 작업 디렉토리의 파일 목록 출력
// 동기 함수 사용 - readdirSync 함수
const fs = require('fs');

//경로를 특정 파일에 대한 경로가 아니라 형재 파일 위치를 설정해주어야 함
const fileList = fs.readdirSync('./');

console.log(fileList);
