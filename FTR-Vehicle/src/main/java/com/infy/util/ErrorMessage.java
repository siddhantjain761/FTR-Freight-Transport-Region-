package com.infy.util;

public class ErrorMessage {
	private Integer statusCode;
	private String message;
	private String url;
	

	@Override
	public String toString() {
		return "ErrorMessage [statusCode=" + statusCode + ", message=" + message + ", url=" + url + "]";
	}


	public Integer getStatusCode() {
		return statusCode;
	}


	public String getMessage() {
		return message;
	}


	public String getUrl() {
		return url;
	}


	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public ErrorMessage() {
		// TODO Auto-generated constructor stub
	}

}
