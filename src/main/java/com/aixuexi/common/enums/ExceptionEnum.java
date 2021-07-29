package com.aixuexi.common.enums;

public enum ExceptionEnum implements ImessageCode{
    PARAMS_ERROR("001", "参数错误"),
    USER_NOT_EXIST("002","用户不存在")

    ;


    private String code;
    private String message;

    ExceptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
