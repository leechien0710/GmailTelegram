package com.example.springmail.dto.respone;

import com.example.springmail.common.HttpRes;

public class SaveUserRes {
    private HttpRes httpRes;
    public SaveUserRes(HttpRes httpRes) {
        this.httpRes = httpRes;
    }
    public HttpRes getHttpRes() {
        return httpRes;
    }

    public void setHttpRes(HttpRes httpRes) {
        this.httpRes = httpRes;
    }
}
