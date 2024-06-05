import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import tsconfigPaths from 'vite-tsconfig-paths';
import path from 'path';

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), tsconfigPaths()],
  resolve: {
    alias: {
      '@': path.resolve(__dirname,'./src'),
    }
  },
  server: {
    port: 3000,
    // proxy: {
    //   "/api/v1": 'http://localhost:11000'
        
    // }
  }
})
