<template id="drawer">
  <v-navigation-drawer
    :clipped="$vuetify.breakpoint.lgAndUp"
    v-model="drawer"
    fixed
    app
  >
    <v-list dense>
      <template v-for="item in items">
        <v-list-group
          v-if="item.children"
          v-model="item.model"
          :key="item.text"
          :prepend-icon="item.model ? item.icon : item['icon-alt']"
          append-icon=""
        >
          <v-list-tile slot="activator">
            <v-list-tile-content>
              <v-list-tile-title>
                {{ item.text }}
              </v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
          <v-list-tile
            v-for="(child, i) in item.children"
            :key="i"
            @click="routerPushTo(child.goto)"
          >
            <v-list-tile-action v-if="child.icon">
              <v-icon>{{ child.icon }}</v-icon>
            </v-list-tile-action>
            <v-list-tile-content>
              <v-list-tile-title>
                {{ child.text }}
              </v-list-tile-title>
            </v-list-tile-content>
          </v-list-tile>
        </v-list-group>
        <v-list-tile v-else :key="item.text" @click="routerPushTo(item.goto)">
          <v-list-tile-action>
            <v-icon>{{ item.icon }}</v-icon>
          </v-list-tile-action>
          <v-list-tile-content>
            <v-list-tile-title>
              {{ item.text }}
            </v-list-tile-title>
          </v-list-tile-content>
        </v-list-tile>
      </template>
    </v-list>
  </v-navigation-drawer>
</template>

<script>
  export default {
    mounted () {
      this.attachListeners()
    },
    data: () => ({
      drawer: null,
      items: [
        { icon: 'add', text: 'Create User', heading: 'Nome', goto: 'registerUser' },
        { icon: 'history', text: 'Frequently contacted' },
        {
          icon: 'keyboard_arrow_up',
          'icon-alt': 'keyboard_arrow_down',
          text: 'More',
          model: false,
          children: [
            { icon: 'add', text: 'Create label' },
          ]
        },
        { icon: 'settings', text: 'Settings' },
        { icon: 'chat_bubble', text: 'Send feedback' },
        { icon: 'help', text: 'Help' },
      ]
    }),
    methods: {
      attachListeners () {
        this.Listener.$on('toggleDrawer', this.toggleDrawer)
      },
      toggleDrawer () {
        this.drawer = !this.drawer
      },
      routerPushTo(goto) {
        if(goto) {
          this.$router.push({ name: goto })
        }
      }
    }
  }
</script>
