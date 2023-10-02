package com.example.finder.Exceptions;

import com.example.finder.Exceptions.policy.BusinessExceptionPolicy;
import com.example.finder.Exceptions.policy.ExceptionReasonPolicy;
import org.springframework.http.HttpStatus;

public class BusinessException extends ApplicationException implements BusinessExceptionPolicy {
    public BusinessException(ExceptionReasonPolicy reason) {
        super(reason);
    }

    public BusinessException(ExceptionReasonPolicy reason, HttpStatus httpStatus) {
        super(reason, httpStatus);
    }

    public BusinessException(ExceptionReasonPolicy reason, HttpStatus httpStatus, Object... params) {
        super(reason, httpStatus, params);
    }

    public BusinessException(ExceptionReasonPolicy reason, Object... params) {
        super(reason, params);
    }
}
