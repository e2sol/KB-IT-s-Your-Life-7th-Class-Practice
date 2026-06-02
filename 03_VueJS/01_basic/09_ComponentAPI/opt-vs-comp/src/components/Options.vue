<template>
  <div>
    <h3>Options API 적용</h3>

    <div>
      이름 :
      <input
        type="text"
        placeholder="입력 시 대문자로 변환"
        :value="name"
        @input="changeName($event.target.value)"
      />
      <!-- $event.target : 이벤트가 발생한 HTML 요소 -->
    </div>
    <hr />
    <div>
      <h5>계산하기</h5>
      <div>
        X : <input type="text" v-model.number="calc.x" /> <br />
        Y : <input type="text" v-model.number="calc.y" /> <br />
        <button @click="calculateSum(calc.x, calc.y, 1)">X + Y</button>
        <p>X + Y = {{ calc.result }}</p>
      </div>

      <div>
        A : <input type="text" v-model.number="calc.a" /> <br />
        B : <input type="text" v-model.number="calc.b" /> <br />
        <button @click="calculateSum(calc.a, calc.b, 2)">A + B</button>
        <p>A + B = {{ calc.result2 }}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'Options',
  data() {
    return {
      name: '',
      calc: {
        x: null,
        y: null,
        result: null,
        a: null,
        b: null,
        result2: null,
      },
    };
  },
  methods: {
    changeName(inputName) {
      // console.log(inputName);

      // 문자열.toUpperCase() : 문자열을 대문자로 변환
      this.name = inputName.toUpperCase();
    },
    calculateSum(num1, num2, type) {
      //   console.log(e);
      if (type === 1) {
        this.calc.result = num1 + num2;
      } else {
        this.calc.result2 = num1 + num2;
      }
    },
  },
};
</script>

<style scoped></style>
