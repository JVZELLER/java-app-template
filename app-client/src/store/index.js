import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    defaultLayout: 'default-layout',
    formValidation: true
  },
  getters: {
    DEFAULT_LAYOUT: state => {
      return state.defaultLayout
    },
    FORM_VALIDATION: state => {
      return state.formValidation
    }

  },
  mutations: {
    SET_DEFAULT_LAYOUT: (state, payload) => {
      state.defaultLayout = payload
    },
    SET_FORM_VALIDATION: (state, payload) => {
      state.formValidation = payload
    }

  },
  actions: {
    CHANGE_LAYOUT: (context, payload) => {
      context.commit('SET_DEFAULT_LAYOUT', payload)
    },
    CHANGE_FORM_VALIDATION: (context, payload) => {
      context.commit('SET_FORM_VALIDATION', payload)
    }
  }
})
