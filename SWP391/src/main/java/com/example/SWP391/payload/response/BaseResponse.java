package com.example.SWP391.payload.response;

import lombok.Data;

@Data
public class BaseResponse {
    private int statusCode;
    private String message;
    private Object data;
}
