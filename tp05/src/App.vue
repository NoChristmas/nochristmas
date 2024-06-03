<script setup lang="ts">
import { ref } from 'vue';

const products = ref<string[]>(['역삼동원룸', '천호동원룸', '마포구원룸']);
const prices = ref<number[]>([50,60,70]);
const singoCnt = ref<number[]>([0,0,0]);

const increaseSingoCnt:void = (idx:number) => {
  singoCnt.value[idx] += 1;
}
</script>

<template>
  <div v-for="(product, i) in products" :key="i">
    <h4>{{ product }}</h4>
    <div>{{ prices[i] }} 만원</div>
    <button @click="increaseSingoCnt(i)">허위매물신고</button> <span>신고수 : {{ singoCnt[i] }}</span>
  </div>
  
</template>

<style scoped>


</style>
