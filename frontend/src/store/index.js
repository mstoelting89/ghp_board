import { createStore } from 'vuex'
import auth from '@/store/auth/index'

export default createStore({
  modules: {
    auth
  }
})
