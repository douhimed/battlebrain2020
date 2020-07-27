import React from "react";

const Seat = ({ number, eligible, recommanded, reserved, user }) => {
  let isEligible = eligible ? (
    <span className={"badge badge-success mr-2"}>Eligible</span>
  ) : (
    <span className={"badge badge-danger"}>NOT Eligible</span>
  );

  return (
    <td>
      <div className="card text-center mb-2">
        <span className={"badge badge-secondary"}>Number : {number}</span>
        <div className="card-body">
          {isEligible}
          {eligible && recommanded && (
            <span className={"badge badge-primary"}>Recommanded</span>
          )}
          {eligible && reserved && (
            <>
              <span className={"badge badge-warning"}>Reserved</span>
              <br />
              <span className={"badge badge-secondary mr-2"}>
                Team : {user.team.name}
              </span>
              {user.name && (
                <span className={"badge badge-secondary"}>
                  Name : {user.name}
                </span>
              )}
            </>
          )}
        </div>
      </div>
    </td>
  );
};

export default Seat;
