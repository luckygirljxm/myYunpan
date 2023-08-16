package com.easypan.service;
import java.util.List;
import com.easypan.entity.po.Code;
import com.easypan.entity.query.CodeQuery;
import com.easypan.entity.vo.PaginationResultVO;
import com.easypan.exception.BusinessException;

/**
 * @Description: 邮箱验证码Service
 * @author: zjy
 * @date: 2023/08/15
 */
public interface CodeService{

	/**
	 * 根据条件查询列表
	 */
	List<Code> findListByParam(CodeQuery query);

	/**
	 * 根据条件查询数量
	 */
	int findCountByParam(CodeQuery query);

	/**
	 * 分页查询
	 */
	PaginationResultVO<Code> findListByPage(CodeQuery query);

	/**
	 * 新增
	 */
	int add(Code bean);

	/**
	 * 新增或更新
	 */
	int addOrUpdate(Code bean);

	/**
	 * 批量新增
	 */
	int addBatch(List<Code> listBean);

	/**
	 * 批量新增或更新
	 */
	int addOrUpdateBatch(List<Code> listBean);

	/**
	 * 根据EmailAndCode查询
	 */
	Code getByEmailAndCode(String email, String code);

	/**
	 * 根据EmailAndCode删除
	 */
	int deleteByEmailAndCode(String email, String code);

	/**
	 * 根据EmailAndCode更新
	 */
	int updateByEmailAndCode(Code bean, String email, String code);

	void sendEmailCode(String toEmail, Integer type) throws BusinessException;

}
