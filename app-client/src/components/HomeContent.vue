<template>
  <v-layout align-center justify-center>
    <v-flex xs12 sm8 md4>
      <v-timeline>
        <v-timeline-item
          v-for="n in 4"
          :key="n"
          color="red lighten-2"
          large
        >
          <span slot="opposite">
            Simple home content example
          </span>
          <v-card class="elevation-2">
            <v-card-title class="headline">
              Some Title
            </v-card-title>
            <v-card-text>
              Lorem ipsum dolor sit amet, no nam oblique veritus. Commune scaevola imperdiet nec ut, sed euismod convenire principes at. Est et nobis iisque percipit, an vim zril disputando voluptatibus, vix an salutandi sententiae.
            </v-card-text>
          </v-card>
        </v-timeline-item>
      </v-timeline>
    </v-flex>
  </v-layout>
</template>

<script>
  export default {
    data: () => ({
      text: 'Teste da home'
    })
  }
</script>