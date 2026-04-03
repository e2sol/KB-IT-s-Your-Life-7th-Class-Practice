<!-- 
  사용자 정의 이벤트를 이용한 정보 전달

  - 이벤트(Events) : 자식 컴포넌트에서 부모 컴포넌트로 정보 전달

  - 이벤트 발신(emit, 방출하다) : 자식 컴포넌트에서 부모 컴포넌트로 이벤트 방출
    this.$emit('event-name', eventArgs1, eventArgs2, …)


  - 이벤트 수신(on) : 부모 컴포넌트에서 자식 컴포넌트로 이벤트 수신
  <child-component @event-name="handlerMethod" />
    methods: {
    handlerMethod(eventArgs1, eventArgs2, …) {
    // 전달받은 아규먼트로 처리할 코드 작성
    }
  }
-->
<template>
  <div>
    <h1>사용자 정의 이벤트(자식 -> 부모 이벤트 발신)</h1>
    <!-- 자식 컴포넌트로부터 전달받은 이벤트(nameChanged) -->
    <!-- 감지되었을 때(이벤트 리스너, @nameChanged) -->
    <!-- 이벤트 핸들러 메소드(nameChangeHandler)가 호출 -->
    <InputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터: {{ name }}</h3>
  </div>
</template>
<script>
import InputName from './components/InputName.vue';

export default {
  name: 'App',
  components: { InputName },
  data() {
    return { name: '' };
  },
  methods: {
    nameChangedHandler(e) {
      this.name = e.name;
    },
  },
};
</script>
