import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Satzung from "@/components/sites/Satzung";
import Impressum from "@/components/sites/Impressum";
import Login from "@/components/sites/Login";
import Dashboard from "@/components/members/Dashboard";

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/satzung',
    name: 'Satzung',
    component: Satzung
  },
  {
    path: '/impressum',
    name: 'Impressum',
    component: Impressum
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/dashboard',
    name: 'Dashboard',
    component: Dashboard,
    beforeEnter: (to, from, next) => {
      const token = localStorage.getItem('token');
      if (token) {
        next()
      } else {
        next('/login');
      }
    }
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
