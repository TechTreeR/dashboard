package com.techtree.common.exception;

import com.techtree.common.api.ResultCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dysprosium
 * @title: ApiException
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2612:39
 */

@Data
public class ApiException extends RuntimeException{

    private ResultCode resultCode;

    public ApiException(ResultCode resultCode) {
        super(resultCode.getMessage());
        this.resultCode = resultCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable cause, ResultCode resultCode) {
        super(message, cause);
        this.resultCode = resultCode;
    }

    public ApiException(Throwable cause, ResultCode resultCode) {
        super(cause);
        this.resultCode = resultCode;
    }

    public ApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, ResultCode resultCode) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.resultCode = resultCode;
    }

}
