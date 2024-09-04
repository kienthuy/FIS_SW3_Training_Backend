package com.fis.portal.model;


public class BaseListResponse extends BaseResponse{

    private long total;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public BaseListResponse() {
    }

    public BaseListResponse(long total) {
        super();
        this.total = total;
    }

    public BaseListResponse(Object data,long total) {
        super(data);
        this.total = total;
    }

    public BaseListResponse(Object data, String errorCode, String errorDesc, long total) {
        super(data, errorCode, errorDesc);
        this.total = total;
    }

    public BaseListResponse(Object data) {
        super(data);
    }
}