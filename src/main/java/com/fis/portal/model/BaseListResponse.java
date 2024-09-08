package com.fis.portal.model;


public class BaseListResponse {
	private String message;
	private boolean status;
    private BasePaging result;
    
    
	public BaseListResponse(String message, boolean status, BasePaging result) {
		super();
		this.message = message;
		this.status = status;
		this.result = result;
	}
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public BasePaging getResult() {
		return result;
	}
	public void setResult(BasePaging result) {
		this.result = result;
	}
    
}