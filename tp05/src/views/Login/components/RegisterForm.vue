<script setup lang="ts">
import { ref, defineEmits, defineProps } from 'vue';
import axios from '@/axios';

const usrId = ref('');
const pwd = ref('');
const emit = defineEmits(['to-login']);

const register = async () => {
    const data = { usr_id: usrId.value, usr_pwd: pwd.value };
    
    const res = await axios.post("/register", data);

    const isRegister = res.data.result == 'success'; 

    if(isRegister) {
      alert('등록 성공');
      emit('to-login');
    } else {
      alert('등록 실패');  
    }
    
};

const toGoBack = () => {
    emit('to-login');
};

</script>

<template>
    <form @submit.prevent="register" class="register-form">
        <div class="form-group">
            <label for="username" class="form-label">ID 등록</label>
            <input type="text" id="username" v-model="usrId" class="form-input" />
        </div>
        <div class="form-group">
            <label for="password" class="form-label">Password 등록</label>
            <input type="password" id="password" v-model="pwd" class="form-input" />
        </div>
        <button type="submit" class="btn-register">회원가입</button>
        <button type="button" class="btn-goback" @click="toGoBack">뒤로가기</button>
    </form>
</template>

<style scoped>
.register-form {
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

.btn-goback, .btn-register {
  width: 100%;
  padding: 10px;
  background-color: #007bff;
  color: #fff;
  border: none;
  border-radius: 3px;
  cursor: pointer;
  margin-top:10px;
}

.btn-goback:hover, .btn-register:hover {
  background-color: #0056b3;
}
</style>