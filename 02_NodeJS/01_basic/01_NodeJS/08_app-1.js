const user = require(`./06_user`); // ./를 이용해서 어떤 js파일에서 exports 값을 가져올 지 설정
const hello = require(`./07_hello`);

console.log(user);
console.log(hello);

hello(user); // 모듈에서 가져온 user 변수와 hello 함수 사용하기
