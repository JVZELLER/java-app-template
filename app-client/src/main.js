import Vue from 'vue'
import './plugins/vuetify'
import axios from 'axios'
import App from './App.vue'
import router from './router'
import store from './store'
import CoreComponents from '@/core/components'

Vue.config.productionTip = false

Vue.use(CoreComponents)

Vue.mixin({
  methods: {},
  data () {
    return {
    }
  }
})

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')
