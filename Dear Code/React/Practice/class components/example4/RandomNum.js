function getNumber() {
  const myNums = [10, 5, 3, 1, 11, 6, 8, 21, 7];
  const num = myNums[Math.floor(Math.random() * myNums.length)];
  return num;
}
class RandomNum extends React.Component {
  render() {
    const num = getNumber();
    let msg = null;
    if (num == 6) {
      msg = (
        <p>
          <h3>Congratulations !You won</h3>
          <img src="../../images/congrats.gif" />
        </p>
      );
    } else {
      msg = <small>Sorry! Better luck next time</small>;
    }
    return (
      <div>
        <p>You got the number {num} </p>
        {msg}
      </div>
    );
  }
}
