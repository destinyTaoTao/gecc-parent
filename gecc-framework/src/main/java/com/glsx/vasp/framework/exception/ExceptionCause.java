package com.glsx.vasp.framework.exception;

import com.glsx.vasp.framework.web.R;

public interface ExceptionCause<T extends Exception> {

    /**
     * 创建异常
     *
     * @return
     */
    T exception(Object... args);

    R result();

}
