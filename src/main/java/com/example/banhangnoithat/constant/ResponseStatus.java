package com.example.banhangnoithat.constant;

public enum ResponseStatus {
    SUCCESS(200, "Success"),
    BAD_REQUEST(400, "Bad Request"),
    ;
    private final int code;
    private final String message;

    ResponseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
