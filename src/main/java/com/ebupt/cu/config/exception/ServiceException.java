package com.ebupt.cu.config.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName ServiceException
 * @Description
 * @Author Leipei
 * @Date 2020/11/14 15:34
 * @Version V1.0
 **/
@Setter
@Getter
public class ServiceException extends RuntimeException {
    private String code;

    public ServiceException(String code, String message) {
        super(message);
        this.code = code;
    }
}
