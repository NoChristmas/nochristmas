import { createRouter, createWebHistory, RouteRecordRaw } from "vue-router";
import LoginView from "@/views/ChatRoomView.vue";
import ChatRoomView from "@/views/ChatRoomView.vue";

const routes: Array<RouteRecordRaw> = [
    { path: '/', name: 'Login', component: LoginView },
    { path: '/chat', name: 'ChatRoom', component: ChatRoomView}
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});