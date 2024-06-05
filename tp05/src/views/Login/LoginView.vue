<script setup lang="ts">
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
        <LoginForm v-if="isLogin" :on-to-register="toRegister"></LoginForm>
        <RegisterForm v-else :on-to-sss="toLogin" ></RegisterForm> <!--수정필요-->
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