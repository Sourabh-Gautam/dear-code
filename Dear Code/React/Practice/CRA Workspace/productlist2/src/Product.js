import React, { Component } from "react";
import "./Product.css";
export default class Product extends Component {
  constructor(props) {
    super(props);
    this.handleClick = this.handleClick.bind(this);
  }
  handleClick(e) {
    this.props.remove(this.props.item[0], e);
  }
  render() {
    return (
      <li className="Product">
        <div>
          {this.props.item[0]}
          <span>{this.props.item[1]}</span>
        </div>
        <button onClick={this.handleClick}>Delete</button>
      </li>
    );
  }
}
