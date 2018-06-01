package com.zhonghao.enums;


import com.zhonghao.common.exception.ExceptionStatus;

/**
 * 分类异常状态码(30000-39999)
 */
public enum UserExceptionEnum implements ExceptionStatus {

    NOT_FOUND_USER(30000, "用户不存在"),
    ;

    private final int code;
    private final String desc;
    UserExceptionEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getDesc() {
        return desc;
    }
}
