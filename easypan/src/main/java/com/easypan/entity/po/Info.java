package com.easypan.entity.po;

import java.io.Serializable;
import java.util.Date;

import com.easypan.entity.enums.DateTimePatternEnum;
import com.easypan.utils.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @Description:
 * @author: zjy
 * @date: 2023/08/15
 */
public class Info implements Serializable {
	/**
	 * 用户主键
	 */
	private String userId;
	/**
	 * 用户昵称
	 */
	private String nickName;
	/**
	 * 邮箱
	 */
	private String email;
	/**
	 * qqopenId
	 */
	private String qqOpenId;
	/**
	 * qq头像
	 */
	private String qqAvatar;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * 加入时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date joinTime;
	/**
	 * 最后登录时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date lastLoginTime;
	/**
	 * 0禁用  1启用
	 */
	@JsonIgnore
	private Integer status;
	/**
	 * 使用空间单位 byte
	 */
	private Long useSpace;
	/**
	 * 总的使用空间
	 */
	private Long totalSpace;
	/**
	 * 用户主键
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * 用户主键
	 */
	public String getUserId() {
		return this.userId;
	}

	/**
	 * 用户昵称
	 */
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	/**
	 * 用户昵称
	 */
	public String getNickName() {
		return this.nickName;
	}

	/**
	 * 邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 邮箱
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 * qqopenId
	 */
	public void setQqOpenId(String qqOpenId) {
		this.qqOpenId = qqOpenId;
	}

	/**
	 * qqopenId
	 */
	public String getQqOpenId() {
		return this.qqOpenId;
	}

	/**
	 * qq头像
	 */
	public void setQqAvatar(String qqAvatar) {
		this.qqAvatar = qqAvatar;
	}

	/**
	 * qq头像
	 */
	public String getQqAvatar() {
		return this.qqAvatar;
	}

	/**
	 * 密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 密码
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * 加入时间
	 */
	public void setJoinTime(Date joinTime) {
		this.joinTime = joinTime;
	}

	/**
	 * 加入时间
	 */
	public Date getJoinTime() {
		return this.joinTime;
	}

	/**
	 * 最后登录时间
	 */
	public void setLastLoginTime(Date lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	/**
	 * 最后登录时间
	 */
	public Date getLastLoginTime() {
		return this.lastLoginTime;
	}

	/**
	 * 0禁用  1启用
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * 0禁用  1启用
	 */
	public Integer getStatus() {
		return this.status;
	}

	/**
	 * 使用空间单位 byte
	 */
	public void setUseSpace(Long useSpace) {
		this.useSpace = useSpace;
	}

	/**
	 * 使用空间单位 byte
	 */
	public Long getUseSpace() {
		return this.useSpace;
	}

	/**
	 * 总的使用空间
	 */
	public void setTotalSpace(Long totalSpace) {
		this.totalSpace = totalSpace;
	}

	/**
	 * 总的使用空间
	 */
	public Long getTotalSpace() {
		return this.totalSpace;
	}

	@Override
	public String toString() {
		return "Info {" + "用户主键 : " + (userId == null ? "空" : userId) + "," + "用户昵称 : " + (nickName == null ? "空" : nickName) + "," + "邮箱 : "
				+ (email == null ? "空" : email) + "," + "qqopenId : " +
				(qqOpenId == null ? "空" : qqOpenId) + "," + "qq头像 : " +
				(qqAvatar == null ? "空" : qqAvatar) + "," + "密码 : " +
				(password == null ? "空" : password) + "," + "加入时间 : " +
				(joinTime == null ? "空" : DateUtils.format(joinTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern())) + "," + "最后登录时间 : " +
				(lastLoginTime == null ? "空" : DateUtils.format(lastLoginTime, DateTimePatternEnum.YYYY_MM_DD_HH_MM_SS.getPattern()))
				+ "," + "0禁用  1启用 : " + (status == null ? "空" : status) + "," + "使用空间单位 byte : " +
				(useSpace == null ? "空" : useSpace) + "," + "总的使用空间 : " +
				(totalSpace == null ? "空" : totalSpace) + "}";
	}
}
