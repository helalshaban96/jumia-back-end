package com.jumia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.jumia.enums.ErrorCodeGroup.BAD_REQUEST;
import static com.jumia.enums.ErrorCodeGroup.NOT_FOUND;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    NOT_EXIST("-1", "app.error.country_not_found", NOT_FOUND),
    ILLEGAL_STATE("-2", "app.error.illegal_state", BAD_REQUEST),
    ILLEGAL_PARAMS("-3", "app.error.illegal_params", BAD_REQUEST);

    private final String code;
    private final String message;
    private final ErrorCodeGroup ErrorCodeGroup;
}
