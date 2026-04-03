const hi = (name) => {
  console.log(`${name}님, 안녕하세요?`);
};
const goodbye = (name) => {
  console.log(`${name}님, 안녕히 가세요.`);
};

// const say = { hi, goodbye };
// export default say;

// 이렇게 처리해도 오류나지 않음
export default { hi, goodbye };
