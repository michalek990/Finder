package com.example.finder.Exceptions;

import com.example.finder.Exceptions.policy.ApplicationExceptionPolicy;
import com.example.finder.Exceptions.policy.ExceptionReasonPolicy;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;

import static java.lang.String.format;


@Getter
@Setter
public class ApplicationException extends RuntimeException implements ApplicationExceptionPolicy {
    protected final String code;
    protected final String messageKey;
    protected final Object[] messageParams;
    protected final HttpStatus httpStatus;


    public ApplicationException(final ExceptionReasonPolicy reason) {
        super(reason.getMessageKey());
        this.code = reason.getCode();
        this.messageKey = reason.getMessageKey();
        this.httpStatus = reason.getHttpStatus();
        this.messageParams = null;
    }

    public ApplicationException(final ExceptionReasonPolicy reason, final HttpStatus httpStatus) {
        super(reason.getMessageKey());
        this.code = reason.getCode();
        this.messageKey = reason.getMessageKey();
        this.httpStatus = httpStatus;
        this.messageParams = null;
    }

    public ApplicationException(final ExceptionReasonPolicy reason,final HttpStatus httpStatus, final Object... params) {
        super(format(reason.getMessageKey(), params));
        this.code = reason.getCode();
        this.httpStatus = httpStatus;
        this.messageKey = reason.getMessageKey();
        this.messageParams = params;
    }

    public ApplicationException(final ExceptionReasonPolicy reason, final Object... params) {
        super(format(reason.getMessageKey()));
        this.code = reason.getCode();
        this.messageKey = reason.getMessageKey();
        this.httpStatus = reason.getHttpStatus();
        this.messageParams = params;
    }

    @Override
    public String getMessage(){
        return super.getMessage() + ", message params=" + Arrays.toString(this.messageParams);
    }

    @Override
    public String toString(){
        return format("%s(code=%s, messageKey=%s, messageParams=%s, httpStatus=%s)",
                getClass().getSimpleName(),
                this.getCode(),
                this.getHttpStatus().value(),
                this.getMessageKey(),
                Arrays.toString(this.getMessageParams()));
    }
}
