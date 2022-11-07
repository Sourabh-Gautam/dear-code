class App extends React.Component {
  render() {
    return (
      <div>
        <Greetings who="Sachin" from="Paramjeet" />
        <Greetings who="Sachin" />
        <Greetings from="Paramjeet" />
        <Greetings />
      </div>
    );
  }
}
let myDiv = document.querySelector("#root");
let root = ReactDOM.createRoot(myDiv);
root.render(<App />);
