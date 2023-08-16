package com.easypan.entity.po;

import java.io.Serializable;
import java.util.Date;

import com.easypan.entity.enums.DateTimePatternEnum;
import com.easypan.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description: 邮箱验证码
 * @author: zjy
 * @date: 2023/08/15
 */
public class Code implements Serializable {
	/**
	 *
	 */
	private String email;
	/**
	 *
	 */
	private String code;
	/**
	 *
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	/**
	 * 0未使用  1已使用
	 */
	@JsonIgnore
	private Integer status;
	/**
	 *
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 *
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 *
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 *
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 *
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 *
	 */
	public Date getCreateTime() {
		return this.createTime;
	}

	/**
	 * 0未使用  1已使用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 0未使用  1已使用
	 */
	public Integer getStatus() {
		return this.status;
	}

	@Override
	public String toString() {
		return "Code {" + " : " + (email == null ? "空" : email) + "," + " : " + (code == null ? "空" : code) + "," + " : " +
				(createTime == null ? "空" : DateUtils.format(createTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + "0未使用  1已使用 : " + (status == null ? "空" : status) + "}";
	}
}
