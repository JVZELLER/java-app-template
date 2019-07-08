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
    ></v-text-field>

    <v-text-field
      v-model="user.lastName"
      :rules="nameRules"
      label="Sobrenome"
      required
      @change="validate()"
    ></v-text-field>

    <v-text-field
      v-model="user.email"
      :rules="emailRules"
      label="E-mail"
      required
      @change="validate()"
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
    created () {
      this.$store.dispatch('CHANGE_FORM_VALIDATION', true)
    },
    methods: {
      validate () {
        this.$store.dispatch('CHANGE_FORM_VALIDATION', !this.valid + !this.$refs.form.validate())
        this.$refs.form.resetValidation()

      }
    }
  }
</script>