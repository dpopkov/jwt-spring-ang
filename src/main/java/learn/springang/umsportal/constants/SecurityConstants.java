package learn.springang.umsportal.constants;

public class SecurityConstants {

    public static final long EXPIRATION_TIME = 5 * 24 * 60 * 60 * 1000;    // 5 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_HEADER = "Jwt-Token";
    public static final String TOKEN_CANNOT_BE_VERIFIED = "Token Cannot be verified";
    public static final String COMPANY_LLC = "Company, LLC";
    public static final String COMPANY_ADMINISTRATION = "User Management Portal";
    public static final String AUTHORITIES = "authorities";
    public static final String FORBIDDEN_MESSAGE = "You need to log in to access this page";
    public static final String ACCESS_DENIED = "You do not have permission to access this page";
    public static final String OPTIONS_HTTP_METHOD = "OPTIONS";
    private static final String USER_PREFIX = "/user";
    /*
    public static final String[] PUBLIC_URLS = {
            USER_PREFIX + "/login",
            USER_PREFIX + "/register",
            USER_PREFIX + "/resetpassword/**",
            USER_PREFIX + "/image/**"};

     */
    public static final String[] PUBLIC_URLS = { "**"};
}
