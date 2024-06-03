<template>

</template>

<script lang="ts">
import { defineComponent, ref } from 'vue';
import { useRouter } from 'vue-router';

export default defineComponent({
    name: 'LoginView',
    setup() {
        const username = ref('');
        const router = useRouter();
        
        const login = () => {
            
        };

        return {
            username,
            login,
        };
    },
});

</script>

<style scoped>

</style>