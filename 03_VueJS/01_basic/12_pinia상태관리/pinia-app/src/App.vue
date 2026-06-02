<script setup>
import Like from '@/components/Like.vue';
import Counter from '@/components/Counter.vue';

// 01_basic
import { useLikeStore } from '@/stores/01_basic/like.js';
const likeStore = useLikeStore();
</script>

<template>
  <div>
    <h1>Pinia 상태 관리 예제</h1>
    <h2>좋아요 수 : {{ likeStore.like }}</h2>
    <h2>좋아요 수 5배 증가 : {{ likeStore.fivetimes }}</h2>
    <Like />
    <hr />
    <Counter />
  </div>
</template>

<style scoped></style>
