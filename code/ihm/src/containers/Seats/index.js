import React from "react";
import { getSpace, getRecommandedSeats } from "../../services/SpaceServices";
import { connect } from "react-redux";
import RowBlock from "../../utilities/ui/RowBlock";
import { getTeams } from "./../../services/TeamsServices";
import Select from "./../../utilities/ui/Select/index";
import Alert from "./../../utilities/ui/Alert/index";

class Seats extends React.Component {
  constructor(props) {
    super(props);
  }

  componentDidMount() {
    const { id } = this.props.match.params;
    this.setState({ spaceId: id });
    this.props.getSpace(id);
    this.props.getTeams();
  }

  onInputChangeHandler = (event) => {
    this.props.getRecommandedSeats({
      spaceId: this.state.spaceId,
      teamId: event.target.value,
    });
  };

  render() {
    const { space } = this.props;
    let seatsUI = (
      <Alert message="NOT SPACES ADDED YET" classes="info col col-12" />
    );
    if (space.seats) {
      const rows = Object.values(space.seats);
      seatsUI = (
        <table>
          <tbody>
            {rows.map((row, index) => (
              <RowBlock key={index} {...row} />
            ))}
          </tbody>
        </table>
      );
    }

    return (
      <div className="container">
        <div className="d-flex justify-content-between align-self-baseline">
          <Select
            label="Teams"
            name="teamName"
            options={this.props.teamsData}
            onChangeHandler={this.onInputChangeHandler}
          />
        </div>
        <hr />
        <div>{seatsUI}</div>
      </div>
    );
  }

  createRows() {}
}

const mapStateToProps = (state) => ({
  space: state.spacesData.space,
  teamsData: state.teamsData,
});

export default connect(mapStateToProps, {
  getSpace,
  getTeams,
  getRecommandedSeats,
})(Seats);
