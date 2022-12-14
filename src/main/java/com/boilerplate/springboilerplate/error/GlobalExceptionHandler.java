package com.boilerplate.springboilerplate.error;

import com.boilerplate.springboilerplate.error.dto.ErrorDto;
import com.boilerplate.springboilerplate.error.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ErrorDto> handleNullPointException(final NullPointerException e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body(new ErrorDto(e.getMessage(), "null exception"));
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<ErrorDto> handleBusinessException(final BusinessException e) {
        log.error("[ERROR] BusinessException -> {}", "Business Exception");
        return ResponseEntity.status(e.getStatus())
                .body(new ErrorDto(e.getMessage(), "Business Exception"));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDto> handleMethodArgumentNotValidException(final MethodArgumentNotValidException e) {
        log.error("[ERROR] MethodArgumentNotValidException -> {}", e.getBindingResult());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(e.getMessage(), e.getMessage()));
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ErrorDto> handleException(final Exception e) {
        log.error("[ERROR] Exception -> {}", e.getCause().toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new ErrorDto(e.getMessage(), e.getMessage()));
    }
}
