const order = (menu, func) => {
  console.log(`${menu} 주문 접수`);
  //   console.log(func);
  setTimeout(() => {
    func(menu);
  }, 3000);
};

const display = (result) => {
  console.log(`${result} 완료!`);
};

order('아메리카노', display);

// display라고 함수 명을 통해 값을 넣어주었으므로, display에 할당된 함수 코드 자체가 func자리에 할당
// 호출 실행 순서 : 13(호출부) > 1(order함수 실행) > 9(display 함수 실행)
