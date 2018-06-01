package com.zhonghao.exception;


import com.zhonghao.common.exception.CustomRuntimeException;
import com.zhonghao.common.exception.ExceptionStatus;

/**
 * @author tt
 */
public class ArticleException extends CustomRuntimeException {

    public ArticleException(ExceptionStatus exStatus) {
        super(exStatus);
    }
}
