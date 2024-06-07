import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import { useUserStore } from '@/store/modules/user';

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
    
    {
        path: '/board',
        component: () => import('@/views/Board/BoardView.vue'),
        name: 'Board',
        meta: { requiresAuth: true}
    },
    // 다른 라우트들...
]

const router = createRouter({
    history: createWebHistory(),
    routes,
})

router.beforeEach((to, from, next) => {
    const userStore = useUserStore();
    const isAuthenticated = userStore.getUserInfo;

    if(to.meta.requiresAuth && !isAuthenticated) {
        next('/login');
    } else {
        next();
    }
});



export default router;
