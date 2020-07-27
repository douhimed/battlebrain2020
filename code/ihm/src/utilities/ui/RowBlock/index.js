import React from "react";
import Seat from "./../../../components/Seat/index";

const RowBlock = (props) => {
  let rowUI = (
    <tr>
      {Object.values(props).map((seat) => (
        <Seat {...seat} key={seat.number} />
      ))}
    </tr>
  );

  return rowUI;
};

export default RowBlock;
