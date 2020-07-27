import React from "react";

const Select = (props) => {
  console.log(props);
  const options = props.options.teams.map((option) => (
    <option key={option.id} value={option.id}>
      {option.name}
    </option>
  ));

  return (
    <div className="form-group row">
      <label className="col-sm-4 col-form-label">{props.label}</label>
      <div className="col-sm-8">
        <select
          className="form-control"
          name={props.name}
          value={props.value}
          onChange={(e) => props.onChangeHandler(e)}
        >
          <option>---------</option>
          {options}
        </select>
      </div>
    </div>
  );
};

export default Select;
