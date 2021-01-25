<template>
  <div class="home">
    <img alt="Vue logo" src="../assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/>
    <button v-on:click=getTest()>REST API test</button>
    <h1>This is build test</h1>
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from '@/components/HelloWorld.vue'
import axios from 'axios'

export default {
  name: 'Home',
  components: {
    HelloWorld
  },
  methods: {
    getTest: async function () {
          console.log("test")
          const res = await axios.get('http://localhost:8080/vue-test/')
          const tmp = res.data.currencies
          console.log(tmp)
          this.$router.push('currency')
    }
  }
}


</script>
