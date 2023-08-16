package com.easypan.mappers;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:
 * @author: zjy
 * @date: 2023/08/15
 */
public interface InfoMapper<T,P> extends BaseMapper {
	/**
	 * 根据UserId查询
	 */
	T selectByUserId(@Param("userId") String userId);

	/**
	 * 根据UserId删除
	 */
	int deleteByUserId(@Param("userId") String userId);

	/**
	 * 根据UserId更新
	 */
	int updateByUserId(@Param("bean") T t, @Param("userId") String userId);

	/**
	 * 根据Email查询
	 */
	T selectByEmail(@Param("email") String email);

	/**
	 * 根据Email删除
	 */
	int deleteByEmail(@Param("email") String email);

	/**
	 * 根据Email更新
	 */
	int updateByEmail(@Param("bean") T t, @Param("email") String email);

	/**
	 * 根据QqOpenId查询
	 */
	T selectByQqOpenId(@Param("qqOpenId") String qqOpenId);

	/**
	 * 根据QqOpenId删除
	 */
	int deleteByQqOpenId(@Param("qqOpenId") String qqOpenId);

	/**
	 * 根据QqOpenId更新
	 */
	int updateByQqOpenId(@Param("bean") T t, @Param("qqOpenId") String qqOpenId);

	/**
	 * 根据NickName查询
	 */
	T selectByNickName(@Param("nickName") String nickName);

	/**
	 * 根据NickName删除
	 */
	int deleteByNickName(@Param("nickName") String nickName);

	/**
	 * 根据NickName更新
	 */
	int updateByNickName(@Param("bean") T t, @Param("nickName") String nickName);




}
