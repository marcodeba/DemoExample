package com.example.demoexample.exception;

import com.example.demoexample.enums.CommonEnum;

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

    public BizException() {
        super();
    }

    public BizException(CommonEnum commonEnum) {
        super(String.valueOf(commonEnum.getResultCode()));
        this.errorCode = commonEnum.getResultCode();
        this.errorMsg = commonEnum.getResultMsg();
    }

    public BizException(CommonEnum commonEnum, Throwable cause) {
        super(String.valueOf(commonEnum.getResultCode()), cause);
        this.errorCode = commonEnum.getResultCode();
        this.errorMsg = commonEnum.getResultMsg();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public BizException(int errorCode, String errorMsg) {
        super(String.valueOf(errorCode));
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BizException(int errorCode, String errorMsg, Throwable cause) {
        super(String.valueOf(errorCode), cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
