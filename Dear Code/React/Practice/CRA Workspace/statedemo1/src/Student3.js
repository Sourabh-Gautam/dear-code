import React, { Component } from "react";
class Student3 extends Component {
  constructor(props) {
    super(props);
    this.state = { name: this.props.name, roll: this.props.roll };
  }
  render() {
    return (
      <div>
        <h3>Name is :{this.state.name}</h3>
        <h3>Roll is:{this.state.roll}</h3>
      </div>
    );
  }
}
export default Student3;
