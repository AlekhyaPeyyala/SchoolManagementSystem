package main;

import java.util.*;

import dao.ClassDAO;
import dao.StudentClassDAO;
import dao.StudentDAO;
import dao.TeacherDAO;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO studentDAO = new StudentDAO();
        TeacherDAO teacherDAO = new TeacherDAO();
        ClassDAO classDAO = new ClassDAO();
        StudentClassDAO scDAO = new StudentClassDAO();

        while (true) {
            System.out.println("\n===== School Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Teacher");
            System.out.println("4. View Teachers");
            System.out.println("5. Add Class");
            System.out.println("6. View Classes");
            System.out.println("7. Assign Student to Class");
            System.out.println("8. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Name: ");
                    String sname = sc.next();
                    System.out.print("Age: ");
                    int age = sc.nextInt();
                    System.out.print("Grade: ");
                    String grade = sc.next();
                    studentDAO.addStudent(sname, age, grade);
                    break;

                case 2:
                    studentDAO.viewStudents();
                    break;
                case 3:
                    System.out.print("Teacher Name: ");
                    String tname = sc.next();
                    System.out.print("Subject: ");
                    String subject = sc.next();
                    teacherDAO.addTeacher(tname, subject);
                    break;

                case 4:
                    teacherDAO.viewTeachers();
                    break;

                case 5:
                    System.out.print("Class Name: ");
                    String cname = sc.next();
                    System.out.print("Teacher ID: ");
                    int tid = sc.nextInt();
                    classDAO.addClass(cname, tid);
                    break;

                case 6:
                    classDAO.viewClasses();
                    break;

                case 7:
                    System.out.print("Student ID: ");
                    int sid = sc.nextInt();
                    System.out.print("Class ID: ");
                    int cid = sc.nextInt();
                    scDAO.assignStudent(sid, cid);
                    break;
                    
                case 8:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
