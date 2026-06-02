// 메뉴 hover 효과

const menuItems = document.querySelectorAll('.nav li');

menuItems.forEach((item) => {
  item.addEventListener('mouseover', () => {
    item.style.color = '#00754a';
  });

  item.addEventListener('mouseout', () => {
    item.style.color = '#000';
  });
});

// 버튼 클릭 이벤트

document.querySelector('.join').addEventListener('click', () => {
  alert('회원가입 페이지로 이동합니다.');
});

document.querySelector('.login').addEventListener('click', () => {
  alert('로그인 페이지로 이동합니다.');
});
