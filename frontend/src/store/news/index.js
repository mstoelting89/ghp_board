import { state } from '@/store/news/state';
import { actions } from '@/store/news/actions';
import { getters } from '@/store/news/getters'
import { mutations } from '@/store/news/mutations';

const newsModule = {
    state,
    actions,
    getters,
    mutations
}

export default newsModule;