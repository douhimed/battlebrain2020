import axios from "axios";
import { GET_ERRORS, GET_TEAMS } from "./Types";

const uri = "http://localhost:8080/team";

export const getTeams = () => async (dispatch) => {
  const res = await axios.get(uri);
  dispatch({
    type: GET_TEAMS,
    payload: res.data,
  });
};
