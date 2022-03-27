package com.techtree.common.api;

/**
 * @Description: 封装API的错误码
 * @author: peng.ni
 * @date: 2021/04/07
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
