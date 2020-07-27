import axios from "axios";
import {
  GET_ERRORS,
  GET_SPACES,
  GET_SPACE,
  GET_REC_SEATS,
  CLEAN_SPACES,
} from "./Types";

const uri = "http://localhost:8080";

export const getSpaces = () => async (dispatch) => {
  const res = await axios.get(uri + "/space");
  dispatch({
    type: GET_SPACES,
    payload: res.data,
  });
};

export const getRecommandedSeats = (data) => async (dispatch) => {
  try {
    const res = await axios.get(
      uri + "/seat/recommandation/" + data.spaceId + "/" + data.teamId
    );
    dispatch({
      type: GET_SPACE,
      payload: res.data,
    });
  } catch (error) {
    dispatch({
      type: CLEAN_SPACES,
    });
  }
};

export const getSpace = (id) => async (dispatch) => {
  const res = await axios.get(uri + "/space/" + id);
  dispatch({
    type: GET_SPACE,
    payload: res.data,
  });
};

export const saveSpace = (space, history) => async (dispatch) => {
  try {
    await axios.post(uri + "/space", space);
    history.push(`/admin`);
    dispatch({
      type: GET_ERRORS,
      payload: {},
    });
  } catch (error) {
    dispatch({
      type: GET_ERRORS,
      payload: error,
    });
  }
};
