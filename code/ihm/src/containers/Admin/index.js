import React from "react";
import { getSpaces } from "./../../services/SpaceServices";
import MyLink from "./../../utilities/ui/MyLink/index";
import { connect } from "react-redux";
import Alert from "./../../utilities/ui/Alert/index";
import Spaces from "../../components/Spaces";

class Admin extends React.Component {
  componentDidMount() {
    this.props.getSpaces();
  }

  render() {
    const spaces = this.props.spacesData.spaces;

    return (
      <div className="container">
        <div className="d-flex justify-content-between align-self-baseline">
          <MyLink
            classes="btn btn-primary"
            to={"/addSpace"}
            label="New Space"
          />
        </div>
        <hr />
        <div className="row">
          {spaces.length > 0 ? (
            <Spaces spaces={spaces} />
          ) : (
            <Alert message="NOT SPACES ADDED YET" classes="info col col-12" />
          )}
        </div>
      </div>
    );
  }
}

const mapStateToProps = (state) => ({
  spacesData: state.spacesData,
});

export default connect(mapStateToProps, { getSpaces })(Admin);
