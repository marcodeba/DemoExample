package com.example.demoexample.base;

import com.example.demoexample.enums.CommonEnum;
import lombok.Data;

@Data
public class ResultData<T> {
    /**
     * 结果状态 ,具体状态码参见CommonEnum.java
     */
    private int status;
    /**
     * 响应消息
     **/
    private String message;
    /**
     * 响应数据
     **/
    private T data;
    /**
     * 接口请求时间
     **/
    private long timestamp;

    public ResultData() {
        this.timestamp = System.currentTimeMillis();
    }

    public static <T> ResultData<T> success(T data) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(CommonEnum.SUCCESS.getResultCode());
        resultData.setMessage(CommonEnum.SUCCESS.getResultMsg());
        resultData.setData(data);
        return resultData;
    }

    public static <T> ResultData<T> error(CommonEnum commonEnum) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(commonEnum.getResultCode());
        resultData.setMessage(commonEnum.getResultMsg());
        return resultData;
    }

    public static <T> ResultData<T> error(int code, String message) {
        ResultData<T> resultData = new ResultData<>();
        resultData.setStatus(code);
        resultData.setMessage(message);
        return resultData;
    }
}
