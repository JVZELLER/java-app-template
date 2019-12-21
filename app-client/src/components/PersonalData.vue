<template>
  <v-form
    ref="form"
    v-model="valid"
    lazy-validation
  >
    <v-text-field
      v-model="user.name"
      :rules="nameRules"
      label="Nome"
      required
      @change="validate()"
      lazy-validation
    ></v-text-field>

    <v-text-field
      v-model="user.lastName"
      :rules="nameRules"
      label="Sobrenome"
      required
      @change="validate()"
      lazy-validation
    ></v-text-field>

    <v-text-field
      v-model="user.email"
      :rules="emailRules"
      label="E-mail"
      required
      @change="validate()"
      lazy-validation
    ></v-text-field>
  </v-form>
</template>

<script>
  export default {
    data: () => ({
      valid: null,
      user: {},
      nameRules: [
        v => !!v || 'Name is required'
      ],
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+/.test(v) || 'E-mail must be valid'
      ],
      checkbox: false
    }),
    methods: {
      validate () {
        // TODO:
        // Validate fiedls for each tab
      }
    }
  }
</script>
