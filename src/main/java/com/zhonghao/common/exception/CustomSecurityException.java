package com.zhonghao.common.exception;


/**
 * Created by zhonghao.han on 6/1/2018.
 */
public class CustomSecurityException extends CustomRuntimeException {

    public CustomSecurityException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
