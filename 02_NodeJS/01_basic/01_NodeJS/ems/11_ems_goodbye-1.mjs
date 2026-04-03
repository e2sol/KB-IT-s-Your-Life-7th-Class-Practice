const goodbye = (name) => {
  console.log(`${name} 님, 안녕히 가세요.`);
};

// mjs 확장자의 경우 export 대상; 을 통해 값을 내보냄
// 대상이 하나인 경우 export default를 사용해야 error가 나지 않음
export { goodbye };
