import { combineReducers, createStore } from 'redux';

const goodReducer = (state = 0, action) => {
  if (action.type === 'GOOD') {
    return state + 1;
  }
  return state;
};

const badReducer = (state = 0, action) => {
  if (action.type === 'BAD') {
    return state + 1;
  }
  return state;
};

const reducer = combineReducers({
  good: goodReducer,
  bad: badReducer
});

const store = createStore(reducer);