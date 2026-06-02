<script>
import Calc from './components/Calc.vue';
import Calc2 from './components/Calc2.vue';
import Calc3 from './components/Calc3.vue';
import Calc4 from './components/Calc4.vue';
import Calc5 from './components/Calc5.vue';

export default {
  name: 'App',
  components: {
    Calc,
    Calc2,
    Calc3,
    Calc4,
    Calc5,
  },
};
</script>

<template>
  <div>
    <h3>Calc 컴포넌트 연결</h3>
    <Calc />
    <br />
    <hr />
    <br />
    <h3>Calc2 컴포넌트 연결</h3>
    <Calc2 />
    <br />
    <hr />
    <br />
    <h3>Calc3 컴포넌트 연결</h3>
    <Calc3 />
    <br />
    <hr />
    <br />
    <h3>Calc4 컴포넌트 연결</h3>
    <Calc4 />
    <br />
    <hr />
    <br />
    <h3>Calc5 컴포넌트 연결</h3>
    <Calc5 />
  </div>
</template>

<style scoped></style>
