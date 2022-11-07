class Course extends React.Component {
  render() {
    let { name, titles } = this.props;
    let subjects = [];
    titles.forEach((subj) => {
      subjects.push(<li>{subj}</li>);
    });
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
