<script setup lang="ts">
import { defineProps, defineEmits } from 'vue';
import { BoardType } from '@/api/board/types';

const props = defineProps<{
  boardData: BoardType | undefined
}>();

const emits = defineEmits(['to-boards']);

const goBack = () => {
    emits('to-boards');
}

if(!props.boardData) {
    emits('to-boards');
}


</script>

<template>
  <div class="board-detail">
    <h2>게시물 상세 정보</h2>
    <p>게시물 번호: {{ boardData?.bd_no }}</p>
    <p>게시 내용: {{ boardData?.bd_name }}</p>
    <p>작성자: {{ boardData?.usr_id }}</p>
    <button @click="goBack">뒤로 가기</button>
  </div>
</template>

<style scoped>
/* 추가적인 스타일링은 필요에 따라 적용 */
</style>
