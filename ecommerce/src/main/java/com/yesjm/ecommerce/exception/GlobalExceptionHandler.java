package com.yesjm.ecommerce.exception;

import com.yesjm.ecommerce.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // 내부 서버 오류 처리
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;

        // 상세 정보
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("exception", ex.getClass().getName());

        // ErrorResponse 생성
        ErrorResponse errorResponse = new ErrorResponse(false,
                                                        new ErrorResponse.ErrorDetails(
                                                            errorCode.name(),
                                                            errorCode.getMessage(),
                                                            errorDetails)
        );

        // 500 서버 오류 응답
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EcommerceException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(EcommerceException ex) {
        ErrorCode errorCode = ex.getErrorCode();

        // 상세 정보
        Map<String, Object> details = new HashMap<>();
        details.put("exception", ex.getDetailMessage());

        // ErrorResponse 생성
        ErrorResponse errorResponse = new ErrorResponse(false,
                                                        new ErrorResponse.ErrorDetails(
                                                            errorCode.name(),
                                                            errorCode.getMessage(),
                                                            details)
        );

        return new ResponseEntity<>(errorResponse, errorCode.getHttpStatus());
    }

}
