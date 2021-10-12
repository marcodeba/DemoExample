package com.example.service.demoservice.exception;


import com.example.service.demoservice.enums.CommonEnum;

/**
 * @author：marco.pan
 * @ClassName：BizException
 * @Description：
 * @date: 2021年10月12日 1:44 上午
 */
public class BizException extends RuntimeException {
    /**
     * 错误码
     */
    protected int errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public BizException(CommonEnum commonEnum) {
        super(String.valueOf(commonEnum.getResultCode()));
        this.errorCode = commonEnum.getResultCode();
        this.errorMsg = commonEnum.getResultMsg();
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
