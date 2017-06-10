package puj.co.authentication.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import puj.co.authentication.AuthenticationUtils;
import puj.co.courses.control.GeneralCoursesPage;
import puj.co.authentication.model.UserBean;
import puj.co.utils.Utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by Sebastían on 6/06/2017.
 */
@Controller
@RequestMapping("/authentication")
public class AuthenticationPage {

    /**
     * Represents the authentication view name
     */
    public static final String AUTHENTICATION_VIEW_NAME = "authentication";

    /**
     * Represents the key used to display messages on the authentication.jsp file
     */
    private static final String MESSAGE_KEY = "message";

    /**
     * Represents the user bean key used by the jsp
     */
    private static final String JSP_USER_BEAN_KEY = "userBean";

    /**
     * Represents the invalid authentication message
     */
    private static final String INVALID_AUTHENTICATION_MESSAGE = "Usuario o contraseña invalidos";

    /**
     * This function takes care of the loading of the authentication page
     * @return the view of the authentication page
     */
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loadAuthenticationPage(HttpServletRequest request) {
        final UserBean activeUser = Utils.getAuthenticatedUser(request);;
        // If the user is logged in redirect to the courses page.
        if (Objects.nonNull(activeUser)) {
            return new ModelAndView(Utils.redirect(Utils.WEBSITE_ROOT + GeneralCoursesPage.COURSES_VIEW_NAME));
        }
        return new ModelAndView(AUTHENTICATION_VIEW_NAME).addObject(JSP_USER_BEAN_KEY, new UserBean());
    }

    /**
     * This function is called when the authentication has been submitted
     * @param request   the {@link HttpServletRequest request} of the user
     * @param userBean  the {@link UserBean user}
     * @return the view that we should redirect to
     */
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView authenticate(HttpServletRequest request, @ModelAttribute(JSP_USER_BEAN_KEY) UserBean userBean) {
        ModelAndView componentResponse = null;
        final UserBean authenticationResult = AuthenticationUtils.authenticate(userBean.getUsername(), userBean.getPassword());

        // We could authenticate
        if (Objects.nonNull(authenticationResult)) {
            request.getSession().setAttribute(Utils.ACTIVE_USER_KEY, userBean);
            componentResponse = new ModelAndView(Utils.redirect(Utils.WEBSITE_ROOT + GeneralCoursesPage.COURSES_VIEW_NAME));
        } else {
            // Failed authenticating
            componentResponse = new ModelAndView(AUTHENTICATION_VIEW_NAME);
            request.setAttribute(MESSAGE_KEY, INVALID_AUTHENTICATION_MESSAGE);
        }
        return componentResponse;
    }
}
