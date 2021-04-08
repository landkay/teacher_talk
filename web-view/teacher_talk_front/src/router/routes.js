
import Home from '@/views/Home'
import RecordList from '@/views/RecordList'

export default [
 {
   path: '/',
   name: 'Home',
   component: Home,
   meta: {
     title: '主页'
   }
 }, {
   path: '/record_list',
   name: 'RecordList',
   component: RecordList,
   meta: {
     title: '日历'
   }
 }
]