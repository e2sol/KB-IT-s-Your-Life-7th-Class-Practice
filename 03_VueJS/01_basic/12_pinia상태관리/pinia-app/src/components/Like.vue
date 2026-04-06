<template>
  <div>
    <button @click="increase">좋아요 누르기</button>
  </div>
</template>

<script setup>
import { useLikeStore } from '@/stores/01_basic/like';

// useLikeStore 내 이름이 동일한 내용이 해당 변수에 담김
const { increase } = useLikeStore();
</script>

<style scoped></style>
