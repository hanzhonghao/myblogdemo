package com.zhonghao.enums;


import com.zhonghao.common.exception.ExceptionStatus;

/**
 * 分类异常状态码(20000-29999)
 */
public enum CategoryExceptionEnum implements ExceptionStatus {

    NOT_FOUND_CATEGORY(20000, "分类不存在"),

    ;

    private final int code;
    private final String desc;
    CategoryExceptionEnum(int code, String desc) {
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
