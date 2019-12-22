<template>
  <v-container fluid fill-height>
    <!-- This is an empty layout to wrap components such as 'Login' that
      doesn't need any fancy nav or toolbar -->
    <v-content>
      <slot />
    </v-content>
  </v-container>
</template>

<script>
  export default {
  }
</script>
