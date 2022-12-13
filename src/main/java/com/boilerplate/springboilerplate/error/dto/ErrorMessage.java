package com.boilerplate.springboilerplate.error.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorMessage {
    CUSTOM_ERROR_MESSAGE("에러 메세지에 대한 설명"),
    ;

    private final String description;
}
