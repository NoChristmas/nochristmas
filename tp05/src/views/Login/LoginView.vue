<script setup lang="ts">
import { LoginForm } from './components';

</script>

<template>
    <div id="loginContainer" class="login-container">
        <LoginForm></LoginForm>
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