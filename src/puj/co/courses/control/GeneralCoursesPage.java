package puj.co.courses.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import puj.co.authentication.control.AuthenticationPage;
import puj.co.authentication.model.UserBean;
import puj.co.courses.CoursesUtils;
import puj.co.courses.model.CourseBean;
import puj.co.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

/**
 * Created by Sebastían on 7/06/2017.
 * Represents the page for all the courses based on an authentication user
 */
@Controller
@RequestMapping("/courses")
public class GeneralCoursesPage {

    /**
     * Represents the courses view name
     */
    public static final String COURSES_VIEW_NAME = "courses";

    /**
     * Represents the jsp username key
     */
    public static final String JSP_USERNAME_KEY = "displayUsername";

    /**
     * Represents the jsp courses list key
     */
    public static final String JSP_COURSES_KEY = "courses";

    /**
     * This function takes care of the loading of the courses page
     * @param request   the request to dispatch the message
     * @return the {@link ModelAndView view} of the courses page
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loadCoursesPage(HttpServletRequest request) {
        // Requires authentication
        final ModelAndView authenticationRequired = Utils.validateAuthentication(request);
        if (Objects.nonNull(authenticationRequired)) {
            return authenticationRequired;
        }

        // Get the active user
        final UserBean activeUser = Utils.getAuthenticatedUser(request);

        // Grab the courses and cache them for the user
        if (activeUser.getCourses().isEmpty()) {
            activeUser.addCourses(CoursesUtils.findCoursesForUser(activeUser.getUsername()));
        }

        // Display the user courses
        request.setAttribute(JSP_USERNAME_KEY, activeUser.getUsername());
        request.setAttribute(JSP_COURSES_KEY, activeUser.getCourses());

        return new ModelAndView(COURSES_VIEW_NAME);
    }
}
