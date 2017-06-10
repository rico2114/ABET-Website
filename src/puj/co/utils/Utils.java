package puj.co.utils;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import puj.co.authentication.control.AuthenticationPage;
import puj.co.authentication.model.UserBean;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Created by Sebastían on 6/06/2017.
 * This static class provides general purpose utilities to the system
 */
public class Utils {

    /**
     * Represents the website root
     */
    public static final String WEBSITE_ROOT = "/AbetApp/";

    /**
     * This key is going to be used globally to identify the active user among various controllers
     */
    public static final String ACTIVE_USER_KEY = "activeUser";

    /**
     * This class can't be instantiated
     */
    private Utils() {
    }

    /**
     * Grabs the authenticated {@link UserBean user}
     * @param request   the request
     * @return  the user
     */
    public static UserBean getAuthenticatedUser(HttpServletRequest request) {
        return (UserBean) request.getSession().getAttribute(ACTIVE_USER_KEY);
    }

    /**
     * This method checks if the user has already authenticated if so the return is null
     * @param request   the request
     * @return  null if the user has already authenticated otherwise returns the authentication {@link ModelAndView view}
     */
    public static ModelAndView validateAuthentication(HttpServletRequest request) {
        final UserBean activeUser = getAuthenticatedUser(request);
        if (Objects.isNull(activeUser)) {
            return new ModelAndView(redirect(WEBSITE_ROOT + AuthenticationPage.AUTHENTICATION_VIEW_NAME));
        }
        return null;
    }

    /**
     * Generates a {@link RedirectView view} used only for redirects
     * @param url   the url to redirect to with their parameters if needed
     * @return  the view
     */
    public static RedirectView redirect(final String url) {
        RedirectView redirectView = new RedirectView(url);
        redirectView.setExposeModelAttributes(false);
        return redirectView;
    }
}
