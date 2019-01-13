<template>
  <v-app id="inspire">
    <component :is="layout">
      <router-view/>
    </component>
  </v-app>
</template>

<script>  
  export default {
    data: () => ({
      default: 'default'
    }),
    computed: {
      layout () {
        return this.$route.meta.layout || this.$store.getters.DEFAULT_LAYOUT
      }
    }
  }
</script>
