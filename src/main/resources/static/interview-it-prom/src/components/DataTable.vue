<template>
  <div v-if="headers.length > 0 && cells.length > 0" class="container">
    <table class="table table-hover table-striped">
      <thead>
        <tr>
          <td v-for="(head, index) in headers" :key="index">{{ head }}</td>
        </tr>
      </thead>
      <tbody>
        <tr v-for="(row, index) in cells" :key="index">
          <td v-for="(data, index) in row" :key="index">{{ data }}</td>
        </tr>
      </tbody>
    </table>
  </div>
  <div v-else>
    <p>Нет данных для отображения!</p>
  </div>
</template>
<script lang="ts">
export default {
  data() {
    // return {
    //   headers: ["head1", "head2"],
    //   cells: [
    //     ["1.1", "1.2"],
    //     ["2.1", "2.2"],
    //   ],
    // };
    return {
      headers: [],
      cells: [],
    };
  },
};
</script>
