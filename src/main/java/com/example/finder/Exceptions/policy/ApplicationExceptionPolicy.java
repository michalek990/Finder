package com.example.finder.Exceptions.policy;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.Null;
import org.springframework.http.HttpStatus;

public interface ApplicationExceptionPolicy extends ExceptionPolicy{
    HttpStatus getHttpStatus();

    @Nullable
    Object[] getMessageParams();
}
