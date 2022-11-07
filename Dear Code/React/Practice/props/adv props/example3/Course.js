class Course extends React.Component {
  render() {
    let { name, titles } = this.props;

    return (
      <div>
        <p>Course Name:{name}</p>
        <p>
          Titles:
          <ul>
            {titles.map((subj) => (
              <li>{subj}</li>
            ))}
          </ul>
        </p>
      </div>
    );
  }
}
