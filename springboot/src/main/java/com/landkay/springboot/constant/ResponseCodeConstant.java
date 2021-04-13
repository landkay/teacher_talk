package com.landkay.springboot.constant;

public enum ResponseCodeConstant {

    SUCCESS("000000", "成功"),
    ERROR("500000", "系统异常"),

    /**
     * 参数相关响应码定义 : 01xxxx
     */
    PARAMS_IS_NULL("010001", "参数不能为空"),
    PARAMS_LENGTH_OVER("010002", "字段长度过长"),
    PARAMS_TYPE_ERROR("010003", "参数类型错误");


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
