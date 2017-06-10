package puj.co.courses;

import puj.co.authentication.model.UserBean;
import puj.co.courses.model.CourseBean;

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
     * This method checks if the user contains a desired course
     * @param user  the user
     * @param identifier    the identifier of the course
     * @param name  the name of the course
     * @return  true if the user contains the course
     */
    public static final boolean userContainsCourse(final UserBean user, final String identifier, final String name) {
        // todo: has to be changed later to a hash structure for a faster lookup rather than O(n)
        for (CourseBean course : user.getCourses()) {
            if (course.getIdentifier().equals(identifier) && course.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Grabs a {@link List list} of courses based on an user
     * @param user  the user
     * @return  the list of courses
     */
    public static final ArrayList<CourseBean> findCoursesForUser(final UserBean user) {
        // todo: do this through the javeriana website
        final ArrayList<CourseBean> temporal = new ArrayList<>();
        CourseBean courseBean1 = new CourseBean("idx0", "arqui_1");
        CourseBean courseBean2 = new CourseBean("idx1", "logic");
        CourseBean courseBean3 = new CourseBean("idx2", "objetos");
        temporal.add(courseBean1);
        temporal.add(courseBean2);
        temporal.add(courseBean3);
        return temporal;
    }
}
