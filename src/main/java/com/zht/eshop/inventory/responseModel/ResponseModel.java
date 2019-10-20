package com.zht.eshop.inventory.responseModel;

/**
 * 请求的响应
 * @author Administrator
 *
 */
public class ResponseModel {

	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";

	private String status;
	private String message;

	public ResponseModel() {

	}

	public ResponseModel(String status) {
		this.status = status;
	}

	public ResponseModel(String status, String message) {
		this.status = status;
		this.message = message;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
