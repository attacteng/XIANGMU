import Vue from 'vue'
// import VueResource from 'vue-resource'
import axios from 'axios'
import router from './router/index'
import App from './App.vue'
import store from './store/index'
import '../static/js/animation.js'
import '../static/js/tween.js'
import '../static/css/normalize.css'
import '../static/css/public.css'
import '../static/css/font/iconfont.css'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'element-ui/lib/theme-chalk/display.css';
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'


// Vue.use(VueResource)
Vue.prototype.$axios = axios
Vue.use(ElementUI)
Vue.use(mavonEditor)

new Vue({
  router,
  store,
  render: h => h(App)
}).$mount('#app')

