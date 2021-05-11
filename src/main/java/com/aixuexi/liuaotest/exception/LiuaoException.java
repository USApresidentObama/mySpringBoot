package com.aixuexi.liuaotest.exception;

public class LiuaoException extends RuntimeException {

    /**错误描述*/
    private String msg;

    public LiuaoException() {
        super();
    }
    public LiuaoException(Throwable t) {
        super(t);
    }
    public LiuaoException(String msg) {
        super(msg);
        this.msg = msg;
    }
    public LiuaoException(String msg, Throwable t) {
        super(msg,t);
        this.msg = msg;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
