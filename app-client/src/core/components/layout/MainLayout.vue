<template>
  <v-container fluid fill-height>
    <navigation-drawer/>
    <toolbar/>
    <v-content>
      <slot/>
    </v-content>
  </v-container>
</template>

<script>
  import NavigationDrawer from './navigation-drawer'
  import Toolbar from './toolbar'
  export default {
    components: {
      NavigationDrawer,
      Toolbar
    },
  }
</script>
