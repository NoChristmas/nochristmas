<script setup lang="ts">
import { ref } from 'vue';

const username = ref('');
const password = ref('');

const login = () => {
    
};
</script>

<template>
    <form @submit.prevent="login" class="login-form">
        <div>
            <label for="username">Username:</label>
            <input type="text" id="username" v-model="username" />
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" v-model="password" />
        </div>
        <button type="submit">Login</button>
    </form>
</template>

<style scoped>
.login-form {
    max-width: 300px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ccc;
    border-radius: 5px;
    background-color: #f9f9f9;
}
</style>