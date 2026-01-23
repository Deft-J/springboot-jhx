package com.example.demo.service;

public class Response <T>{
    private T data;
    private boolean success;
    private String errorMessage;

    public static <K>Response<K> newSuccess(K data){
        Response<K> response = new Response<K>();
        response.setData(data);
        response.setSuccess(true);
        return response;
    }

    public static Response newFail(String errorMessage){
        Response<Void> response=new Response<Void>();
        response.setErrorMessage(errorMessage);
        response.setSuccess(false);
        return response;
    }


    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
