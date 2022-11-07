class App extends React.Component {
  render() {
    return (
      <div>
        <Student
          name="Ravi"
          age={15}
          subjects={["phy", "chem", "maths"]}
          marks={[60, 70, 80]}
        />
      </div>
    );
  }
}
let myDiv = document.querySelector("#root");
let root = ReactDOM.createRoot(myDiv);
root.render(<App />);
