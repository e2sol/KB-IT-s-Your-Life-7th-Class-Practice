<template>
  <div><h2>콘솔 확인하기</h2></div>
</template>

<script setup>
import axios from 'axios';

// 전체 목록 조회 URL
const BASEURL = '/api/todos';

const requestAPI = async () => {
  let data = { todo: '복습하기', desc: '이해가 될 때 까지' };

  // POST 요청 : 데이터 추가
  const resp = await axios.post(BASEURL, data);
  console.log(resp.data);
};

requestAPI(); // 함수 호출
</script>
