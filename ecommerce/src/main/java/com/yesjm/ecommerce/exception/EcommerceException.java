package com.yesjm.ecommerce.exception;

import lombok.Getter;

@Getter
public abstract class EcommerceException extends RuntimeException {
    private final ErrorCode errorCode;
    private final String message;
    private final String detailMessage;

    protected EcommerceException(ErrorCode errorCode) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
        this.detailMessage = null;
    }

    protected EcommerceException(ErrorCode errorCode, String detailMessage) {
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
        this.detailMessage = detailMessage;
    }

}
