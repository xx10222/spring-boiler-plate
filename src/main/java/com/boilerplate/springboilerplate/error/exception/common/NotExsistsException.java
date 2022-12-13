package com.boilerplate.springboilerplate.error.exception.common;

import com.boilerplate.springboilerplate.error.dto.ErrorMessage;
import com.boilerplate.springboilerplate.error.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class NotExsistsException extends BusinessException {
    public NotExsistsException(ErrorMessage message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
