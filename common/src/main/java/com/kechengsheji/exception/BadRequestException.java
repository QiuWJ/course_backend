package com.kechengsheji.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * 错误请求异常类
 *
 * @author shen
 * @date 2019-4-22
 */
@Getter
public class BadRequestException extends RuntimeException {

    private Integer code = BAD_REQUEST.value();

    public BadRequestException(String msg) {
        super(msg);
    }

    public BadRequestException(HttpStatus code, String msg) {
        super(msg);
        this.code = code.value();
    }
}
