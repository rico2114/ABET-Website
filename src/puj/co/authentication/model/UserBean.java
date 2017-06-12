package puj.co.authentication.model;

import puj.co.courses.model.CourseBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sebastían on 6/06/2017.
 * This class represents an user
 */
public class UserBean {

    /**
     * Represents the username
     */
    private String username;

    /**
     * Represents the password
     */
    private String password;

    /**
     * Represents the user {@link UserPrivilege privilege}
     */
    private UserPrivilege privilege;

    /**
     * Represents A CACHED VERSION OF all the courses taught by the user
     */
    private final ArrayList<CourseBean> courses;

    /**
     * Constructs an empty user bean
     */
    public UserBean() {
        this(null, null, null);
    }

    /**
     * Constructs the user bean based on the username and privilege
     * @param username  the username of the user
     * @param password  the password of the user
     * @param privilege the {@link UserPrivilege privilege} of the user
     */
    public UserBean(final String username, final String password, final UserPrivilege privilege) {
        this.username = username;
        this.privilege = privilege;
        this.password = password;
        this.courses = new ArrayList<>();
    }

    /**
     * Sets the username of the user
     * @param username  the username
     */
    public void setUsername(final String username) {
        this.username = username;
    }

    /**
     * Gets the username of the user
     * @return  the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the password of the user
     * @param password  the password
     */
    public void setPassword(final String password) {
        this.password = password;
    }

    /**
     * Gets the password of the user
     * @return  the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the user privilege
     * @param privilege  the {@link UserPrivilege privilege}
     */
    public void setPrivilege(final UserPrivilege privilege) {
        this.privilege = privilege;
    }

    /**
     * Gets the user {@link UserPrivilege privilege}
     * @return  the privilege of the user
     */
    public UserPrivilege getPrivilege() {
        return privilege;
    }

    /**
     * Adds the courses related to the user
     * @param _courses  the list of courses to add
     */
    public void addCourses(final List<CourseBean> _courses) {
        courses.addAll(_courses);
    }

    /**
     * Attempts to grab a course based on a name and identifier
     * @param name  the name of the course
     * @param identifier    the identifier
     * @return  the course if exists, null if fails to find a course
     */
    public CourseBean getCourse(final String name, final String identifier) {
        for (CourseBean course : courses) {
            if (course.getName().equals(name) && course.getIdentifier().equals(identifier)) {
                return course;
            }
        }
        return null;
    }

    /**
     * Gets the courses
     * @return  the courses list
     */
    public ArrayList<CourseBean> getCourses() {
        return courses;
    }
}
