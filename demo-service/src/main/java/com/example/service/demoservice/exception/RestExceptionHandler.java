package com.example.service.demoservice.exception;

import com.example.service.demoservice.base.ResultData;
import com.example.service.demoservice.enums.BizExceptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.stream.Collectors;

/**
 * <p>
 * <code>RestExceptionHandler</code>
 * </p>
 * Description:
 * 服务层全局响应异常
 */
@Slf4j
@RestControllerAdvice
@ResponseBody
public class RestExceptionHandler {
    @ExceptionHandler(value = BizException.class)
    public ResultData bizExceptionHandler(HttpServletRequest req, BizException e) {
        log.error("发生业务异常！原因是：{}", e.getErrorMsg());
        return ResultData.error(e.getErrorCode(), e.getErrorMsg());
    }

    /**
     * 默认全局异常处理。
     *
     * @param req
     * @param e   the e
     * @return ResultData
     */
    @ExceptionHandler(Exception.class)
    public ResultData<String> exceptionHandler(HttpServletRequest req, Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResultData.error(BizExceptionEnum.INTERNAL_SERVER_ERROR);
    }

    /**
     * 处理空指针的异常
     *
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value = NullPointerException.class)
    public ResultData nullPointerExceptionHandler(HttpServletRequest req, NullPointerException e) {
        log.error("发生空指针异常！原因是:", e);
        return ResultData.error(BizExceptionEnum.BODY_NOT_MATCH);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResultData<String> arithmeticExceptionHandler(ArithmeticException e) {
        log.error("ArithmeticException ex={}", e.getMessage(), e);
        return ResultData.error(BizExceptionEnum.DIVIDE_BY_ZERO);
    }

    @ExceptionHandler(value = {BindException.class, ValidationException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<ResultData<String>> handleValidatedException(Exception e) {
        ResultData<String> resp = null;

        if (e instanceof MethodArgumentNotValidException) {
            // BeanValidation exception
            MethodArgumentNotValidException ex = (MethodArgumentNotValidException) e;
            resp = ResultData.error(HttpStatus.BAD_REQUEST.value(),
                    ex.getBindingResult().getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof ConstraintViolationException) {
            // BeanValidation GET simple param
            ConstraintViolationException ex = (ConstraintViolationException) e;
            resp = ResultData.error(HttpStatus.BAD_REQUEST.value(),
                    ex.getConstraintViolations().stream()
                            .map(ConstraintViolation::getMessage)
                            .collect(Collectors.joining("; "))
            );
        } else if (e instanceof BindException) {
            // BeanValidation GET object param
            BindException ex = (BindException) e;
            resp = ResultData.error(HttpStatus.BAD_REQUEST.value(),
                    ex.getAllErrors().stream()
                            .map(ObjectError::getDefaultMessage)
                            .collect(Collectors.joining("; "))
            );
        }

        log.error("参数校验异常:{}", resp.getMessage());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
}
