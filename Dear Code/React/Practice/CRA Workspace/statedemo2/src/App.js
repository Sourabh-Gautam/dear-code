import React, { Component } from "react";
import ShoppingCart from "./ShoppingCart";
class App extends Component {
  render() {
    return (
      <div>
        <ShoppingCart items={["One Plus-Mobile","Fast Track-Watch"]}/>
      </div>
    );
  }
}
export default App;
