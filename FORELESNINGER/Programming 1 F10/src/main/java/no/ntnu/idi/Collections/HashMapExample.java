package no.ntnu.idi.Collections;

import java.util.HashMap;
import java.util.Scanner;

public class HashMapExample {

    public static void main(String[] args) {
        new HashMapExample().testHashMapWithPrimitives();
        new HashMapExample().testHashMapObjects();
    }

    public void testHashMapWithPrimitives() {
        //HashMap<int> hashMapInt = new HashMap<int>(); // Does not compile. Need key -> value pair
        //HashMap<int, int> hashMapInt = new HashMap<int, int>(); // Does not compile
        HashMap<Integer, String> hashMapInt = new HashMap<Integer, String>(); // Compiles
        hashMapInt.put(1, "One");
        hashMapInt.put(1, "One");
        hashMapInt.put(2, "Two");
        hashMapInt.put(1, "One");
        hashMapInt.put(3, "One");
        System.out.println(hashMapInt);
        // compare output with ArrayListExample and HashSetExample
        // keys should be unique but values can be duplicate
    }
    public void testHashMapObjects() {
        HashMap<String, Student> mapOfObjects = new HashMap<>();
        Utils.showMenu();
        String userChoice = Utils.getUserChoice();
        do {
            switch (userChoice) {
                case Utils.ADD_STUDENT:
                    Student newStudent = Utils.enterStudentInformation();
                    mapOfObjects.put(newStudent.getId(), newStudent);
                    System.out.println(newStudent + " is added");
                    break;
                case Utils.REMOVE_STUDENT:
                    System.out.println("Enter student id");
                    String id = new Scanner(System.in).nextLine();
                    // note that we are iterating over values
                    for(Student student: mapOfObjects.values()){
                        if(student.getId().equals(id)){
                            mapOfObjects.remove(student.getId()); // note that we are removing by key
                            System.out.println(student + " is removed");
                        }
                    }
                    break;
                case Utils.PRINT_ALL_STUDENTS:
                    System.out.println("List of students");
                    Utils.printStudentsMap(mapOfObjects);
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
