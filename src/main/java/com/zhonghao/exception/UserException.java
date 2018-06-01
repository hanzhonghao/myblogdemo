package com.zhonghao.exception;


import com.zhonghao.common.exception.CustomRuntimeException;
import com.zhonghao.common.exception.ExceptionStatus;

/**
 * @author tt
 */
public class UserException extends CustomRuntimeException {

    public UserException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
