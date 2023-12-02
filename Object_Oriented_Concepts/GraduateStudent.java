package Object_Oriented_Concepts;

public class GraduateStudent extends Student {
  // Additional attributes and methods specific to graduate students

  public GraduateStudent(int studentId, String name, double grade) {
    super(studentId, name, grade);
    // Additional initialization for graduate students
  }

  public String getStudentType() {
    return "Graduate";
  }
}