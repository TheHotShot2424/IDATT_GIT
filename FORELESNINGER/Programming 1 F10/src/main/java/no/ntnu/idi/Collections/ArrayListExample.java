package no.ntnu.idi.Collections;

import java.util.ArrayList;
import java.util.Scanner;

public class ArrayListExample {

    public static void main(String[] args) {
        new ArrayListExample().testArrayListWithPrimitives();
        new ArrayListExample().testArrayListWithObjects();
    }

    public void testArrayListWithPrimitives() {
        // ArrayList<int> arrayList = new ArrayList<int>(); // Does not compile
        // ArrayList<Integer> arrayList = new ArrayList<Integer>(); // Compiles
        ArrayList arrayListInt = new ArrayList();
        arrayListInt.add(1);
        arrayListInt.add(1);
        arrayListInt.add(2);
        arrayListInt.add(1);
        System.out.println(arrayListInt);
    }
    public void testArrayListWithObjects() {
        ArrayList<Student> arrayListObjects = new ArrayList<Student>();
        Utils.showMenu();
        String userChoice = Utils.getUserChoice();
        do {
            switch (userChoice) {
                case Utils.ADD_STUDENT:
                    Student newStudent = Utils.enterStudentInformation();
                    arrayListObjects.add(newStudent);
                    System.out.println(newStudent + " is added");
                    break;
                case Utils.REMOVE_STUDENT:
                    System.out.println("Enter student id");
                    String id = new Scanner(System.in).nextLine();
                    for(Student student: arrayListObjects){
                        if(student.getId().equals(id)){
                            arrayListObjects.remove(student);
                            System.out.println(student + " is removed");
                        }
                    }
                    break;
                case Utils.PRINT_ALL_STUDENTS:
                    System.out.println("List of students");
                    Utils.printStudentsList(arrayListObjects);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again!");
                    break;
            }

            Utils.showMenu();
            userChoice = Utils.getUserChoice();
        } while(userChoice != Utils.EXIT);
    }

}
