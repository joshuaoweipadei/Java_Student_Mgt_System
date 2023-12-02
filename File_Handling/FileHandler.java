package File_Handling;

import Object_Oriented_Concepts.Student;

import java.io.*;

public class FileHandler {
  private static final String FILE_PATH = "students.txt";

  public static void writeToFile(Student student, String studentType) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH, true))) {
      writer.println(student.toString() + ", " + "Student Type: " + studentType);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void readFromFile() {
    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
      String line;
      while ((line = reader.readLine()) != null) {
        System.out.println(line);
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
