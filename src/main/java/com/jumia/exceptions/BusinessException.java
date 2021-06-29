package com.jumia.exceptions;

import com.jumia.enums.ErrorCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BusinessException extends Exception {

    private final ErrorCode errorCode;
}
