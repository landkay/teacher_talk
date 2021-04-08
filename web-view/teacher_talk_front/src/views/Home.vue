<template>
  <div>
    <div>
      <van-image src="https://img01.yzcdn.cn/vant/cat.jpeg">
        <template v-slot:loading>
          <van-loading type="spinner" size="20" />
        </template>
      </van-image>
    </div>
    <div>
      <ul v-for="menu in menus">
        <li @click="$router.push(menu.path)">
          {{menu.name}}
        </li>
      </ul>
    </div>
  </div>
</template>

<script>

export default {
  name: 'Home',
  data() {
    return {
      menus: [{name: '工作日志', ico: '', path: '/record_list'}, {name: '项目数据', ico: '', path: '/'}]
    }
  },
  mounted() {
    console.log(1)
  }
}
</script>
