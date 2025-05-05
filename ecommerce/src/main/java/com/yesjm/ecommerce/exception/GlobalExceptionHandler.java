package com.yesjm.ecommerce.exception;

import com.yesjm.ecommerce.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // 내부 서버 오류 처리
        ErrorCode errorCode = ErrorCode.INTERNAL_ERROR;

        // 상세 정보
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("exception", ex.getClass().getName());
        errorDetails.put("exceptionMessage", ex.getMessage());

        // ErrorResponse 생성
        ErrorResponse errorResponse = new ErrorResponse(false,
                                                        new ErrorResponse.ErrorDetails(
                                                            errorCode.name(),
                                                            errorCode.getMessage(),
                                                            errorDetails)
        );

        log.error("exception",ex);

        // 500 서버 오류 응답
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(EcommerceException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(EcommerceException ex) {
        ErrorCode errorCode = ex.getErrorCode();

        // 상세 정보
        Map<String, Object> errorDetails = new HashMap<>();
        errorDetails.put("exception", ex.getClass().getName());
        errorDetails.put("exceptionMessage", ex.getDetailMessage());

        // ErrorResponse 생성
        ErrorResponse errorResponse = new ErrorResponse(false,
                                                        new ErrorResponse.ErrorDetails(
                                                            errorCode.name(),
                                                            errorCode.getMessage(),
                                                            errorDetails)
        );

        log.error("exception",ex);

        return new ResponseEntity<>(errorResponse, errorCode.getHttpStatus());
    }

}
