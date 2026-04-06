<template>
  <div><h2>콘솔 확인하기</h2></div>
</template>

<script setup>
import axios from 'axios';

// 전체 목록 조회 URL
const BASEURL = '/api/todos2';

// 에러처리 예제
const requestAPI = async () => {
  axios
    .get(BASEURL)
    .then((resp) => {
      console.log('응답 객체 : ', resp);
    })
    .catch((err) => {
      if (err instanceof Error) {
        // 객체 instanceof 타입 : 해당 객체가 특정 타입으로 만들어졌는지 확인하는 연산자
        // 맞으면 true, 아니면 false
        console.log('Error : ', err.message);
      } else console.log(err);
    });
};

requestAPI(); // 함수 호출
</script>
