<template>
  <div>
    <van-field label="A" label-width="auto"/>
  </div>
</template>

<script>

export default {
  name: 'RecordList',
  components: {},
  methods: {
    async getRecordCommitStatus() {
      let r = await this.$post('/home')
      console.log(r)
      r = await this.$get('/home')
      console.log(r)
    }
  },
  mounted() {
    this.getRecordCommitStatus();
  }
}
</script>
