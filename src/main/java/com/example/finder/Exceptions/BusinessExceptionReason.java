package com.example.finder.Exceptions;

import com.example.finder.Exceptions.policy.ExceptionReasonPolicy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
@AllArgsConstructor
public enum BusinessExceptionReason implements ExceptionReasonPolicy{

    ENTITY_NOT_FOUND("entity.not.found", HttpStatus.NOT_FOUND),
    CITY_NOT_FOUND("city.not.found", HttpStatus.NOT_FOUND),
    COUNTRY_NOT_FOUND("country.not.found", HttpStatus.NOT_FOUND);

    private final String code = BusinessException.class.getSimpleName();
    private final String messageKey;
    private final HttpStatus httpStatus;
}
