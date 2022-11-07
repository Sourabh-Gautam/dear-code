import React, { Component } from "react";
import Product from "./Product";
import AddProduct from "./AddProduct";
import "./ProductList.css";

export default class ProductList extends Component {
  constructor(props) {
    super(props);
    this.state = { items: this.props.items };
    this.deleteItem = this.deleteItem.bind(this);
    this.addItem = this.addItem.bind(this);
  }
  deleteItem(itemName, e) {
    let obj={};
    for(let x of  Object.keys(this.state.items)){
      if(x===itemName){
        continue;
      }
      obj[x] = this.state.items[x];
    }

    this.setState({ items: obj });
  }

  addItem(item, e){
    if(this.state.items[item[0]]===undefined){
      this.setState({items : {...this.state.items, ...{[item[0]]:item[1]}}})
    }
    else{
      let qty = Number(item[1])+Number(this.state.items[item[0]]);
      this.setState({items : {...this.state.items, ...{[item[0]]:qty}}})
    }
  }

  render() {
    Object.keys(this.state.items).map((x) => console.log(x));
    let list = Object.keys(this.state.items).map((x) => (
      <Product item={[x, this.state.items[x]]} remove={this.deleteItem} />
    ));
    return (
      <div className="ProductList">
        <div>
          <h1>Available Products</h1>
          <hr />
          <div>
            <ul>{list}</ul>
          </div>
        </div>

        <div>
          <h1>Add New Product</h1>
          <hr />
          <AddProduct add={this.addItem}/>
        </div>
      </div>
    );
  }
}
