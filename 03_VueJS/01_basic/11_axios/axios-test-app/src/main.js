import { createApp } from 'vue';

// import App from './App.vue' // 프록시 서버
// import App from './App1.vue';
// import App from './App2.vue';
// import App from './App3.vue';
// import App from './App4.vue';
// import App from './App5.vue';
import App from './App6.vue';

import router from './router';

const app = createApp(App);

app.use(router);

app.mount('#app');
