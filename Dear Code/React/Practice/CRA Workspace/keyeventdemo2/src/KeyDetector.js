import React, { Component } from "react";
class KeyDetector extends Component {
  handleKey(e) {
    if (e.code === "Enter") {
      alert("You typed\n" + e.target.value);
    } else if (e.code === "Escape") {
      let resp = window.confirm("Are you sure to erase the text ?");
      if (resp) {
        e.target.value = "";
      }
    }
  }
  render() {
    return (
      <div>
        <h1>Type Your Message</h1>
        <input
          type="text"
          onKeyUp={this.handleKey}
          placeholder="Type a value"
        />
      </div>
    );
  }
}
export default KeyDetector;
