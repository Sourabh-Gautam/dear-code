class Greetings extends React.Component {
  render() {
    let myElement = (
      <h3>
        Good Morning {this.props.who} from {this.props.from}
      </h3>
    );
    return myElement;
  }
}
