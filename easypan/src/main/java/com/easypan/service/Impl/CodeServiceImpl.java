package com.easypan.service.Impl;

import com.easypan.config.AppConfig;
import com.easypan.entity.constants.Constants;
import com.easypan.entity.dto.SysSettingsDto;
import com.easypan.entity.po.Code;
import com.easypan.entity.po.Info;
import com.easypan.entity.query.CodeQuery;
import com.easypan.entity.query.InfoQuery;
import com.easypan.entity.vo.PaginationResultVO;
import com.easypan.entity.query.SimplePage;
import com.easypan.exception.BusinessException;
import com.easypan.mappers.CodeMapper;
import com.easypan.entity.enums.PageSize;
import com.easypan.mappers.InfoMapper;
import com.easypan.service.CodeService;
import com.easypan.utils.RedisComponent;
import com.easypan.utils.StringTools;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.List;

/**
 * @Description: 邮箱验证码Service
 * @author: zjy
 * @date: 2023/08/15
 */
@Service("codeService")
public class CodeServiceImpl implements CodeService {
	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

	@Resource
	private CodeMapper<Code,CodeQuery> codeMapper;

	@Resource
	private InfoMapper<Info, InfoQuery> userInfoMapper;

	@Resource
	private JavaMailSender javaMailSender;

	@Resource
	private AppConfig appConfig;

	@Resource
	private RedisComponent redisComponent;

//	@Resource
//	private RedisComponent redisComponent;
	/**
	 * 根据条件查询列表
	 */
	@Override
	public List<Code> findListByParam(CodeQuery query) {
		return this.codeMapper.selectList(query);
	}

	/**
	 * 根据条件查询数量
	 */
	@Override
	public int findCountByParam(CodeQuery query) {
		return this.codeMapper.selectCount(query);
	}

	/**
	 * 分页查询
	 */
	@Override
	public PaginationResultVO<Code> findListByPage(CodeQuery query) {
		int count = this.findCountByParam(query);
		int pageSize = query.getPageSize()==null?PageSize.SIZE15.getSize():query.getPageSize();
		SimplePage page = new SimplePage(query.getPageNo(),count,pageSize);
		query.setSimplePage(page);
		List<Code> list = this.findListByParam(query);
		PaginationResultVO<Code> result = new PaginationResultVO<>(count,page.getPageSize(),page.getPageNo(),page.getPageTotal(),list);
		return result;
	}

	/**
	 * 新增
	 */
	@Override
	public int add(Code bean) {
		return this.codeMapper.insert(bean);
	}

	/**
	 * 新增或更新
	 */
	@Override
	public int addOrUpdate(Code bean) {
		return this.codeMapper.insertOrUpdate(bean);
	}

	/**
	 * 批量新增
	 */
	@Override
	public int addBatch(List<Code> listBean) {
		if(listBean == null || listBean.isEmpty()){
			return 0;
		}
		return this.codeMapper.insertBatch(listBean);
	}

	/**
	 * 批量新增或更新
	 */
	@Override
	public int addOrUpdateBatch(List<Code> listBean) {
		if(listBean == null || listBean.isEmpty()){
			return 0;
		}
		return this.codeMapper.insertOrUpdateBatch(listBean);
	}

	/**
	 * 根据EmailAndCode查询
	 */
	@Override
	public Code getByEmailAndCode(String email, String code) {
		return this.codeMapper.selectByEmailAndCode(email, code);
	}

	/**
	 * 根据EmailAndCode删除
	 */
	@Override
	public int deleteByEmailAndCode(String email, String code) {
		return this.codeMapper.deleteByEmailAndCode(email, code);
	}

	/**
	 * 根据EmailAndCode更新
	 */
	@Override
	public int updateByEmailAndCode(Code bean, String email, String code) {
		return this.codeMapper.updateByEmailAndCode(bean, email, code);
	}


	/**
	 * 发送邮箱验证码的前置和后置工作
	 * @param toEmail 发送的邮箱地址
	 * @param type  0:注册  1:找回密码
	 */

	@Override
	@Transactional
	public void sendEmailCode(String toEmail, Integer type)  {
		//如果是注册，校验邮箱是否已存在
		if (type == Constants.REGISTER_ZERO) {
			Info userInfo = userInfoMapper.selectByEmail(toEmail);
			if (null != userInfo) {
				throw new BusinessException("邮箱已经存在");
			}
		}

		//生成验证码
		String code = StringTools.getRandomNumber(Constants.LENGTH_5);
		//发送邮件到email
		sendEmailCode(toEmail, code);
		//将之前的验证码置为无效
		codeMapper.disableEmailCode(toEmail);

		// 封装EmailCode对象
		Code emailCode = new Code();
		emailCode.setCode(code);
		emailCode.setEmail(toEmail);
		emailCode.setStatus(Constants.REGISTER_ZERO);
		emailCode.setCreateTime(new Date());

		// 插入数据库
		codeMapper.insert(emailCode);
	}

	/**
	 * 真正发送邮件验证码
	 * @param toEmail 发送到邮箱
	 * @param code 需要发送的验证码
	 */
	private void sendEmailCode(String toEmail, String code) {
		try {
			MimeMessage message = javaMailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			//邮件发件人
			helper.setFrom(appConfig.getSendUserName());
			//邮件收件人 1或多个
			helper.setTo(toEmail);

			SysSettingsDto sysSettingsDto = redisComponent.getSysSettingsDto();

			//邮件主题
			helper.setSubject(sysSettingsDto.getRegisterEmailTitle());
			//邮件内容
			helper.setText(String.format(sysSettingsDto.getRegisterEmailContent(), code));
			//邮件发送时间
			helper.setSentDate(new Date());
			//发送
			javaMailSender.send(message);
		} catch (Exception e) {
			logger.error("邮件发送失败", e);
			throw new BusinessException("邮件发送失败");
		}
	}
}
