<template>
  <v-form
    ref="form"
    v-model="valid"
    lazy-validation
    novalidate="true"
  >
    <v-text-field
      v-model="user.name"
      :rules="nameRules"
      label="Nome"
      required
      lazy-validation
    ></v-text-field>

    <v-text-field
      v-model="user.lastName"
      :rules="lastNameRules"
      label="Sobrenome"
      required
      lazy-validation
    ></v-text-field>

    <v-text-field
      v-model="user.email"
      :rules="emailRules"
      label="E-mail"
      required
      lazy-validation
    ></v-text-field>
  </v-form>
</template>

<script>
  export default {
    data: () => ({
      valid: null,
      user: {},
      fields: ['name', 'lastName', 'email'],
      nameRules: [
        v => !!v || 'Name is required'
      ],
      lastNameRules: [
        v => !!v || 'Last Name is required'
      ],
      emailRules: [
        v => !!v || 'E-mail is required',
        v => /.+@.+\.+./.test(v) || 'E-mail must be valid'
      ],
    }),
    methods: {
      validate () {
        const invalidState = Object.values(this.$refs.form.errorBag).find(i => i === true)
        let invalidData = false
        this.fields.forEach(f => {
            if (!this.user[f]) {
              invalidData = true
            }
        })
        this.$emit('validate', invalidData || invalidState)
      }
    },
    watch: {
      'user.email' (data) {
        if(data.length > 1)
          this.validate()
      }
    }
  }
</script>
