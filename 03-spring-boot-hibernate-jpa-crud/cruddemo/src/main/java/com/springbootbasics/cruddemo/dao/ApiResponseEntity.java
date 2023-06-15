package com.springbootbasics.cruddemo.dao;

import org.springframework.http.HttpStatus;

public class ApiResponseEntity {
    private String message;
    private HttpStatus status;
    private  int statusCode;
    private Object responseBody;


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(Object responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "ApiResponseEntity{" +
                "message='" + message + '\'' +
                ", status=" + status +
                ", statusCode=" + statusCode +
                ", responseBody=" + responseBody +
                '}';
    }
}
