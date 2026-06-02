<template>
  <div><h2>콘솔 확인하기</h2></div>
</template>

<script setup>
import axios from 'axios';

// 전체 목록 조회 URL
const listUrl = '/api/todos';
const todoUrlPrefix = '/api/todos/';

// 전체 목록을 조회한 후 한 건씩 순차적으로 순회(반복)하면서 조회하기
const requestAPI = async () => {
  let todoList;
  let response = await axios.get(listUrl);
  todoList = response.data;

  for (let i = 0; i < todoList.length; i++) {
    response = await axios.get(todoUrlPrefix + todoList[i].id);
    console.log(`## ${i + 1}번째 Todo : `, response.data);
  }
};

requestAPI(); // 함수 호출
</script>
