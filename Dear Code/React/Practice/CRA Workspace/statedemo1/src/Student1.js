import React, { Component } from "react";
class Student1 extends Component {
  state = { name: "Amit", roll: 101 };
  render() {
    return (
      <div>
        <h3>Name is :{this.state.name}</h3>
        <h3>Roll is:{this.state.roll}</h3>
      </div>
    );
  }
}
export default Student1;
