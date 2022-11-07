class App extends React.Component {
  render() {
    let myElement = <h1>React Rocks!!!</h1>;
    return myElement;
  }
}
let myDiv = document.querySelector("#root");
let root = ReactDOM.createRoot(myDiv);
root.render(<App />);
