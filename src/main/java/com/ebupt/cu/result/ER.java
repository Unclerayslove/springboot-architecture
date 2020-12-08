package com.ebupt.cu.result;

import lombok.Getter;

@Getter
public enum ER {
    SUCCESS("0000", "成功"),
    FAILED("9999", "失败"),
    UNKNOWN_REASON("1000", "未知错误"),
    BUSINESS("1001", "业务错误"),

    BODY_NOT_MATCH("400", "请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401", "请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503", "服务器正忙，请稍后再试!");

    private String code;
    private String message;

    ER(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
