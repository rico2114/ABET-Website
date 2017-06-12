package puj.co.authentication;

import puj.co.authentication.model.UserBean;
import puj.co.authentication.model.UserPrivilege;

/**
 * Created by Sebastían on 6/06/2017.
 * This class is a static utility class used only for static utilities
 */
public class AuthenticationUtils {

    /**
     * This class can't be instantiated
     */
    private AuthenticationUtils() {
    }

    /**
     * Checks if whether or not the user attempting to authenticate is a valid user
     * @param username  the username of the user
     * @param password  the password of the user
     * @return  true if the authentication was successful
     */
    public static UserBean authenticate(final String username, final String password) {
        // todo: here should be the call to the webservice
        // if fails then return null
        if (false) {
            return null;
        }
        return new UserBean(username, password, UserPrivilege.ADMINISTRATOR);
    }
}
