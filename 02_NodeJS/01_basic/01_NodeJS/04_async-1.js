function displayA() {
  console.log('A');
}

function displayB(callback) {
  // 첫번째 입력 란에 함수로 선언해서 입력해야 함
  setTimeout(() => {
    console.log('B');
    callback();
  }, 2000);
}

function displayC() {
  console.log('C');
}

displayA();
displayB(displayC);
