import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import Header from "./components/Header/index";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Admin from "./containers/Admin/index";
import { Provider } from "react-redux";
import store from "./store/index";
import Seats from "./containers/Seats/index";
import AddSpace from "./components/AddSpace/index";

class App extends React.Component {
  render() {
    return (
      <>
        <Provider store={store}>
          <Router>
            <Header />
            <Switch>
              <Route exact path="/seats/:id" component={Seats} />
              <Route exact path="/addSpace" component={AddSpace} />
              <Route exact path="/admin" component={Admin} />
              <Route exact path="/" component={Admin} />
            </Switch>
          </Router>
        </Provider>
      </>
    );
  }
}

export default App;
