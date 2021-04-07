package cn.com.myproject.qd.constant;

/**
 * @author xx
 */
public class BaseConstant {
    public static final String USER_SESSION = "USER_SESSION";


    /**
     * 图形验证码
     * */
    public static final String VRIFYCODE = "vrifyCode";


    public static final String COOKIE_LOGINURL = "loginUrl";


    /**
     * 默认密码
     */
    public static final String DEFAULT_PASSWD = "123456";




    /***
     * 以下是redis 中的 key
     */
    public static final String REDIS_USER_INFO = "user:";

    public static final String REDIS_USER_ROLE = "userroles:";

    public static final String REDIS_MENU = "menu:";


    public static final String URL_SECURITY_KEY = "url_security";

    public static final String METHOD_SECURITY_KEY = "method_security";

    /***
     * shop的地址位置
     */
    public static final String SHOP_GEO_KEY = "shop_geo";
    /**
     * 领取记录
     */
    public static final String GIFT_GET_KEY = "gift_get";
    /**
     * 回答问题正确记录
     */
    public static final String QUESTION_GET_KEY = "question_get";


}
