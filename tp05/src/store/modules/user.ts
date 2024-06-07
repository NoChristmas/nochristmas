import { defineStore } from 'pinia';
import { UserType } from '@/api/login/types';

//타입 선언
interface UserState { 
    userInfo?: UserType
}

export const useUserStore = defineStore('user', {
    state: (): UserState => {
        return {
            userInfo: undefined
        }
    },
    getters: {
        getUserInfo(): UserType | undefined {
            return this.userInfo;
        }
    },
    actions: {
        setUserInfo(userInfo?: UserType) {
            this.userInfo = userInfo;
        },
        reset() {
            this.setUserInfo(undefined)
        },
        logout() {
            this.reset()
        }
    },
});