import Vue from 'vue'
import Router from 'vue-router'
import Login from '@/components/LoginForm'
import HomeContent from '@/components/HomeContent'
import RegisterUser from '@/components/RegisterUser'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeContent
    },
    {
      path: '/login',
      name: 'login',
      meta: {layout: 'empty-layout'},
      component: Login
    },
    {
      path: '/registerUser',
      name: 'registerUser',
      component: RegisterUser
    }
  ]
})