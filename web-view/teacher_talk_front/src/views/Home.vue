<template>
  <div>
    <div>
      <van-swipe :autoplay="3000" indicator-color="white">
        <van-swipe-item v-for="banner in banners">
          <img :src="banner.url" />
        </van-swipe-item>
      </van-swipe>
    </div>
    <div>
      <ul>
        <li v-for="menu in menus" @click="$router.push(menu.path)">
          <div>
            <img :src="menu.ico" />
            <div>{{menu.name}}</div>
          </div>
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
      banners: [
          {url: require('@/assets/images/banner/banner1.png'), href: ''},
          {url: require('@/assets/images/banner/banner1.png'), href: ''}
      ],
      menus: [
          {name: '工作日志', ico: require('@/assets/images/calendar.png'), path: '/record_list'},
          {name: '项目数据', ico: require('@/assets/images/search.png'), path: '/record_search'}
      ]
    }
  },
  async mounted() {
    const result = await this.$post('/saveLoginLog');
    console.log(result);
  }
}
</script>

<style scoped lang="less">

  .van-swipe-item {
    img {
      width: 100%;
      height: 2rem;
    }
  }

  ul {
    width: 100%;
    li {
      width: 25%;
      float: left;
      padding: .1rem 0;
      img {
        width: 60%;
        height: 60%;
      }
    }
  }

</style>
