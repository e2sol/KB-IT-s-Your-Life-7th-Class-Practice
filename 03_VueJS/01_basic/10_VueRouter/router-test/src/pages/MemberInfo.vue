<template>
  <div class="card card-body">
    <h2>MemberInfo</h2>
    <div>
      경로 패턴 : /members/:id <br />
      요청 경로 : {{ currentRoute.fullPath }} <br />
      id값 : {{ currentRoute.params.id }} <br />
    </div>
  </div>
</template>

<script>
import { useRoute } from 'vue-router';
import members from '@/members.json';

export default {
  name: 'MemberInfo',
  setup() {
    const currentRoute = useRoute();
    // URI 경로와 함께 전달된 데이터에 접근하기 위해 .params 이용
    const id = parseInt(currentRoute.params.id, 10);
    const member = members.find((m) => m.id === id);

    return { currentRoute };
  },
};
</script>

<style scoped></style>
