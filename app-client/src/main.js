import Vue from 'vue'
import './plugins/vuetify'
import axios from 'axios'
import App from './App.vue'
import router from './router'
import store from './store'

// Layouts
import DefaultLayout from '@/views/MainLayout'
import EmptyLayout from '@/views/EmptyLayout'

Vue.config.productionTip = false

// Global components
// The components declared here 
// are mainly views / layouts
Vue.component('default-layout', DefaultLayout)
Vue.component('empty-layout', EmptyLayout)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
