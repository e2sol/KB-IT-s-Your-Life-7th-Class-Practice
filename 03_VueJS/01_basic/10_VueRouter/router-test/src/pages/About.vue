<template>
  <div class="card card-body">
    <h2>About</h2>
    <p>요청 경로 : {{ currentRoute.path }}</p>
  </div>
</template>

<script setup>
import { useRoute } from 'vue-router';

// export default {
//   name: 'About',
//   setup() {
//     const currentRoute = useRoute();
//     console.log(currentRoute);
//     return { currentRoute };
//   },
// };

const currentRoute = useRoute();
console.log(currentRoute);
</script>

<style scoped></style>
