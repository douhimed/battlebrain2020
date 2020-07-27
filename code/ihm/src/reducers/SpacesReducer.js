import { GET_SPACES, GET_SPACE } from "../services/Types";

const initialState = {
  spaces: [],
  space: {},
};

export default function (state = initialState, action) {
  switch (action.type) {
    case GET_SPACES:
      return {
        ...state,
        spaces: action.payload,
      };
    case GET_SPACE:
      return {
        ...state,
        space: action.payload,
      };
    default:
      return state;
  }
}
