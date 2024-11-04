package no.ntnu.idi.Collections;

import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by Surya on 18.03.2016.
 */
public class HashSetExample {

    public static void main(String[] args) {
        new HashSetExample().testHashSetWithPrimitives();
        new HashSetExample().testHashSetObjects();
    }

    /**
     * This method illustrates that HashSet does not allow duplicates
     */
    public void testHashSetWithPrimitives() {
        //HashSet<int> hashSetInt = new HashSet<int>(); // Does not compile
        //HashSet<Integer> hashSetInt = new HashSet<Integer>(); // Compiles
        HashSet hashSetInt = new HashSet();
        hashSetInt.add(1);
        hashSetInt.add(1);
        hashSetInt.add(2);
        hashSetInt.add(1);
        System.out.println(hashSetInt); // compare output with ArrayListExample
    }
    public void testHashSetObjects() {
        HashSet<Student> setOfObjects = new HashSet<Student>();
        Utils.showMenu();
        String userChoice = Utils.getUserChoice();
        do {
            switch (userChoice) {
                case Utils.ADD_STUDENT:
                    Student newStudent = Utils.enterStudentInformation();
                    setOfObjects.add(newStudent);
                    System.out.println(newStudent + " is added");
                    break;
                case Utils.REMOVE_STUDENT:
                    System.out.println("Enter student id");
                    String id = new Scanner(System.in).nextLine();
                    for(Student student: setOfObjects){
                        if(student.getId().equals(id)){
                            setOfObjects.remove(student);
                            System.out.println(student + " is removed");
                        }
                    }
                    break;
                case Utils.PRINT_ALL_STUDENTS:
                    System.out.println("List of students");
                    Utils.printStudentsSet(setOfObjects);
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
