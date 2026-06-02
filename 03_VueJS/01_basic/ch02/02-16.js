let name = '홍길동';
let age = 20;
let email = 'gdhong@test.com';

// let obj = { name: name, age: age, email: email }; // 이 경우 작성한 키 값으로 저장
let obj = { name, age, email }; // 키 값이 각 값의 변수명과 동일하게 지정. 속성명과 변수명이 일치하는 경우 변수명만 제시 가능
console.log(obj);
