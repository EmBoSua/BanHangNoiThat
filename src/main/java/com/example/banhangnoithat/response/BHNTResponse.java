package com.example.banhangnoithat.response;

import com.example.banhangnoithat.constant.ResponseStatus;

public class BHNTResponse<T>{
    private int code;
    private String message;
    private T data;
    private int total;

    public BHNTResponse(int code, String message, T data, int total) {
        this.code = code;
        this.message = message;
        this.data = data;
        this.total = total;
    }

    public BHNTResponse(T data, int total) {
        this.data = data;
        this.code = ResponseStatus.SUCCESS.getCode();
        this.message = ResponseStatus.SUCCESS.getMessage();
        this.total = total;
    }

    public BHNTResponse(T data) {
        this.data = data;
        this.code = ResponseStatus.SUCCESS.getCode();
        this.message = ResponseStatus.SUCCESS.getMessage();
    }

    public BHNTResponse(ResponseStatus status){
        this.code = status.getCode();
        this.message = status.getMessage();
    }

    public BHNTResponse(String message) {
        this.message = message;
    }

    public BHNTResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
