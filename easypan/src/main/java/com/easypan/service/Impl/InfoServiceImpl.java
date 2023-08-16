package com.easypan.service.Impl;

import com.easypan.entity.po.Info;
import com.easypan.entity.query.InfoQuery;
import com.easypan.entity.vo.PaginationResultVO;
import com.easypan.entity.query.SimplePage;
import com.easypan.mappers.InfoMapper;
import com.easypan.entity.enums.PageSize;
import com.easypan.service.InfoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: Service
 * @author: zjy
 * @date: 2023/08/15
 */
@Service("infoService")
public class InfoServiceImpl implements InfoService {

	@Resource
	private InfoMapper<Info,InfoQuery> infoMapper;

	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Info> findListByParam(InfoQuery query) {
		return this.infoMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	@Override
	public int findCountByParam(InfoQuery query) {
		return this.infoMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PaginationResultVO<Info> findListByPage(InfoQuery query) {
		int count = this.findCountByParam(query);
		int pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(),count,pageSize);
		query.setSimplePage(page);
		List<Info> list = this.findListByParam(query);
		PaginationResultVO<Info> result = new PaginationResultVO<>(count,page.getPageSize(),page.getPageNo(),page.getPageTotal(),list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public int add(Info bean) {
		return this.infoMapper.insert(bean);
	}

	/**
	 * 新增或更新
	 */
	@Override
	public int addOrUpdate(Info bean) {
		return this.infoMapper.insertOrUpdate(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public int addBatch(List<Info> listBean) {
		if(listBean == null || listBean.isEmpty()){
			return 0;
		}
		return this.infoMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或更新
	 */
	@Override
	public int addOrUpdateBatch(List<Info> listBean) {
		if(listBean == null || listBean.isEmpty()){
			return 0;
		}
		return this.infoMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据UserId查询
	 */
	@Override
	public Info getByUserId(String userId) {
		return this.infoMapper.selectByUserId(userId);
	}

	/**
	 * 根据UserId删除
	 */
	@Override
	public int deleteByUserId(String userId) {
		return this.infoMapper.deleteByUserId(userId);
	}

	/**
	 * 根据UserId更新
	 */
	@Override
	public int updateByUserId(Info bean, String userId) {
		return this.infoMapper.updateByUserId(bean, userId);
	}

	/**
	 * 根据Email查询
	 */
	@Override
	public Info getByEmail(String email) {
		return this.infoMapper.selectByEmail(email);
	}

	/**
	 * 根据Email删除
	 */
	@Override
	public int deleteByEmail(String email) {
		return this.infoMapper.deleteByEmail(email);
	}

	/**
	 * 根据Email更新
	 */
	@Override
	public int updateByEmail(Info bean, String email) {
		return this.infoMapper.updateByEmail(bean, email);
	}

	/**
	 * 根据QqOpenId查询
	 */
	@Override
	public Info getByQqOpenId(String qqOpenId) {
		return this.infoMapper.selectByQqOpenId(qqOpenId);
	}

	/**
	 * 根据QqOpenId删除
	 */
	@Override
	public int deleteByQqOpenId(String qqOpenId) {
		return this.infoMapper.deleteByQqOpenId(qqOpenId);
	}

	/**
	 * 根据QqOpenId更新
	 */
	@Override
	public int updateByQqOpenId(Info bean, String qqOpenId) {
		return this.infoMapper.updateByQqOpenId(bean, qqOpenId);
	}

	/**
	 * 根据NickName查询
	 */
	@Override
	public Info getByNickName(String nickName) {
		return this.infoMapper.selectByNickName(nickName);
	}

	/**
	 * 根据NickName删除
	 */
	@Override
	public int deleteByNickName(String nickName) {
		return this.infoMapper.deleteByNickName(nickName);
	}

	/**
	 * 根据NickName更新
	 */
	@Override
	public int updateByNickName(Info bean, String nickName) {
		return this.infoMapper.updateByNickName(bean, nickName);
	}

}
