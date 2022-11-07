import React, { Component } from "react";
class Clock extends Component {
  constructor(props){
    super(props);
    this.state={currDate:new Date()};
    setInterval(this.updateClock,1000);

  }
  updateClock=()=>{
      this.setState({currDate:new Date()});
  }
  render(){
    return(
      <div>
        <h2>Hello Everyone!</h2>
        <h3>Current date and time:{this.state.currDate.toLocaleString()}</h3>
      </div>
    )
  }
}
export default Clock;
