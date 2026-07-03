import { createRouter, createWebHistory } from 'vue-router';
import HomePage from '../pages/HomePage.vue';

// 기능별 라우터 import
import authRoutes from './auth';
import boardRoutes from './board';
import travelRoutes from './travel';
import galleryRoutes from './gallery';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: '/', name: 'home', component: HomePage },
    ...authRoutes, // 인증 관련 라우트 추가
    ...boardRoutes, // 게시판 관련 라우트 추가
    ...travelRoutes, // 여행 관련 라우트 추가
    ...galleryRoutes, // 갤러리 관련 라우트 추가

    // ... : 전개 연산자. 배열 내부의 값들을 풀어서 작성한 것처럼 처리
  ],
});

export default router;
