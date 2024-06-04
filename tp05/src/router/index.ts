import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'

const routes: Array<RouteRecordRaw> = [
    { 
        path: '/', 
        redirect: '/login', //기본경로 로그인페이지
    },
    {
        path: '/login',
        component: () => import('@/views/Login/LoginView.vue'),
        name: 'Login',
    },
    // 다른 라우트들...
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

export default router
