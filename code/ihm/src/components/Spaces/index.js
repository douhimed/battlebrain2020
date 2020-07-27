import React from "react";
import MyLink from "./../../utilities/ui/MyLink/index";

const Spaces = (props) => {
  let spacesUI = props.spaces.map((space) => (
    <tr key={space.id}>
      <td>{space.id}</td>
      <td>{space.totalPlaces}</td>
      <td>{space.elibibleSeatsNumber}</td>
      <td>{space.rows}</td>
      <td>
        <MyLink label="View Seats" to={"/seats/" + space.id} />
      </td>
    </tr>
  ));

  return (
    <div className="row table-striped">
      <table className="table">
        <thead>
          <tr className="table-primary">
            <th>ID</th>
            <th>Total seats</th>
            <th>Eligible seats</th>
            <th>Number of rows</th>
            <th></th>
          </tr>
        </thead>
        <tbody>{spacesUI}</tbody>
      </table>
    </div>
  );
};

export default Spaces;
