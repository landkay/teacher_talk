package com.landkay.springboot.constant;

public enum ResponseCodeConstant {

    SUCCESS("00000", "成功"),
    PARAMS_ISNULL("41000", "参数为空"),
    ERROR("50000", "系统异常");


    private String code;
    private String msg;

    ResponseCodeConstant(String code, String msg){
        this.code = code;
        this.msg = msg;
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
}
