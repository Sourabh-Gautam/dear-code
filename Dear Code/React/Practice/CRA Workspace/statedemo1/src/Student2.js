import React, { Component } from "react";
class Student2 extends Component {
  constructor() {
    super();
    this.state = { name: "Rahul", roll: 102 };
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
export default Student2;
