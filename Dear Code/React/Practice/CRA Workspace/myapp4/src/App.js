import React, { Component } from "react";
import MySelf from "./MySelf";
import "./App.css";
class App extends Component {
  render() {
    return (
      <div>
        <MySelf />
        <h2>This is outside MySelf</h2>
      </div>
    );
  }
}
export default App;
