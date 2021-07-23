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
        return new ResultData(1, data, null, 200);
    }

    public static ResultData fail(String message) {
        return new ResultData(1, null, message, 500);
    }

    public static ResultData fail(String message, Integer code) {
        return new ResultData(1, null, message, code);
    }

}
