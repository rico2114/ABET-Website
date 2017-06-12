package puj.co.courses.model;

/**
 * Created by Sebastían on 12/06/2017.
 */
public class Student {

    /**
     * Represents the name of the student
     */
    private final String name;

    /**
     * Constructs a student based on the name
     * @param name  the name of the student
     */
    public Student(final String name) {
        this.name = name;
    }

    /**
     * Gets the name of the student
     * @return  the name
     */
    public String getName() {
        return name;
    }

    /**
     * Grabs the student hash
     * @return  the student hash
     */
    public int getStudentHash() {
        return name.hashCode();
    }
}
