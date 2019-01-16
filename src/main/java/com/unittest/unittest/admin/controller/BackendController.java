package com.unittest.unittest.admin.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unittest.unittest.model.Admin;
import com.unittest.unittest.util.MD5Util;
import com.unittest.unittest.util.GeneralResponse;
import com.unittest.unittest.bo.AdminService;

@Controller
@RequestMapping("admin")
public class BackendController {
	@Resource
	private AdminService adminService;
	@RequestMapping("login")
	public ModelAndView login(HttpServletRequest request,Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/login");      
		return mv;
	}
	
	@RequestMapping("index")
	public ModelAndView index(HttpServletRequest request,Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/index");
		return mv;
	}
	
	/**
	 * 用户后台登录
	 * */
	@RequestMapping(value = "login.do", method = RequestMethod.POST)
	@ResponseBody
	public GeneralResponse adminLogin(String userName,String passWord,Integer login,HttpSession sess) {
		GeneralResponse message = new GeneralResponse();
		try {
			Admin admin = adminService.adminLogin(userName,passWord);
				if(admin!=null){
					if(login!=null&&login==1){
						sess.setAttribute("adminName", userName);
						sess.setAttribute("adminId", admin.getId());
						sess.setAttribute("loginAdmin", admin);
					}
					message.setCode(0);
					message.setMsg("用户登录成功");
					message.setData(admin);
				} else {
					message.setCode(8);
					message.setMsg("用户名密码错误");
				}
		} catch (Exception e) {
			message.setCode(8);
			message.setMsg(e.getMessage());
		}
		return message;
	}
	
	@RequestMapping(value = "logout")
	public ModelAndView adminLogout(HttpSession sess) {
		sess.removeAttribute("adminName");
		sess.removeAttribute("adminId");
		sess.removeAttribute("loginAdmin");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/admin/login");
		return mv;
	}
	
	@RequestMapping("changePwd")
	public ModelAndView changePwd(HttpServletRequest request,Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/admin/changePwd");
		return mv;
	}
	
	@RequestMapping(value = "validatePwd.do")
	@ResponseBody
	public boolean validatePwd(String oldpwd,HttpSession session) {
		String userName = (String)session.getAttribute("adminName");
		Admin user = adminService.adminLogin(userName, oldpwd);
		if(user!=null) return true;
		else return false;
	}
	
	@RequestMapping(value = "changePwdSubmit")
	public ModelAndView changePwdSubmit(String password,HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String userId = (String)session.getAttribute("adminId");
		adminService.updatePwd(MD5Util.MD5(password), userId);
		mv.setViewName("redirect:/admin/index");
		return mv;
	}
}
