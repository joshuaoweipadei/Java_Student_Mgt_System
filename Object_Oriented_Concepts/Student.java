package Object_Oriented_Concepts;

public class Student {
  private int studentId;
  private String name;
  private double grade;

  public Student(int studentId, String name, double grade) {
    this.studentId = studentId;
    this.name = name;
    this.grade = grade;
  }

  // Getters and Setters
  public int getStudentId() {
    return studentId;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setGrade(double grade) {
    this.grade = grade;
  }

  @Override
  public String toString() {
    return "Student ID: " + studentId + ", Name: " + name + ", Grade: " + grade;
  }
}