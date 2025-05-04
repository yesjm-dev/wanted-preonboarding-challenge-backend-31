package com.yesjm.ecommerce.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDto<T> {

    private boolean success;
    private T data;
    private String message;

    public ResponseDto(boolean success, T data) {
        this.success = success;
        this.data = data;
        this.message = "요청이 성공적으로 처리되었습니다.";
    }

}
