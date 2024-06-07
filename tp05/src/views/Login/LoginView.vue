<script setup lang="ts">
// host/login 페이지
import { ref } from 'vue';
import { LoginForm, RegisterForm } from './components';

const isLogin = ref(true);

const toRegister = () => {
    isLogin.value = false;
}

const toLogin = () => {
    isLogin.value = true;
}

</script>

<template>
    <div id="loginContainer" class="login-container">
        <LoginForm v-if="isLogin" @to-register="toRegister"></LoginForm>
        <RegisterForm v-else @to-login="toLogin" ></RegisterForm>
    </div>
</template>

<style scoped>
.login-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f0f0f0;
}
</style>