class App extends React.Component {
  render() {
    return (
      <div>
        <h3>Course Details!!</h3>
        <Course name="Java" titles={["Java SE", "Jakarta EE", "Android"]} />
        <Course
          name="Full Stack Development"
          titles={["HTML", "CSS", "JS", "React", "Node"]}
        />
      </div>
    );
  }
}
let myDiv = document.querySelector("#root");
let root = ReactDOM.createRoot(myDiv);
root.render(<App />);
