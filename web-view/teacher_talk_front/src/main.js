import Vue from 'vue'
import App from './App.vue'
import router from './router'
import Vant from 'vant'
import { Image as VanImage } from 'vant'
import less from 'less'
import { post, get } from '@/api/axios'
import '@/utils/des'
import '@/utils/utils'

import 'vant/lib/index.css'
import '@/assets/css/base.css'

Vue.use(Vant)
Vue.use(VanImage)
Vue.use(less)

Vue.config.productionTip = false

Vue.prototype.$post = post
Vue.prototype.$get = get

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
