package no.ntnu.idi.Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Utils {

    public static final String ADD_STUDENT = "1";
    public static final String REMOVE_STUDENT = "2";
    public static final String SEARCH_STUDENT_BY_NAME = "3";
    public static final String SEARCH_STUDENT_BY_ID = "4";
    public static final String PRINT_ALL_STUDENTS = "5";
    public static final String EXIT = "6";


    public static void showMenu() {
        System.out.println("1. Add student");
        System.out.println("2. Remove student");
        System.out.println("3. Search student by name");
        System.out.println("4. Search student by id");
        System.out.println("5. Print all students");
        System.out.println("6. Exit");
    }

    public static String getUserChoice() {
        System.out.println("Type your choice?");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        return choice;
    }
    public static Student enterStudentInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Id");
        String id = scanner.nextLine();

        scanner = new Scanner(System.in);
        System.out.println("Name");
        String name = scanner.nextLine();

        scanner = new Scanner(System.in);
        System.out.println("Age");
        String age = scanner.nextLine();

        return new Student(id, name, Integer.valueOf(age));
    }

    public static void printStudentsList(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void printStudentsSet(Set<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public static void printStudentsMap(HashMap<String, Student> studentsMap) {
        for (Student student : studentsMap.values()) {
            System.out.println(student);
        }
    }

    public static void printStudent(Student student) {
        System.out.println(student);
    }


}
