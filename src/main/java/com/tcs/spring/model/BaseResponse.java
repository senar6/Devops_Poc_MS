package com.tcs.spring.model;

import java.util.List;

public class BaseResponse {
	
	String errorCode;
	boolean isSuccess;
	String errorMessage;
	
	List<WorkOrder> workorders;
	public BaseResponse(){}
	public BaseResponse(String errorCode, boolean isSuccess,
			String errorMessage, List<WorkOrder> workorders) {
		super();
		this.errorCode = errorCode;
		this.isSuccess = isSuccess;
		this.errorMessage = errorMessage;
		this.workorders = workorders;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public boolean isSuccess() {
		return isSuccess;
	}
	public void setSuccess(boolean isSuccess) {
		this.isSuccess = isSuccess;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public List<WorkOrder> getWorkorders() {
		return workorders;
	}
	public void setWorkorders(List<WorkOrder> workorders) {
		this.workorders = workorders;
	}
	
	

}