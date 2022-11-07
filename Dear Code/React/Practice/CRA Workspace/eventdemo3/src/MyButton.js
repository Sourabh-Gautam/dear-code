import React, { Component } from "react";
class MyButton extends Component {
  constructor(props) {
    super(props);
    this.state = { num: 1 };
    this.genRandom = this.genRandom.bind(this);
  }
  genRandom(e) {
    let randNum = Math.floor(Math.random() * 10) + 1;
    this.setState({ num: randNum });
  }
  render() {
    return (
      <div>
        <h2>Current random num is:{this.state.num}</h2>
        {this.state.num === 6 ? (
          <h3>You win</h3>
        ) : (
          <button onClick={this.genRandom}>Generate New Random Number</button>
        )}
      </div>
    );
  }
}
export default MyButton;
