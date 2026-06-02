let obj = { result: 0 };

obj.add = function (x, y) {
  function inner() {
    this.result = x + y;
    // JS에서 일반함수의 this는 호출방식에 따라 결정됨
    // inner() 함수는 단독으로 호출되었기 때문에 그 안에 있는 this는 전역 객체를 가리킨다.
    // 전역 객체 : 브라우저 - window(최상위 객체), Node.js에서는 global을 가리킴
  }
  inner();
};

obj.add(3, 4);

console.log(obj); // 실행 결과 : { result: 0, add: [Function (anonymous)] }
console.log(result); // 실행 결과 : 7
