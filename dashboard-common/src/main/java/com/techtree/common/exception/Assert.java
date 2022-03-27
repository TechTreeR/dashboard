package com.techtree.common.exception;

import com.techtree.common.api.ResultCode;

/**
 * @author Dysprosium
 * @title: Assert
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2612:55
 */
public class Assert {

    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(ResultCode errorCode) {
        throw new ApiException(errorCode);
    }
}
