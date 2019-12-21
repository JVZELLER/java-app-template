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
      defaultLayout: 'default-layout'
    }),
    computed: {
      layout () {
        return this.$route.meta.layout || this.defaultLayout
      }
    }
  }
</script>
