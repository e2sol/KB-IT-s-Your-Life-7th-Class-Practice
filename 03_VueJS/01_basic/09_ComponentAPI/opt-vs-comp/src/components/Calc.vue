<template>
  <div>
    <h3>다른 컴포넌트</h3>
    <div>
      X : <input type="text" v-model.number="x" /> <br />
      Y : <input type="text" v-model.number="y" /> <br />
      <button @click="calculateSum(x, y, 1)">X + Y</button>
      <p>X + Y = {{ result }}</p>
    </div>
  </div>
</template>
<script setup>
import { useCalc } from './Composition.vue';

const { x, y, result, calculateSum } = useCalc();
// useCalc()의 return 된 객체에서 필요한 속성만 가져옴
</script>
