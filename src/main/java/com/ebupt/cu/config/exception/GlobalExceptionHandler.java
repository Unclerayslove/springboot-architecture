package com.ebupt.cu.config.exception;

import com.ebupt.cu.result.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @ClassName ExceptionHandlerAdvice
 * @Description 全局异常处理
 * @Author Leipei
 * @Date 2020/11/14 14:45
 * @Version V1.0
 **/
@RestControllerAdvice
@Slf4j(topic = "异常日志")
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<R> exceptionHandler(Exception exception, HttpServletResponse response) {
        String code = "400";
        String message = "";
        if (exception instanceof BindException) {
            // 当对用@Valid注释的参数进行验证失败时，将引发异常。在controller层
            BindException bindException = (BindException) exception;
            message = bindException.getAllErrors().stream().map(be -> be == null ? "" : be.getDefaultMessage())
                    .collect(Collectors.joining(","));
            log.error("========参数校验异常，code：{}，message：{}========", code, message);
        } else if (exception instanceof ConstraintViolationException) {
            // 报告违反约束的结果 Reports the result of constraint violations.
            ConstraintViolationException cve = (ConstraintViolationException) exception;
            message = cve.getConstraintViolations().stream().map(cv -> cv == null ? "" : cv.getMessage())
                    .collect(Collectors.joining(","));
            log.error("========约束违例异常，code：{}，message：{}========", code, message);
        } else if (exception instanceof ServiceException) {
            // 业务层抛出异常处理
            ServiceException se = (ServiceException) exception;
            code = se.getCode();
            message = exception.getMessage();
            log.error("========业务层异常，code：{}，message：{}========", code, message);
        } else if (exception instanceof ApiException) {
            ApiException ae = (ApiException) exception;
            code = ae.getCode();
            message = ae.getMessage();
            log.error("========API异常，code：{}，message：{}========", code, message);
        } else {
            // 其他异常
            exception.printStackTrace();
            message = exception.getMessage();
        }
        return new ResponseEntity<>(R.exception(code, message), HttpStatus.valueOf(response.getStatus()));
    }

}
