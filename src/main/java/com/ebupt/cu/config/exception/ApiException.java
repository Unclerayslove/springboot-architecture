package com.ebupt.cu.config.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * @ClassName ApiException
 * @Description REST API 请求异常类
 * @Author Leipei
 * @Date 2020/11/25 17:15
 * @Version V1.0
 **/
@Setter
@Getter
public class ApiException extends RuntimeException {
    private String code;

    public ApiException(String code, String message) {
        super(message);
        this.code = code;
    }
}
