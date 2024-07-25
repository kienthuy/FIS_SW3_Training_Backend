package com.fis.portal.model;


public class BaseListResponse extends BaseResponse{

    private long totalRecord;

    public long getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(long totalRecord) {
        this.totalRecord = totalRecord;
    }

   
    public BaseListResponse() {
    }

    public BaseListResponse(long totalRecord) {
        super();
        this.totalRecord = totalRecord;
    }

    public BaseListResponse(Object data,long totalRecord) {
        super(data);
        this.totalRecord = totalRecord;
    }

    public BaseListResponse(Object data, String errorCode, String errorDesc, long totalRecord) {
        super(data, errorCode, errorDesc);
        this.totalRecord = totalRecord;
    }

    public BaseListResponse(Object data) {
        super(data);
    }
}