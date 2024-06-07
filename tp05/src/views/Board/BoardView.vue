<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useUserStore } from '@/store/modules/user';
import { BoardList } from './components';
import { UserType } from '@/api/login/types';
import { BoardType } from '@/api/board/types';

import axios from '@/axios';

const userStore = useUserStore();

const userInfo = userStore.getUserInfo as UserType | undefined;

const boardsData = ref<BoardType[]>([]);

const fetchBoards = async () => {
    
    const res = await axios.get("/board");

    boardsData.value = res.data.data; 

};
// 컴포넌트가 마운트 될 때 보드 데이터를 가져옴.
onMounted(() => {
    if(userInfo) {
        fetchBoards();
    }
});


</script>

<template>
    <div id="UserContainer" class="user-container">
        {{ userInfo?.usr_id }}님 환영합니다!
    </div>
    <div id="BoardContainer" class="board-container">
        <BoardList :boardsData="boardsData"></BoardList>
    </div>

</template>

<style scoped>
.user-container {
    display:flex;
    justify-content: flex-end;
    
}

.board-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
    background-color: #f0f0f0;
}
</style>