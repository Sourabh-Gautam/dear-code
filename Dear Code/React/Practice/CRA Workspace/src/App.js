import React, { Component } from "react";
import ProductList from "./ProductList";
class App extends Component {
  render() {
    return (
      <div style={{ textAlign: "center" }}>
        <ProductList
          items={[
            "JBL EarPhones",
            "PoleStar BackPack",
            "One Plus Nord 2",
            "Apple I-Phone 13",
            "Canon DSLR",
            "Dettol N-95 Mask",
          ]}
        />
      </div>
    );
  }
}
export default App;
