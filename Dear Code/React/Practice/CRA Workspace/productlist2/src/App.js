import "./App.css";
import ProductList from "./ProductList";

function App() {
  return (
    <div className="App">
      <ProductList items={{"Redmi Note 11 Pro":5, "Realme Narzo 5":2, "One Plus CE 2":3}} />
    </div>
  );
}

export default App;
