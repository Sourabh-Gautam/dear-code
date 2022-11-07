class App extends React.Component {
  render() {
    return (
      <div>
        <RandomNum />
        <Hello />
      </div>
    );
  }
}
let mydiv = document.querySelector("#root");
let root = ReactDOM.createRoot(mydiv);
root.render(<App />);
