import Vue from 'vue'
import VueRouter from 'vue-router'

import routes from '@/router/routes'

Vue.use(VueRouter)

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach(function(to, from, next) {

  document.title = to.meta.title;
  next();
})

router.afterEach(function(to, from) {

})

export default router
