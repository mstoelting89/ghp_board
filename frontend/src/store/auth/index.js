import { state } from '@/store/auth/state';
import { actions } from '@/store/auth/actions';
import { getters } from '@/store/auth/getters'
import { mutations } from '@/store/auth/mutations';

const authModule = {
    state,
    actions,
    getters,
    mutations
}

export default authModule;