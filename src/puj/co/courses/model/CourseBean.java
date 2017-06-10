package puj.co.courses.model;

/**
 * Created by Sebastían on 7/06/2017.
 * An immutable representation of a course
 */
public class CourseBean {

    /**
     * Represents the course identifier
     */
    public final String identifier;

    /**
     * Represents the course name
     */
    public final String name;

    /**
     * Constructs a course based on an identifier and name
     * @param identifier    the identifier of the course
     * @param name  the name of the course
     */
    public CourseBean(final String identifier, final String name) {
        this.identifier = identifier;
        this.name = name;
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

}
