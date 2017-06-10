package puj.co.courses.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import puj.co.authentication.model.UserBean;
import puj.co.courses.CoursesUtils;
import puj.co.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by Sebastían on 7/06/2017.
 * Represents the definition of a course in a page
 */
@Controller
@RequestMapping("/course")
public class CoursePage {

    /**
     * Represents the course view name
     */
    public static final String COURSE_VIEW_NAME = "course";

    /**
     * Represents the course name key
     */
    private static final String COURSE_NAME_KEY = "name";

    /**
     * Attempts to load the course page based on the parameters
     * @param request   the request of the user
     * @return  the {@link ModelAndView view}
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loadCoursePage(HttpServletRequest request) {
        // Requires authentication
        final ModelAndView authenticationRequired = Utils.validateAuthentication(request);
        if (Objects.nonNull(authenticationRequired)) {
            return authenticationRequired;
        }

        // Grab the active user
        final UserBean activeUser = Utils.getAuthenticatedUser(request);

        // Grab the parameters
        final String name = (String) request.getParameter("name");
        final String identifier = (String) request.getParameter("identifier");

        // Check if the course is available for that user if not redirect to courses
        if (!CoursesUtils.userContainsCourse(activeUser, identifier, name)) {
            return new ModelAndView(Utils.redirect(Utils.WEBSITE_ROOT + GeneralCoursesPage.COURSES_VIEW_NAME));
        }

        request.setAttribute(COURSE_NAME_KEY, name);
        return new ModelAndView(COURSE_VIEW_NAME);
    }
}
