import React, { Component } from "react";
class MyButton extends Component{
  constructor(props){
    super(props);
    this.handleClick=this.handleClick.bind(this);
  }
  handleClick(){
    console.log("Inside handleClick:")
    console.log(this);
    let today=new Date();
    alert("Current date and time :"+today);
  }
  render(){
    
    return(
        <button onClick={this.handleClick}>Click Me</button>
    );
  }
}
export default MyButton;