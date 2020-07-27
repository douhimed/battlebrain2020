import React from "react";
import { connect } from "react-redux";
import MyInput from "./../../utilities/ui/MyInput/index";
import Button from "./../../utilities/ui/Button/index";
import MyLink from "./../../utilities/ui/MyLink/index";

class AddTeam extends React.Component {
  constructor(props) {
    super(props);

    this.state = {
      name: "",
      members: 0,
      spaceId: 0,
      errors: {},
    };
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.errorsData) {
      this.setState({ errors: nextProps.errorsData });
    }
  }

  onInputChangeHandler = (event) => {
    this.setState({ [event.target.name]: event.target.value });
  };

  onSubmit = (event) => {
    event.preventDefault();
    const space = {
      totalPlaces: this.state.totalPlaces,
      rows: this.state.rows,
    };
    this.props.saveSpace(space, this.props.history);
  };

  render() {
    return (
      <div className="container">
        <div className="d-flex justify-content-between align-self-baseline">
          <h2>Add new Space</h2>
          <MyLink
            classes="btn btn-warning"
            to={`/admin`}
            label="Back To  spaces"
          />
        </div>
        <hr />
        <form onSubmit={this.onSubmit}>
          <MyInput
            label="Total places"
            type="text"
            placeholder="Total places"
            name="totalPlaces"
            classes
            value={this.state.totalPlaces}
            onChangeHandler={this.onInputChangeHandler}
          />
          <MyInput
            label="Number od rows"
            type="text"
            placeholder="Number of rows"
            name="rows"
            value={this.state.rows}
            onChangeHandler={this.onInputChangeHandler}
          />

          <Button classes="btn btn-info" label="Submit" />
        </form>
      </div>
    );
  }
}

const mapStateToProps = (state) => ({
  team: state.teamsData.team,
  errorsData: state.errorsData,
});

export default connect(mapStateToProps, { saveTeam })(AddTeam);
