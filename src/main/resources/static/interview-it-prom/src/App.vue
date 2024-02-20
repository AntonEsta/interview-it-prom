<template>
  <p>something</p>
  <MainMenu />
  <DataTable />
</template>

<script lang="ts">
import { defineComponent } from "vue";
import MainMenu from "./components/MainMenu.vue";
import DataTable from "./components/DataTable.vue";

export default defineComponent({
  name: "App",
  components: {
    MainMenu,
    DataTable,
  },
});
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
