package com.glsx.vasp.exception;

import java.io.Serializable;

public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public static ServiceException create(Integer errorCode, String errorMessage) {
        return null;
    }

    public static ServiceException create(String message) {
        return null;
    }

}
