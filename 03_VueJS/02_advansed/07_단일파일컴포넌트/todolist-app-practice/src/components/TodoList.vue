<template>
  <div class="row">
    <div class="col">
      <ul class="list-group">
        <TodoListItem />
      </ul>
    </div>
  </div>
</template>
<script>
import TodoListItem from './TodoListItem.vue';

export default {
  name: 'TodoList',
  components: {
    TodoListItem
  }
};
</script>
