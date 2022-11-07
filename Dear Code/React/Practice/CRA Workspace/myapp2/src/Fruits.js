import React, { Component } from "react";
import foods from "./food";
import { choice, remove } from "./helper";
class Fruits extends Component {
  render() {
    let fruit = choice(foods);
    let remainingFoods = remove(foods, fruit);
    return (
      <div>
        <p>Total fruits:{foods.length} </p>
        <p>They are:{foods.join()}</p>
        <p>Chosen Fruit Is:{fruit}</p>
        <p>Remaining Fruits Are:{remainingFoods.length}</p>
        <p>They are:{remainingFoods.join()}</p>
      </div>
    );
  }
}
export default Fruits;
