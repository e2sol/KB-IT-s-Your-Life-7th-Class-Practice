<!-- 
 props 속성 사용(객체 전달)
 - props 목적 : 자식 컴포넌트가 필요한 데이터를 전달 받아 UI 렌더링 하는 것
-->

<template>
  <li>
    <label
      ><input type="checkbox" :checked="checked" /> {{ id }} - {{ name }}</label
    >
  </li>
</template>
<script>
export default {
  name: 'CheckboxItem2', // 컴포넌트 이름
  // props: ['name', 'checked', 'id'], // 유효성 검사 미실시

  // 유효성 검사 실시
  // 부모 -> 자식으로 넘어오는 데이터 규칙 정의
  // 유효하지 않은 경우 콘솔에 경고(실행은 된다)
  props: {
    id: [Number, String], // 타입(숫자, 문자열)만 정의
    name: String, // 문자열
    checked: {
      // 설정값 세팅 시 중괄호{} 이용
      // 타입 + 옵션 정의
      type: Boolean,
      default: false,
      requireed: false,
    },
  },
};
</script>
