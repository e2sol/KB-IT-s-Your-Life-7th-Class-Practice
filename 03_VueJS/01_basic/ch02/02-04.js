// p1이 참조하는 메모리 주소가 바뀌는 것이므로 에러가 발생

const p1 = { name: 'john', age: 20 }; // 해당 객체의 주소값이 p1에 담김
p1 = { name: 'lee', age: 25 }; // 새로운 객체의 주소값을 p1에 담고자 하는 코드

console.log(p1); // TypeError: Assignment to constant variable.
