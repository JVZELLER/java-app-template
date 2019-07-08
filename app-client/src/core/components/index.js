import Vuetify from 'vuetify'
import MainLayout from './layout/MainLayout'
import EmptyLayout from './layout/EmptyLayout'

export default {
  install (Vue) {
    Vue.component('default-layout', MainLayout)
    Vue.component('empty-layout', EmptyLayout)
    Vue.use(Vuetify)
  }
}
