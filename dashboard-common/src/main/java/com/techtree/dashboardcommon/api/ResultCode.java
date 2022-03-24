package com.techtree.dashboardcommon.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Dysprosium
 * @title: ResultCode
 * @projectName dashboard-backend
 * @description: TODO
 * @date 2022-03-2416:00
 */

@AllArgsConstructor
@NoArgsConstructor
public enum ResultCode {

    SUCCESS(200, "操作成功"),

    FAILED(500, "操作失败"),

    VALIDATE_FAILED(404, "参数检验失败"),

    UNAUTHORIZED(401, "暂未登录或token已经过期"),

    FORBIDDEN(403, "没有相关权限");


    private long code;
    private String message;

    public long getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
