<script setup lang="ts">
import { ref, onMounted } from 'vue';
import { useUserStore } from '@/store/modules/user';
import { BoardList, BoardDetail } from './components';
import { UserType } from '@/api/login/types';
import { BoardType } from '@/api/board/types';

import axios from '@/axios';

const userStore = useUserStore();

const userInfo = userStore.getUserInfo as UserType | undefined;

const isBoardList = ref(true);

const isBoardDetail = ref(false);

const isBoardWrite = ref(false);

const boardData = ref<BoardType | undefined>();

const boardsData = ref<BoardType[]>([]);

const selectBoardNo = ref(-1);

const fetchBoards = async () => {
    const res = await axios.get("/board", {
        params: {
            usr_no: userInfo?.usr_no,
            usr_id: userInfo?.usr_id
        }
    });
    boardsData.value = res.data.data; 
};
// 컴포넌트가 마운트 될 때 보드 데이터를 가져옴.
onMounted(() => {
    if(userInfo) {
        fetchBoards();
    }
});

const boardNumberHandle = async (bd_no: number) => {
    selectBoardNo.value = bd_no;
    
    if(selectBoardNo.value > 0) {
        const res = await axios.get("/board/${bd_no}");
        boardData.value = res.data;
        isBoardList.value = false;
        isBoardDetail.value = true;
    } else if (selectBoardNo.value === -1) {
        isBoardList.value = true;
        isBoardDetail.value = false;
        
    }
    
}
//디테일 영역 끝


</script>

<template>
    <div id="UserContainer" class="user-container">
        {{ userInfo?.usr_id }}님 환영합니다!
    </div>
    <div id="BoardContainer" class="board-container">
        <BoardList v-show="isBoardList" :boardsData="boardsData" @to-board-detail="boardNumberHandle"></BoardList>
        <BoardDetail v-show="isBoardDetail" :boardData="boardData" @to-boards="boardNumberHandle"></BoardDetail>

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