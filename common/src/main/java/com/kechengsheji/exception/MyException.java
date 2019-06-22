package com.kechengsheji.exception;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author: songshoubin
 * @date: 2019-06-22
 */
public class MyException extends RuntimeException{
    private Integer code;

    private String msg;

    /*构造方法*/

    public MyException(Integer code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    /*get、set方法*/
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

}
