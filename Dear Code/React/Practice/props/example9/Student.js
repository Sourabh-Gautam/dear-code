class Student extends React.Component {
  render() {
    let { city, pincode } = this.props.address;
    return (
      <div>
        <h3>Student Details!</h3>
        <p>Name:{this.props.name}</p>
        <p>Age:{this.props.age}</p>
        <p>Subjects:{this.props.subjects.join()}</p>
        <p>Marks:{this.props.marks.join()}</p>
        <p>Pass:{String(this.props.isPass)}</p>
        <p>City:{city}</p>
        <p>Pincode:{pincode}</p>
      </div>
    );
  }
}
