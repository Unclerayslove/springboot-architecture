package com.ebupt.cu.result;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @ClassName R
 * @Description
 * @Author Leipei
 * @Date 2020/11/10 11:06
 * @Version V1.0
 **/
@Data
@Accessors(chain = true)
public class R<T> {
    private String code;
    private String message;
    private T data;

    public R() {
    }

    private static <T> R<T> restResult(T data, String code, String message) {
        R<T> apiResult = new R<>();
        apiResult.setData(data);
        apiResult.setCode(code);
        apiResult.setMessage(message);
        return apiResult;
    }

    public <T> R<T> success(T data) {
        return restResult(data, ER.SUCCESS.getCode(), ER.SUCCESS.getMessage());
    }

    public static <T> R<T> success() {
        return restResult(null, ER.SUCCESS.getCode(), ER.SUCCESS.getMessage());
    }

    public static <T> R<T> failed() {
        return restResult(null, ER.FAILED.getCode(), ER.FAILED.getMessage());
    }

    public static <T> R<T> failed(String message) {
        return restResult(null, ER.FAILED.getCode(), message);
    }

    public static <T> R<T> exception(String code, String message) {
        return restResult(null, code, message);
    }

    public static <T> R<T> error() {
        return restResult(null, ER.UNKNOWN_REASON.getCode(), ER.UNKNOWN_REASON.getMessage());
    }

}
