<template>
  <div>
    <h1>이벤트 유효성 검증</h1>
    <InputName @nameChanged="nameChangedHandler" />
    <br />
    <h3>App 데이터: {{ name }}</h3>
  </div>
</template>
<script>
import InputName from './components/InputName2.vue';

export default {
  name: 'App4-2',
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
