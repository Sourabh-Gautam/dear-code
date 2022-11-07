import React, { Component } from "react";
class ShoppingCart extends Component {
    constructor(props){
        super(props);
        this.state={items:this.props.items,total:this.props.items.length};
        setTimeout(this.updateCart,5000);    
    }
    updateCart=()=>{
            
        let newItems=[...this.state.items,"Dell Inspiron-Laptop"]
        let newTotal=this.state.total+1;
        this.setState({items:newItems,total:newTotal});
    }
    render(){
        return(
            <div>
                <h2>Your Cart Details</h2>
                <h3>Product Details:{this.state.items.join()}</h3>
                <h3>Product Counting:{this.state.total}</h3>
            </div>
        )
    }
}
export default ShoppingCart;
