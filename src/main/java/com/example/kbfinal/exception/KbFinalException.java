package com.example.kbfinal.exception;

import lombok.Getter;

@Getter
public class KbFinalException extends RuntimeException{
    private KbFinalErrorCode kbFinalErrorCode;
    private String detailMessage;

    public KbFinalException(KbFinalErrorCode errorCode){
        super(errorCode.getMessage());
        this.kbFinalErrorCode = errorCode;
        this.detailMessage = errorCode.getMessage();
    }

    public KbFinalException(KbFinalErrorCode errorCode, String detailMessage){
        super(detailMessage);
        this.kbFinalErrorCode = errorCode;
        this.detailMessage = detailMessage;
    }
}
