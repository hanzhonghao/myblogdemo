package com.zhonghao.exception;


import com.zhonghao.common.exception.CustomRuntimeException;
import com.zhonghao.common.exception.ExceptionStatus;

/**
 * @author tt
 */
public class CategoryException extends CustomRuntimeException {

    public CategoryException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
