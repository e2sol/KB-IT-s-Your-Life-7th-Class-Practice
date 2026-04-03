let base = 100;
export const add = (x) => base + x;
export const multiply = (x) => base * x;
export default () => base;

// 각각 export 하는 경우 객체에 속성을 추가해서 사용
// module.exports.add = add;
// module.exports.multiply = multiply;

// exports.add = (x) => base + x;
// exports.multiply = (x) => base * x;

// exports.add = add;

// module.exports = { add, multiply };
// module.exports.getBase = getBase;
