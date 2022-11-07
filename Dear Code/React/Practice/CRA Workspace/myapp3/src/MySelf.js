import React, { Component } from "react";
import sachin from "./sachin.jpg";
class MySelf extends Component {
  render() {
    console.log(typeof sachin);
    console.log(sachin);
    return (
      <div>
        <h2>This is me!</h2>
        <img src={sachin} />
      </div>
    );
  }
}
export default MySelf;
