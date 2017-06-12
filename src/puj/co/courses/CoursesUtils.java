package puj.co.courses;

import puj.co.authentication.model.UserBean;
import puj.co.courses.model.CourseBean;
import puj.co.courses.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by Sebastían on 7/06/2017.
 */
public class CoursesUtils {

    /**
     * This class dosn't needs to be instantiated
     */
    private CoursesUtils() {
    }

    /**
     * Grabs the {@link Student students} based on a course
     * @param name    the course name
     * @param identifier    the course identifier
     * @return  an {@link ArrayList arraylist} with the students
     */
    public static final ArrayList<Student> findStudentsForCourse(final String name, final String identifier) {
        // todo: do this through the javeriana website
        final ArrayList<Student> temporal = new ArrayList<>();
        temporal.add(new Student("Juan Sebastian Quiceno"));
        temporal.add(new Student("Daniel Mamian"));
        temporal.add(new Student("Deniel Murcia"));
        return temporal;
    }

    /**
     * Grabs a {@link List list} of courses based on an user
     * @param username  the user name
     * @return  the list of courses
     */
    public static final ArrayList<CourseBean> findCoursesForUser(final String username) {
        // todo: do this through the javeriana website
        final ArrayList<CourseBean> temporal = new ArrayList<>();
        temporal.add(new CourseBean("idx0", "Arquitectura 1"));
        temporal.add(new CourseBean("idx1", "Logica"));
        temporal.add(new CourseBean("idx2", "Objetos"));
        return temporal;
    }
}
