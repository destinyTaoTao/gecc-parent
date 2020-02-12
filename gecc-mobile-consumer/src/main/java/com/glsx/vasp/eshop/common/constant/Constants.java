package com.glsx.vasp.eshop.common.constant;

import com.glsx.vasp.constant.BasicConstants;

/**
 * 〈一句话功能简述〉<br>
 * 公共常量类
 *
 * @author liuyf
 * @create 3/20/2019 09:49
 * @since 1.0.0
 */
public final class Constants extends BasicConstants {

    /**
     * 登录用户在SESSION中的KEY值
     */
    public final static String SESSION_LOGIN_USER = "sys_current_user";

    /**
     * 短信验证码前缀key
     */
    public static final String SMS_VERIFY_CODE_PREFIX = "vasp.sms.verifyCode";

    /**
     * 用户openId
     */
    public static final String REDIS_USER_PHONE_KEY = "vasp:user:phone_";

    // 初始化数据有效时间
    public static final long REDIS_INITDATA_VALID_TIME = 30;

    /**
     * 短信验证码过时时间秒数
     */
    public static final int SMS_VERIFY_CODE_TIMEOUT = 300;

    /**
     * 审核
     */
    public static final int ENABLE_STATUS_CHECK = 0;
    /**
     * 状态:生效
     */
    public static final int ENABLE_STATUS_EFFECT = 1;

    /**
     * 状态:失效
     */
    public static final int ENABLE_STATUS_INVALID = 2;

    /**
     * 券使用状态：2已使用
     */
    public static final int IS_USED = 2;
    /**
     * 券使用状态：1未使用
     */
    public static final int NOT_USED = 1;

    /**
     * 删除标记  -1：已删除
     */
    public static final int IS_DEL = -1;
    /**
     * 删除标记   0：正常
     */
    public static final int NOT_DEL = 0;

}
