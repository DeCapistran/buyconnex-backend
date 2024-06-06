package com.buyconnex.buyconnex.vo.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class GenericResponseVo {

    private String message;

    private String error;

    private int codeHttp;

    public GenericResponseVo(final String message) {
        super();
        this.message = message;
    }

    public GenericResponseVo(final String message, final int codeHttp) {
        super();
        this.message = message;
        this.codeHttp = codeHttp;
    }

    public GenericResponseVo(final String message, final String error, final int codeHttp) {
        super();
        this.message = message;
        this.error = error;
        this.codeHttp = codeHttp;
    }

    public GenericResponseVo(List<ObjectError> allError, String error) {
        this.error = error;
        String temp = allError.stream().map(e -> {
            if (e instanceof FieldError) {
                return "{\"field\":\"" + ((FieldError) e).getField() + "\",\"defaultMessage\":\"" +  e.getDefaultMessage() + "\"}";
            } else {
                return "{\"object\":\"" + e.getObjectName() + "\",\"defaultMessage\":\"" +  e.getDefaultMessage() + "\"}";
            }
                }).collect(Collectors.joining(","));
        this.message = "[" + temp + "]";
    }
}
