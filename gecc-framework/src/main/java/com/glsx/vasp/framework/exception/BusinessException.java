package com.glsx.vasp.framework.exception;

import com.glsx.vasp.framework.web.R;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.ObjectUtils;

/**
 * 系统业务异常,异常号段为 :
 * 0 : 成功
 * 1 ~ 9999 内定系统异常段
 * 10000 ~ 99999 自定义异常码段
 * 100000 ~ Integer.MAX_VALUE 动态异常码段
 */
public class BusinessException extends RuntimeException {

    protected R r;

    protected static final int MIN_AUTO_CODE = 100000;

    protected BusinessException(BusinessException parent) {
        if (parent != null) {
            this.r = parent.r;
        }
    }

    public static BusinessException create(String message) {
        int value = (int) (MIN_AUTO_CODE + Math.round((Integer.MAX_VALUE - MIN_AUTO_CODE) * Math.random()));
        return create(value, message);
    }

    public static BusinessException create(int returnCode, String message) {
        BusinessException businessException = new BusinessException(null);
        businessException.r = R.error(returnCode, message);
        return businessException;
    }

    public static BusinessException create(R r) {
        BusinessException businessException = new BusinessException(null);
        businessException.r = r;
        return businessException;
    }

    public static BusinessException create(ExceptionCause exceptionCause, Object... args) {
        R r = exceptionCause.result();
        String message = r.getMessage();

        if (ArrayUtils.isNotEmpty(args)) {
            String[] argsStringArray = new String[args.length];
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                argsStringArray[i] = ObjectUtils.toString(arg);
            }
            String formatMessage = String.format(message, argsStringArray);
            r.setMessage(formatMessage);
        }

        BusinessException businessException = new BusinessException(null);
        businessException.r = r;
        return businessException;
    }

    @Override
    public String getMessage() {
        return r.getMessage();
    }

    public R getResultEntity() {
        return r;
    }

}
