<script setup lang="ts">
import { BoardType } from '@/api/board/types';

const props = defineProps<{
  boardsData: BoardType[];
}>();
</script>

<template>
  <div v-if="props.boardsData.length > 0" class="board-list">
    <div v-for="board in props.boardsData" :key="board.bd_no" class="board-card">
      <div class="board-header">
        <h2>{{ board.bd_name }}</h2>
      </div>
      <div class="board-body">
        <p>작성자: {{ board.usr_id }}</p>
      </div>
    </div>
  </div>
  <div v-else class="no-data">
    데이터가 없습니다.
  </div>
</template>

<style scoped>
.board-list {
  display: flex;
  flex-wrap: wrap;
  gap: 20px;
  justify-content: center;
  padding: 20px;
}

.board-card {
  background-color: #fff;
  border: 1px solid #ddd;
  border-radius: 5px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
  overflow: hidden;
  transition: transform 0.2s;
  width: 300px;
}

.board-card:hover {
  transform: scale(1.05);
}

.board-header {
  background-color: #007bff;
  color: #fff;
  padding: 10px;
  text-align: center;
}

.board-header h2 {
  margin: 0;
  font-size: 1.5em;
}

.board-body {
  padding: 15px;
}

.board-body p {
  margin: 0;
  color: #333;
}

.no-data {
  text-align: center;
  font-size: 1.2em;
  color: #888;
  margin-top: 50px;
}
</style>
