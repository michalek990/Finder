package com.example.finder.Exceptions.policy;

import org.springframework.http.HttpStatus;

public interface ExceptionReasonPolicy extends ExceptionPolicy{

    String getMessageKey();

    HttpStatus getHttpStatus();

    @Override
    default String getMessage() {
        return getMessageKey();
    }
}
