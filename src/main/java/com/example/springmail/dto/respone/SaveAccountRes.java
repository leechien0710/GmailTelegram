package com.example.springmail.dto.respone;

import com.example.springmail.common.HttpRes;

public class SaveAccountRes {
    private HttpRes httpRes;
    public SaveAccountRes(HttpRes httpRes) {
        this.httpRes = httpRes;
    }

    public HttpRes getHttpRes() {
        return httpRes;
    }

    public void setHttpRes(HttpRes httpRes) {
        this.httpRes = httpRes;
    }
}
