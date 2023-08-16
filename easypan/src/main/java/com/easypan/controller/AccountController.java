package com.easypan.controller;



import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.easypan.entity.constants.Constants;
import com.easypan.entity.dto.CreateImageCode;
import com.easypan.entity.vo.ResponseVO;
import com.easypan.exception.BusinessException;
import org.springframework.web.bind.annotation.*;
import com.easypan.service.*;

import java.io.IOException;

@RestController("userInfoController")
//@RequestMapping("UserInfo")
public class AccountController extends AGlobalExceptionHandlerController {

	@Resource
	private InfoService UserInfoService;

	@Resource
	private CodeService emailCodeService;
	/**
	 * 根据请求类型返回验证码并存入session
	 *
	 * @param type 0:登录注册  1:邮箱验证码发送  默认0
	 */
	@GetMapping("/checkCode")
	public void checkCode(HttpServletResponse response, HttpSession session
			, @RequestParam(value = "type", required = false) Integer type) throws IOException {
		CreateImageCode vCode = new CreateImageCode(130, 38, 5, 10);

		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache"); //响应消息不能缓存
		response.setDateHeader("Expires", 0);
		response.setContentType("image/jpeg");

		String code = vCode.getCode();
		if (type == null || type == 0) {
			session.setAttribute(Constants.CHECK_CODE_KEY, code);
		} else {
			session.setAttribute(Constants.CHECK_CODE_KEY_EMAIL, code);
		}
		vCode.write(response.getOutputStream());
	}

	/**
	 * @param email     需要接收验证码的邮箱
	 * @param checkCode 发送给服务器的验证码
	 * @param type      0:注册  1:找回密码
	 */
	@PostMapping("/sendEmailCode")
	public ResponseVO sendEmailCode(HttpSession session,String email,String checkCode,Integer type){
		try{
			if (!checkCode.equalsIgnoreCase((String)session.getAttribute(Constants.CHECK_CODE_KEY_EMAIL))){
				throw new BusinessException("验证码不正确");
			}

			//验证码正确 发送邮箱验证码
			emailCodeService.sendEmailCode(email, type);
			return getSuccessResponseVO(null);
		}finally {
			session.removeAttribute(Constants.CHECK_CODE_KEY_EMAIL);
		}

	}
}
