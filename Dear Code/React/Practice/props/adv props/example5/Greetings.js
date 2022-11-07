class Greetings extends React.Component {
  static defaultProps = { who: "Everyone", from: "TeamSCA" };
  render() {
    let myElement = (
      <h3>
        Good Morning {String(this.props.who)} from {String(this.props.from)}
      </h3>
    );
    return myElement;
  }
}
