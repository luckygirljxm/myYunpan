package com.easypan.entity.query;

import java.util.Date;

/**
 * @Description: 查询对象
 * @author: zjy
 * @date: 2023/08/15
 */
public class InfoQuery extends BaseQuery {
	/**
	 * 用户主键
	 */
	private String userId;
	private String userIdFuzzy;
	/**
	 * 用户昵称
	 */
	private String nickName;
	private String nickNameFuzzy;
	/**
	 * 邮箱
	 */
	private String email;
	private String emailFuzzy;
	/**
	 * qqopenId
	 */
	private String qqOpenId;
	private String qqOpenIdFuzzy;
	/**
	 * qq头像
	 */
	private String qqAvatar;
	private String qqAvatarFuzzy;
	/**
	 * 密码
	 */
	private String password;
	private String passwordFuzzy;
	/**
	 * 加入时间
	 */
	private Date joinTime;
	private String joinTimeStart;
	private String joinTimeEnd;
	/**
	 * 最后登录时间
	 */
	private Date lastLoginTime;
	private String lastLoginTimeStart;
	private String lastLoginTimeEnd;
	/**
	 * 0禁用  1启用
	 */
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

	/**
	 * 
	 */
	public void setUserIdFuzzy(String userIdFuzzy) {
		this.userIdFuzzy = userIdFuzzy;
	}

	/**
	 * 
	 */
	public String getUserIdFuzzy() {
		return this.userIdFuzzy;
	}

	/**
	 * 
	 */
	public void setNickNameFuzzy(String nickNameFuzzy) {
		this.nickNameFuzzy = nickNameFuzzy;
	}

	/**
	 * 
	 */
	public String getNickNameFuzzy() {
		return this.nickNameFuzzy;
	}

	/**
	 * 
	 */
	public void setEmailFuzzy(String emailFuzzy) {
		this.emailFuzzy = emailFuzzy;
	}

	/**
	 * 
	 */
	public String getEmailFuzzy() {
		return this.emailFuzzy;
	}

	/**
	 * 
	 */
	public void setQqOpenIdFuzzy(String qqOpenIdFuzzy) {
		this.qqOpenIdFuzzy = qqOpenIdFuzzy;
	}

	/**
	 * 
	 */
	public String getQqOpenIdFuzzy() {
		return this.qqOpenIdFuzzy;
	}

	/**
	 * 
	 */
	public void setQqAvatarFuzzy(String qqAvatarFuzzy) {
		this.qqAvatarFuzzy = qqAvatarFuzzy;
	}

	/**
	 * 
	 */
	public String getQqAvatarFuzzy() {
		return this.qqAvatarFuzzy;
	}

	/**
	 * 
	 */
	public void setPasswordFuzzy(String passwordFuzzy) {
		this.passwordFuzzy = passwordFuzzy;
	}

	/**
	 * 
	 */
	public String getPasswordFuzzy() {
		return this.passwordFuzzy;
	}

	/**
	 * 
	 */
	public void setJoinTimeStart(String joinTimeStart) {
		this.joinTimeStart = joinTimeStart;
	}

	/**
	 * 
	 */
	public String getJoinTimeStart() {
		return this.joinTimeStart;
	}

	/**
	 * 
	 */
	public void setJoinTimeEnd(String joinTimeEnd) {
		this.joinTimeEnd = joinTimeEnd;
	}

	/**
	 * 
	 */
	public String getJoinTimeEnd() {
		return this.joinTimeEnd;
	}

	/**
	 * 
	 */
	public void setLastLoginTimeStart(String lastLoginTimeStart) {
		this.lastLoginTimeStart = lastLoginTimeStart;
	}

	/**
	 * 
	 */
	public String getLastLoginTimeStart() {
		return this.lastLoginTimeStart;
	}

	/**
	 * 
	 */
	public void setLastLoginTimeEnd(String lastLoginTimeEnd) {
		this.lastLoginTimeEnd = lastLoginTimeEnd;
	}

	/**
	 * 
	 */
	public String getLastLoginTimeEnd() {
		return this.lastLoginTimeEnd;
	}

}