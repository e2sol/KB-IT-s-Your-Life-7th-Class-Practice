<template>
  <li class="list-group-item">
    <input type="checkbox" class="pointer me-3" />
    <span class="pointer"> 할일 (완료) </span>
    <span class="float-end badge bg-secondary pointer">삭제</span>
  </li>
</template>
<script>
export default {
  name: 'TodoListItem',
};
</script>
