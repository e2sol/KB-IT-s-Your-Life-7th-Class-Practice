<!-- 이벤트 발신 시 유효성 검증 처리
  - emits 옵션 : 발신하는 이벤트에 대한 유효성 검사를 수행

  - 작성법 1) 배열 형태로 이벤트명 나열 : 등록된 이벤트가 발생하는지 이벤트명 확인
  const component = {
    emits : ["이벤트명1", "이벤트명2", ...]
    }
  }


  - 작성법 2) 객체 형태로 이벤트명 나열 : 이벤트명 + eventArgs 유효성 여부도 확인
  const component = {
    emits : {
      이벤트명1 : (eventArgs) => {
        // true 반환 : 이벤트 발신 허용
        // false 반환 : 이벤트 발신 거부
      },
      이벤트명2 : null, // 유효성 검사 없음
    }
  }
-->
<template>
  <div>
    <label>이름: <input type="text" v-model="name" /></label>
    <button @click="$emit('nameChanged', { name })">이벤트 발신</button>
  </div>
</template>
<script>
export default {
  name: 'InputName',

  // 이벤트 유효성 검증
  // 1. 배열 형태로 이벤트명 작성 : 등록된 이벤트가 발생하는지 이벤트명 확인
  // nameChanged 이벤트 발신 허용, 다른 이벤트는 경고 출력
  // emits: ['nameChanged'],

  // 2. 객체 형태로 이벤트 명 작성 : 이벤트명 + eventArgs 유효성 여부도 확인
  emits: {
    nameChanged: (e) => {
      // e : 이벤트 발신 시 전달된 아규먼트

      // 유효성 검사 코드 작성
      // true 반환 : 이벤트 발신 허용, false 반환 : 이벤트 발신 거부
      // 이름이 문자열이고, 3글자 이상인 경우 이벤트 발신 허용
      e.name && typeof e.name === 'string' && e.name.length >= 3;
    },
  },
  data() {
    return { name: '' };
  },
};
</script>
