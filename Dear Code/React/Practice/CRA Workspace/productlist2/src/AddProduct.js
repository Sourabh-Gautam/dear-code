import React, { Component } from "react";
import "./AddProduct.css";

export default class AddProduct extends Component {
    constructor(props){
        super(props);
        this.state = {pname:"", quantity:""};
        this.handleAdd = this.handleAdd.bind(this);
        this.handleChange = this.handleChange.bind(this);
    }

    handleAdd(e){
        this.props.add([this.state.pname, this.state.quantity], e);
    }

    handleChange(e){
        this.setState({[e.target.name]:e.target.value});
    }

  render() {
    return (
      <div className="AddProduct">
        <h3>Item Name</h3>
        <input type="text" name="pname" placeholder="Enter product name" value={this.state.pname} onChange={this.handleChange}/>
        <h3>Quantity</h3>
        <input type="text" placeholder="Enter quantity" name="quantity" value={this.state.quantity} onChange={this.handleChange}/>
        <br />
        <button onClick={this.handleAdd}>Add To Cart</button>
      </div>
    );
  }
}
