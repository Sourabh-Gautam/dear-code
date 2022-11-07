class Course extends React.Component {
  render() {
    let { name, titles } = this.props;
    let subjects = titles.map((subj) => <li>{subj}</li>);

    return (
      <div>
        <p>Course Name:{name}</p>
        <p>
          Titles:<ul>{subjects}</ul>
        </p>
      </div>
    );
  }
}
