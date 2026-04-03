function addContact1({ name, phone, email = '이메일없음', age = 0 }) {
  // 객체를 매개변수로 받으므로 중괄호로 받기
  // 기본 파라미터의 기본값 설정
  console.log(name, phone, email, age);
}
addContact1({ name: '이몽룡', phone: '010-3434-8989' });

function addContact2(contact) {
  // 객체를 contact로 받음, 조건문을 통해 파라미터의 기본값 설정
  if (!contact.email) contact.email = '이메일없음';
  if (!contact.age) contact.age = 0;
  // 구조분해 할당을 통해 값 할당
  let { name, phone, email, age } = contact;
  console.log(name, phone, email, age);
}

addContact2({ name: '이몽룡', phone: '010-3434-8989' });

function addContact3(name, phone, email = '이메일없음', age = 0) {
  // 객체 형식으로 입력받지 않으므로 중괄호 사용 안함
  console.log(name, phone, email, age);
}

addContact3('이몽룡', '010-3434-8989');
