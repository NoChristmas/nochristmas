<script setup lang="ts">
import { ref, defineEmits } from 'vue';
import { useRouter } from 'vue-router';
import axios from '@/axios';
import { useUserStore } from '@/store/modules/user';

const router = useRouter();
const usrId = ref('');
const pwd = ref('');

const emit = defineEmits(['to-register']);

const userStore = useUserStore();

const toRegister = () => {
    emit('to-register');
}

const login = async () => {
    //데이터 담는 영역
    const data = { usr_id : usrId.value, usr_pwd: pwd.value };
    const res = await axios.post('/login', data);
    const isAuthenticated = res.data.result == 'success'; 
    
    if(isAuthenticated) {
        const userInfo = res.data.data[0];
        userStore.setUserInfo(userInfo);
        alert('로그인 성공!');
        router.push('/board');
        
    } else {
        alert('로그인 실패');
    }
};

</script>

<template>
    <form @submit.prevent="login" class="login-form">
        <div class="form-group">
            <label for="username" class="form-label">ID</label>
            <input type="text" id="username" v-model="usrId" class="form-input" />
        </div>
        <div class="form-group">
            <label for="password" class="form-label">Password</label>
            <input type="password" id="password" v-model="pwd" class="form-input" />
        </div>
        <button type="submit" class="btn-login">Login</button>
        <button type="button" class="btn-register" @click="toRegister">Register</button>
    </form>
</template>

<style scoped>
.login-form {
  width:300px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
  
}

.form-group {
  margin-bottom: 15px;
  display:flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.form-label {
  display: block;
  margin-bottom: 5px;
}

.form-input {
  width: 100%;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 3px;
  align-items: center;
  justify-content: center;
}

.btn-login, .btn-register {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  margin-top:10px;
}

.btn-login:hover, .btn-register:hover {
  background-color: #0056b3;
}


</style>