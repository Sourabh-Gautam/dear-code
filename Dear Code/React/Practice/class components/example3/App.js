class App extends React.Component {
  render() {
    return (
      <div>
        <Hello />
      </div>
    );
  }
}
let myDiv = document.querySelector("#root");
let root = ReactDOM.createRoot(myDiv);
root.render(<App />);
