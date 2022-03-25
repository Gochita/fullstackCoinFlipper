//reducers
import { combineReducers } from 'redux'


function view(state = {
    loading: false
}, action) {
    switch (action.type) {
        //TODO: refactorizar
        case "view-loading": {
            return {
                loading: true
            }
        }
        case "view-loaded": {
            return {
                loading: false
            }
        }
        default: return state
    }
}

function random(state = {
    result: {}
}, action) {
    switch (action.type) {
        case "random-result": {
            return { result: action.data }
        }
        default: return state
    }
}


const rootReducer = combineReducers({
    view, random
})

export default rootReducer