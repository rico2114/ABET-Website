package puj.co.courses;

import puj.co.authentication.model.UserBean;
import puj.co.authentication.model.UserPrivilege;
import puj.co.courses.model.CourseBean;
import puj.co.courses.model.Student;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Created by Sebastían on 7/06/2017.
 */
public class CoursesUtils {

    /**
     * This class doesn't needs to be instantiated
     */
    private CoursesUtils() {
    }

    /**
     * Grabs the {@link Student students} based on a course
     * @param name    the course name
     * @param identifier    the course identifier
     * @return  an {@link ArrayList array-list} with the students
     */
    public static final ArrayList<Student> findStudentsForCourse(final String name, final String identifier) {
        // todo: do this through the javeriana website
        final ArrayList<Student> temporal = new ArrayList<>();
        if (identifier.equals("idx0")) {
            temporal.add(new Student("Juan Sebastian Quiceno"));
        } else if (identifier.equals("idx1")) {
            temporal.add(new Student("Daniel Mamian"));
        } else {
            temporal.add(new Student("Daniel Murcia"));
        }
        return temporal;
    }

    /**
     * Grabs a {@link List list} of courses based on an user
     * @param username  the user name
     * @return  the list of courses
     */
    public static final ArrayList<CourseBean> findCoursesForUser(final String username, final UserPrivilege privilege) {
        // todo: do this through the javeriana website
        final ArrayList<CourseBean> temporal = new ArrayList<>();
        if (privilege.equals(UserPrivilege.ADMINISTRATOR) || privilege.equals(UserPrivilege.MODERATOR)) {
            temporal.add(new CourseBean("idx3", "El resto de cursos", "A"));
        }

        temporal.add(new CourseBean("idx0", "Arquitectura 1", "A"));
        temporal.add(new CourseBean("idx1", "Logica", "A"));
        temporal.add(new CourseBean("idx2", "Objetos", "B"));
        return temporal;
    }
}
