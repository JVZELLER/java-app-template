<template>
  <v-layout align-center justify-center>
    <v-flex xs12>
      <v-stepper v-model="step">
        <v-stepper-header>
          <template v-for="n in steps">
            <v-stepper-step
              :complete="step > n"
              :key="`${n}-step`"
              :step="n"
            >
              {{ stepTitles[n-1] }}
            </v-stepper-step>
            <v-divider
             v-if="n !== steps"
             :key="n"
           ></v-divider>
          </template>
        </v-stepper-header>

        <v-stepper-items>
          <v-stepper-content
            v-for="n in steps"
            :key="`${n}-contentPage`"
            :step="n"
          >
          <component :is="`${content[n-1].name}`" @validate="validateContentPage(n, $event)">
          </component>
          <v-btn
            color="primary"
            :disabled="content[n-1].invalid"
            @click="nextStep(n)"
          >
            {{ 'Next' }}
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
    components: {
      PersonalData,
      UserData
    },
    data: () => ({
      step: 1,
      steps: 2,
      stepTitles: ['Dados Pessoais', 'Dados de Usuário', 'Permissões'],
      content: [{name: 'personal-data', invalid: true }, { name: 'user-data', invalid: true }]
    }),
    methods: {
      nextStep (currentStep) {
        if (currentStep === this.steps) {
          this.step = 1
        } else {
          this.step += 1
        }
      },
      contentPage (currentStep) {
        return this.content[currentStep - 1]
      },
      validateContentPage(pageNumber, state) {
        this.content[pageNumber - 1].invalid = state
      }
    }
  }
</script>
