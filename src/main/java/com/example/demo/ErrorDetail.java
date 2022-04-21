package com.example.demo;
import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class ErrorDetail {
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd-mm-yy hh:mm:ss")
	private Date timestamp;
	
	private String message;
	private String details;
	public ErrorDetail(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = "id not found";
		this.details = details;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public ErrorDetail() {
		super();
	}
	public ErrorDetail(String message) {
		this.message=message;
		// TODO Auto-generated constructor stub
	}

	
}
