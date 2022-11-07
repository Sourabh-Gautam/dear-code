import React, { Component } from "react";
import Product from "./Product";
import "./ProductList.css";

export default class ProductList extends Component {
  constructor(props) {
    super(props);
    this.state = { items: this.props.items };
    this.deleteItem = this.deleteItem.bind(this);
  } 
  deleteItem(itemName, e) {
    let arr = this.state.items.filter((x) => x !== itemName);

    this.setState({ items: arr });
  }
  render() {
    let list = this.state.items.map((x) => (
      <Product item={x} remove={this.deleteItem} />
    ));
    return (
      <div className="ProductList">
        <h1>Available Products</h1>
        <hr />
        <div>
          <ul>{list}</ul>
        </div>
      </div>
    );
  }
}
