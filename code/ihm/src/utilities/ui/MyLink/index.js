import React from "react";
import { Link } from "react-router-dom";

const MyLink = (props) => {
  return (
    <Link {...props} className={props.classes} to={props.to} {...props}>
      {props.label}
    </Link>
  );
};

export default MyLink;
