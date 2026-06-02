/*  ### 구조분해 할당(Destructuring Assingnment)
    - 배열이나 객체의 속성을 해체하여 그 값을 개별 변수에 담을 수 있다.
*/

let arr = [10, 20, 30, 40];

// const a1 = arr[0];
// const a2 = arr[1];
// const a3 = arr[3];

const [a1, a2, a3] = arr;

console.log(a1, a2, a3);

let p1 = { name: '홍길동', age: 20, gender: 'M' };

// const n = p1.name;
// const a = p1.age;
// const gender = p1.gender;

const { name: n, age: a, gender } = p1;

// 구조분해된 변수들의 값을 출력
console.log(n, a, gender);
// 객체명.속성명
console.log(p1.name, p1.age, p1.gender);
