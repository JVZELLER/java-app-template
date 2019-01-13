import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    defaultLayout: 'default-layout'
  },
  getters: {
    DEFAULT_LAYOUT: state => {
      return state.defaultLayout
    }

  },
  mutations: {
    SET_DEFAULT_LAYOUT: (state, payload) => {
      state.defaultLayout = payload
    }

  },
  actions: {
    CHANGE_LAYOUT: (context, payload) => {
      context.commit('SET_DEFAULT_LAYOUT', payload)
    }
  }
})
