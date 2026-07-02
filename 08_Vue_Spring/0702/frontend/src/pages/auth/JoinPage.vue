<script setup>
// 컴포넌트 설정
import { reactive, ref } from 'vue';
import { useRouter } from 'vue-router';
import authApi from '@/api/authApi';

const router = useRouter();
const avatar = ref(null); // 파일 input 참조
const checkError = ref(''); // 중복 체크 메시지
const disableSubmit = ref(true); // 제출 버튼 비활성화 상태

// 회원 정보 reactive 객체
const member = reactive({
  username: '',
  email: '',
  password: '',
  password2: '', // 비밀번호 확인
  avatar: null,
});

// ------------------------------------------------------------------------------------------------------------------------------

// ID 중복 체크 로직
const checkUsername = async () => {
  // username 중복 체크
  if (!member.username) {
    return alert('사용자 ID를 입력하세요.');
  }

  // 중복 검사 결과
  // - true  : 중복 O(이미 사용 중, class='text-danger' , 버튼 비활성)
  // - false : 중복 X(사용 가능   , class='text-primary', 버튼 활성)
  disableSubmit.value = await authApi.checkUsername(member.username);
  checkError.value = disableSubmit.value
    ? '이미 사용중인 ID입니다.'
    : '사용 가능한 ID입니다.';
};

// username 입력 핸들러
const changeUsername = () => {
  disableSubmit.value = true; // 제출 버튼 비활성화
  checkError.value = member.username ? 'ID 중복 체크를 하셔야 합니다.' : '';
};

// ------------------------------------------------------------------------------------------------------------------------------

// 회원가입 처리
const join = async () => {
  // 이메일 입력 검증
  if (member.email.trim() === '') {
    return alert('이메일을 입력해주세요');
  }

  // 비밀번호 확인 검증
  if (member.password != member.password2) {
    return alert('비밀번호가 일치하지 않습니다.');
  }

  // 아바타 파일 설정
  if (avatar.value.files.length > 0) {
    member.avatar = avatar.value.files[0];
  }

  try {
    await authApi.create(member); // 회원가입 API 호출
    alert('가입 성공!');
    router.push({ name: 'login' }); // 성공 시 홈페이지로 이동
  } catch (e) {
    console.error(e);
  }
};
</script>

<template>
  <h1>JoinPage</h1>
</template>
