import Vue from 'vue'
import './plugins/vuetify'
import Axios from 'axios'
import App from './App.vue'
import CoreComponents from '@/core/components'
import Listener from '@/listener'
import i18n from './i18n'
import router from '@/router'

Vue.config.productionTip = false

Vue.use(CoreComponents)

Vue.mixin({
  methods: {},
  data () {
    return {
      get Axios () {
        return Axios
      },
      get Listener () {
        return Listener
      }
    }
  }
})

new Vue({
  router,
  i18n,
  render: h => h(App)
}).$mount('#app')
