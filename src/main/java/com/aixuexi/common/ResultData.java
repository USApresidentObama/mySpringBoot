package com.aixuexi.common;

public class ResultData {
    private Integer flag;
    private Object data;
    private String message;
    private Integer code;


    public ResultData(){
    }

    public ResultData(Integer flag, Object data, String message, Integer code) {
        this.flag = flag;
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public static ResultData success() {
        return new ResultData(1, null, null, 200);
    }

    public static ResultData success(Object data) {
        return new ResultData(1, data, "success", 200);
    }

    public static ResultData fail(String message) {
        return new ResultData(1, null, message, 500);
    }

    public static ResultData fail(String message, Integer code) {
        return new ResultData(1, null, message, code);
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
