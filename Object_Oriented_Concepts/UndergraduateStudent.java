package Object_Oriented_Concepts;

public class UndergraduateStudent extends Student {
  // Additional attributes and methods specific to undergraduate students

  public UndergraduateStudent(int studentId, String name, double grade) {
    super(studentId, name, grade);
    // Additional initialization for undergraduate students
  }

  public String getStudentType() {
    return "Undergraduate";
  }
}