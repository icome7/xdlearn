package com.iseven.learn.xdlearn.util;

/**
 * 用户封装统一返回类型对象
 */
public class ResultData {

    /**
     * 返回成功
     */
    private static final int SUCCESS_CODE = 0;
    /**
     * 通用系统异常
     */
    private static final int ERROR_CODE = -1;
    /**
     * 状态码
     */
    private int code;

    /**
     * 返回的业务数据
     */
    private Object data;

    /**
     * 返回信息
     */
    private String msg;

    /**
     * 通用成功返回无返回数据
     * @return
     */
    public static ResultData success() {
        return new ResultData(SUCCESS_CODE, null, null);
    }

    /**
     * 通用成功返回带返回值
     * @param data
     * @return
     */
    public static ResultData success(Object data) {
        return new ResultData(SUCCESS_CODE, data, null);
    }

    /**
     * 通用异常返回带异常信息
     * @param msg
     * @return
     */
    public static ResultData error(String msg) {
        return new ResultData(ERROR_CODE, null, msg);
    }

    public ResultData() {
    }

    public ResultData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
