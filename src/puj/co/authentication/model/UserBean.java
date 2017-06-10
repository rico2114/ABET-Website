package puj.co.authentication.model;

import puj.co.courses.model.CourseBean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
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
     * Represents the user {@link UserPrivilege privilege}
     */
    private UserPrivilege privilege;

    /**
     * Represents the password
     */
    private String password;

    /**
     * Represents all the courses taught by the user
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
     * @param privilege the {@link UserPrivilege privilege} of the user
     */
    public UserBean(final String username, final UserPrivilege privilege, final String password) {
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
        for (CourseBean c : _courses) {
            courses.add(c);
        }
    }

    /**
     * Gets the courses
     * @return  the courses list
     */
    public ArrayList<CourseBean> getCourses() {
        return courses;
    }
}
