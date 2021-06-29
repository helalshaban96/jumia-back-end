package com.jumia.advice;

import com.jumia.enums.ErrorCode;
import com.jumia.enums.ErrorCodeGroup;
import com.jumia.exceptions.BusinessException;
import com.jumia.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    private static final Map<ErrorCodeGroup, HttpStatus> errorCodeGroupHttpStatusMap;

    static {
        Map<ErrorCodeGroup, HttpStatus> aMap = new HashMap<>();
        aMap.put(ErrorCodeGroup.BAD_REQUEST, HttpStatus.BAD_REQUEST);
        aMap.put(ErrorCodeGroup.NOT_FOUND, HttpStatus.NOT_FOUND);
        errorCodeGroupHttpStatusMap = Collections.unmodifiableMap(aMap);
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> handleCustomerException(
        BusinessException ex, WebRequest request) {
        final ErrorCode errorCode = ex.getErrorCode();
        final ErrorResponse errorResponse = ErrorResponse.builder().code(errorCode.getCode())
            .message(errorCode.getMessage()).build();
        final HttpStatus httpStatus = errorCodeGroupHttpStatusMap
            .getOrDefault(errorCode.getErrorCodeGroup(), HttpStatus.INTERNAL_SERVER_ERROR);
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}

