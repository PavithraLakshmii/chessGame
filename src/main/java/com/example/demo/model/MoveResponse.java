package com.example.demo.model;

public class MoveResponse {
    private final boolean success;
    private final String message;

    public MoveResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
