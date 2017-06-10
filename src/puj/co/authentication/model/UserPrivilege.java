package puj.co.authentication.model;

/**
 * Created by Sebastían on 6/06/2017.
 * This class represents all the privileges that an user can have
 */
public enum UserPrivilege {
    /**
     * Represents the common user privilege.
     */
    COMMON(0),

    /**
     * Represents the moderator user privilege.
     * This level gives the user power to observe everything
     */
    MODERATOR(1),

    /**
     * Represents the administrator privilege.
     * This level gives the user power to observe and modify everyting
     */
    ADMINISTRATOR(2);

    /**
     * Represents the level of the user
     */
    private final int level;

    /**
     * Constructs an user privilege
     * @param level the level of the user
     */
    UserPrivilege(final int level) {
        this.level = level;
    }

    /**
     * Gets the level of the user
     * @return  the level of the user
     */
    public int getLevel() {
        return level;
    }
}
