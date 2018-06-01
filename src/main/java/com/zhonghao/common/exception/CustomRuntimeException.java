package com.zhonghao.common.exception;


public class CustomRuntimeException extends RuntimeException {

    protected ExceptionStatus exStatus;

    public CustomRuntimeException(ExceptionStatus exStatus) {
        this.exStatus = exStatus;
    }

}
