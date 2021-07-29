package com.aixuexi.liuaotest.exception;

import com.aixuexi.common.enums.ImessageCode;

public class LiuaoException extends RuntimeException {

    private ImessageCode imessageCode;

    public LiuaoException() {
        super();
    }
    public LiuaoException(Throwable t) {
        super(t);
    }
    public LiuaoException(String msg) {
        super(msg);
    }
    public LiuaoException(String msg, Throwable t) {
        super(msg,t);
    }
    public LiuaoException(ImessageCode imessageCod) {
        super(imessageCod.getMessage());
        this.imessageCode = imessageCod;
    }

    public ImessageCode getImessageCode() {
        return imessageCode;
    }

    public void setImessageCode(ImessageCode imessageCode) {
        this.imessageCode = imessageCode;
    }
}
