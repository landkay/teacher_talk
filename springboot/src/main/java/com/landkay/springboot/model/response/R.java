package com.landkay.springboot.model.response;

import java.util.Map;

public class R {

    private String code;
    private String msg;
    private Object data;

    private R(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static R success(Object data) {

        return new R("0000", "success", data);
    }

    public static R error(String message) {

        return new R("0001", message, null);
    }

    public static R error(String code, String message) {

        return new R(code, message, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

}
