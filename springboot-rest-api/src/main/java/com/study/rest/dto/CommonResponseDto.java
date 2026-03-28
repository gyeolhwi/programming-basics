package com.study.rest.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CommonResponseDto<T> {
    private String message;
    private int count;
    private boolean isSuccess;
    private T data;

    public static CommonResponseDto ofDefault(int count) {
        return CommonResponseDto.builder()
                .message(count > 0 ? "Successfully" : "Failed")
                .count(count)
                .isSuccess(count > 0)
                .build();
    }
}
