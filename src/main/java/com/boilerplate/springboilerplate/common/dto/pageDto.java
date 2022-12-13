package com.boilerplate.springboilerplate.common.dto;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.util.List;

public record pageDto<T> ( // TODO : pageDto의 필요성과 @PageableDefault, Pageable에 대해 공부하기!
        List<T> data,
        int page,
        int size,
        int totalPAge,
        long totalElements,
        boolean firstPage,
        boolean lastPage

) implements Serializable {
    public static <T> ResponseEntity<T> ok(T data) {
        return ResponseEntity.ok(data);
    }
}
