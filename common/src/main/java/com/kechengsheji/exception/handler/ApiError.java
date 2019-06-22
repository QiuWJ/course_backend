package com.kechengsheji.exception.handler;

import lombok.Data;

/**
 * @author shen
 * @date 2019-4-22
 */
@Data
class ApiError {

    private Integer code;
    private String msg;

    public ApiError(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}


