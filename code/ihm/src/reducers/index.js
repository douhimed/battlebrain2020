import { combineReducers } from "redux";
import errorReducer from "./ErrorReducer";
import spacesReducer from "./SpacesReducer";
import TeamsReducer from "./TeamsReducer";

export default combineReducers({
  errorsData: errorReducer,
  teamsData: TeamsReducer,
  spacesData: spacesReducer,
});
