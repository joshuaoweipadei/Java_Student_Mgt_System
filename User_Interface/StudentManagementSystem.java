package User_Interface;

import File_Handling.FileHandler;
import Object_Oriented_Concepts.Student;
import Object_Oriented_Concepts.GraduateStudent;
import Object_Oriented_Concepts.UndergraduateStudent;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class StudentManagementSystem {
  private static final String FILE_PATH = "students.txt";
  private static final ArrayList<Student> students = new ArrayList<>();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
      
    while (true) {
      System.out.println("\nStudent Management System Menu:");
      System.out.println("1. Add new student");
      System.out.println("2. View student details");
      System.out.println("3. Update Student Grade");
      System.out.println("4. Exit");

      System.out.print("Enter your choice: ");
      int choice = scanner.nextInt();

      switch (choice) {
        case 1:
          addStudent();
          break;
        case 2:
          viewStudentDetails();
          break;
        case 3:
          updateGrade();
          break;
        case 4:
          System.out.println("Exiting the system. Goodbye!");
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  private static void addStudent() {
    Scanner scanner = new Scanner(System.in);

    // Enter student ID
    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();

    // Enter student Name
    System.out.print("Enter student name: ");
    String name = scanner.next();

    // Enter student grade
    double grade = 0.0;
    boolean validGrade = false;

    while (!validGrade) {
      try {
        System.out.print("Enter student grade: ");
        grade = scanner.nextDouble();
        validGrade = true; // Set to true if no exception is thrown
      } catch (java.util.InputMismatchException e) {
        System.out.println("Invalid input for grade. Please enter a valid number.");
        scanner.next(); // Consume the invalid input to avoid an infinite loop
      }
    }

    // Enter student type
    System.out.println("Select student type:");
    System.out.println("1. Undergraduate Student");
    System.out.println("2. Graduate Student");
    System.out.print("Enter your choice: ");
    int studentType = scanner.nextInt();

    if (studentType == 1) {
      UndergraduateStudent undergraduateStudent = new UndergraduateStudent(studentId, name, grade);
      FileHandler.writeToFile(undergraduateStudent, undergraduateStudent.getStudentType());
    } else if (studentType == 2) {
      GraduateStudent graduateStudent = new GraduateStudent(studentId, name, grade);
      FileHandler.writeToFile(graduateStudent, graduateStudent.getStudentType());
    } else {
      System.out.println("Invalid student type. Student not added.");
      return;
    }

    System.out.println("Student added successfully!");
  }

  private static void viewStudentDetails() {
    System.out.println("Student Details:");
    FileHandler.readFromFile();
  }

  private static void updateGrade() {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter student ID: ");
    int studentId = scanner.nextInt();

    Student foundStudent = null;
    
    for (Student student : students) {
      System.out.println(student);
      if (student.getStudentId() == studentId) {
        foundStudent = student;
        break;
      }
    }

    // if student with this id does not exist
    if (foundStudent == null) {
      System.out.println("Student with ID " + studentId + " does not exist.");
      return;
    }

    System.out.println("Select attribute to update:");
    System.out.println("1. Name");
    System.out.println("2. Grade");
    System.out.print("Enter your choice: ");
    int updateChoice = scanner.nextInt();

    switch (updateChoice) {
      case 1:
        updateStudentName(foundStudent);
        break;
      case 2:
        updateStudentGrade(foundStudent);
        break;
      default:
        System.out.println("Invalid choice. No updates performed.");
    }
  }

  private static void updateStudentName(Student foundStudent) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter student name: ");
    String name = scanner.nextLine();

    foundStudent.setName(name);
    System.out.println("Student Name updated successfully!");
  }

  private static void updateStudentGrade(Student foundStudent) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter new grade: ");
    double newGrade = scanner.nextDouble();

    foundStudent.setGrade(newGrade);
    System.out.println("Student Grade updated successfully!");
  }
}

