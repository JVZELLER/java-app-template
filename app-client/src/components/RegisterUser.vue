<template>
  <v-layout align-center justify-center>
    <v-flex xs12>
      <v-stepper v-model="step">
        <v-stepper-header>
          <template v-for="n in stepNumbers">
            <v-stepper-step
              :complete="step > n"
              :key="`${n}-step`"
              :step="n"
              editable
            >
              {{ stepTitles[n-1] }}
            </v-stepper-step>
          </template>
        </v-stepper-header>

        <v-stepper-items>
          <v-stepper-content
            v-for="n in stepNumbers"
            :key="`${n}-contentPage`"
            :step="n"
          >
          <component :is="`${content[n-1]}`">
          </component>
          <v-btn
            color="primary"
            :disabled="$store.getters.FORM_VALIDATION"
            @click="nextStep(n)"
          >
            Continue
          </v-btn>

          <v-btn flat>Cancel</v-btn>
          </v-stepper-content>
        </v-stepper-items>
      </v-stepper>
    </v-flex>
  </v-layout>
</template>

<script>
  import PersonalData from '@/components/PersonalData'
  import UserData from '@/components/UserData'

  export default {
    data: () => ({
      step: 1,
      stepNumbers: 2,
      stepTitles: ['Dados Pessoais', 'Dados de Usuário', 'Permissões'],
      content: ['personal-data', 'user-data']
    }),
    methods: {
      nextStep (currentStep) {
        if (currentStep === this.stepNumbers) {
          this.step = 1
        } else {
          this.step += 1
        }
      },
      contentPage (currentStep) {
        return this.content[currentStep - 1]
      }
    },
    components: {
      PersonalData,
      UserData
    }
  }
</script>