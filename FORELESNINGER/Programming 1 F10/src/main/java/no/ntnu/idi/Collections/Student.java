package no.ntnu.idi.Collections;

public class Student {
    String id;
    String name;
    int age;

    /**
     * Constructor for a Student
     * @param id of the student
     * @param name of the student
     * @param age of the student
     */
    public Student(String id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.age;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student){
            if(this.id.equals(((Student) obj).id)
                    && this.name.equals(((Student) obj).name)
                    && this.age == ((Student) obj).age
            ) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(this.id);
    }

}
