package puj.co.courses.model;

import java.util.ArrayList;

/**
 * Created by Sebastían on 7/06/2017.
 * An immutable representation of a course
 */
public class CourseBean {

    /**
     * Represents the course identifier
     */
    private final String identifier;

    /**
     * Represents the course name
     */
    private final String name;

    /**
     * Represents the group of the course (is it group A or B or ...)
     */
    private final String group;

    /**
     * Represents A CACHED VERSION OF the list of students
     */
    private final ArrayList<Student> students;

    /**
     * Constructs a course based on an identifier and name
     * @param identifier    the identifier of the course
     * @param name  the name of the course
     * @param group the group of the course
     */
    public CourseBean(final String identifier, final String name, final String group) {
        this.identifier = identifier;
        this.name = name;
        this.group = group;
        this.students = new ArrayList<>();
    }

    /**
     * Gets the identifier of the course
     * @return  the identifier
     */
    public String getIdentifier() {
        return identifier;
    }

    /**
     * Gets the name of the course
     * @return  the name of the course
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the group of the course
     * @return  the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * Caches the students to the local course
     * @param _students the students to be added
     */
    public void addStudents(final ArrayList<Student> _students) {
        students.addAll(_students);
    }

    /**
     * Gets the students from the {@link CourseBean course}
     * @return  the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

}
