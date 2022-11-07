import React, { Component } from "react";
import sachin from "./sachin.jpg";
import "./MySelf.css";
class MySelf extends Component {
  render() {
    return (
      <div className="MySelf">
        <h2>This is me!</h2>
        <img src={sachin} />
      </div>
    );
  }
}
export default MySelf;
