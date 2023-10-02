package com.example.finder.Exceptions;

import com.example.finder.Exceptions.policy.ExceptionReasonPolicy;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends BusinessException {

    public EntityNotFoundException(ExceptionReasonPolicy reason) {
        super(reason);
    }

    public EntityNotFoundException(ExceptionReasonPolicy reason, HttpStatus httpStatus) {
        super(reason, httpStatus);
    }

    public EntityNotFoundException(ExceptionReasonPolicy reason, HttpStatus httpStatus, Object... params) {
        super(reason, httpStatus, params);
    }

    public EntityNotFoundException(ExceptionReasonPolicy reason, Object... params) {
        super(reason, params);
    }
}