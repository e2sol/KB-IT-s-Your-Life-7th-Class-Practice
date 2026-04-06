<template>
  <div><h2>콘솔 확인하기</h2></div>
</template>

<script setup>
import axios from 'axios';

// 전체 목록 조회 URL
const BASEURL = '/api/todos';

// 에러처리 예제

/* try - catch - finally
 * try{ } : 예외가 발생할 가능성이 있는 코드
 * catch(e){ } : 예외 발생 시 수행할 코드
 * finally{ } : 마지막에 무조건 수행
 */
const requestAPI = async () => {
  try {
    // 에러 발생 시 즉시 종료 후 catch문으로 이동
    const resp = await axios.get(BASEURL);
    console.log('응답 객체 : ', resp);
  } catch (err) {
    console.log('Error 발생 시에만 수행');

    if (err instanceof Error) console.log(err.message);
    else console.log(err);
  } finally {
    // 무조건 수행
    console.log('finally는 무조건 수행!');
  }
};

requestAPI(); // 함수 호출
</script>
