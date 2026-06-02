<template>
  <div class="container">
    <Header />
    <RouterView :todoList="states" />
  </div>
</template>
<script setup>
import { reactive, computed, provide } from 'vue';
import Header from '@/components/Header.vue';

const states = reactive({
  todoList: [
    { id: 1, todo: 'ES6 학습', desc: '설명1', done: false },
    { id: 2, todo: 'React 학습', desc: '설명2', done: false },
    { id: 3, todo: 'ContextAPI 학습', desc: '설명3', done: true },
    { id: 4, todo: '야구경기관람', desc: '설명4', done: false },
  ],
});

const addTodo = ({ todo, desc }) => {
  states.todoList.push({ id: new Date().getTime(), todo, desc, done: false });
};
const updateTodo = ({ id, todo, desc, done }) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index] = { ...states.todoList[index], todo, desc, done };
  // ...states.todoList[index] : 기존 객체 복사
  // 같은 키(todo, desc, done)는 새 값으로 덮어쓰기
};
const deleteTodo = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList.splice(index, 1);
};
const toggleDone = (id) => {
  let index = states.todoList.findIndex((todo) => todo.id === id);
  states.todoList[index].done = !states.todoList[index].done;
};
// provide : 자식 컴포넌트로 데이터를 넘기는 함수 전달할 데이터의 key와 value를 지정
// 중간 컴포넌트를 거치지 않아도 자손 컴포넌트에 직접 접근이 가능
// 반응성 변수의 반응성이 유지되고 변경 권한은 부모만 가지는 구조가 권장
provide(
  'todoList',
  computed(() => states.todoList),
);
provide('actions', { addTodo, deleteTodo, toggleDone, updateTodo });
</script>
