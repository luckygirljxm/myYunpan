package com.easypan.service;
import java.util.List;
import com.easypan.entity.po.Info;
import com.easypan.entity.query.InfoQuery;
import com.easypan.entity.vo.PaginationResultVO;

public interface InfoService{

	/**
	 * 根据条件查询列表
	 */
	List<Info> findListByParam(InfoQuery query);

	/**
	 * 根据条件查询数量
	 */
	int findCountByParam(InfoQuery query);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Info> findListByPage(InfoQuery query);

	/**
	 * 新增
	 */
	int add(Info bean);

	/**
	 * 新增或更新
	 */
	int addOrUpdate(Info bean);

	/**
	 * 批量新增
	 */
	int addBatch(List<Info> listBean);

	/**
	 * 批量新增或更新
	 */
	int addOrUpdateBatch(List<Info> listBean);

	/**
	 * 根据UserId查询
	 */
	Info getByUserId(String userId);

	/**
	 * 根据UserId删除
	 */
	int deleteByUserId(String userId);

	/**
	 * 根据UserId更新
	 */
	int updateByUserId(Info bean, String userId);

	/**
	 * 根据Email查询
	 */
	Info getByEmail(String email);

	/**
	 * 根据Email删除
	 */
	int deleteByEmail(String email);

	/**
	 * 根据Email更新
	 */
	int updateByEmail(Info bean, String email);

	/**
	 * 根据QqOpenId查询
	 */
	Info getByQqOpenId(String qqOpenId);

	/**
	 * 根据QqOpenId删除
	 */
	int deleteByQqOpenId(String qqOpenId);

	/**
	 * 根据QqOpenId更新
	 */
	int updateByQqOpenId(Info bean, String qqOpenId);

	/**
	 * 根据NickName查询
	 */
	Info getByNickName(String nickName);

	/**
	 * 根据NickName删除
	 */
	int deleteByNickName(String nickName);

	/**
	 * 根据NickName更新
	 */
	int updateByNickName(Info bean, String nickName);

}
