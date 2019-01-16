package com.unittest.unittest.admin.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.unittest.unittest.model.Admin;
import com.unittest.unittest.util.MD5Util;
import com.unittest.unittest.util.UUIDUtils;
import com.unittest.unittest.util.page.PageView;
import com.unittest.unittest.bo.AdminService;

@Controller
@RequestMapping(value="backendadmin")
public class AdminAdminController {

	@Resource
	private AdminService adminService;
	
	/**
	 * adminManagement
	 * 管理员管理
	 */
	/**
	 * 管理员管理
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("adminManagement")
	public ModelAndView adminManagement(HttpServletRequest request,Model model) {
		ModelAndView mv = new ModelAndView();
		String activeTab = (request.getParameter("activeTab") == null ? "" : request.getParameter("activeTab"));
		if(activeTab != null && activeTab != "") {
			model.addAttribute("activeTab", activeTab);
		}else {
			model.addAttribute("activeTab", "tab_0");
		}
		mv.setViewName("/backend/admin/adminManagement");      
		return mv;
	}
	/**
	 * 查询管理员
	 * @param pageView
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "queryAdminMap", method = RequestMethod.POST)
	public @ResponseBody
	ModelMap queryAdminMap( PageView pageView,Admin admin,HttpSession session)  throws Exception {
		ModelMap resultMap = new ModelMap();
		admin.setAdminType(2);
		resultMap = adminService.queryAdminMap(pageView, admin);
		return resultMap;
	}
	
	@RequestMapping("newAdmin")
	public ModelAndView addAdmin(Model model) {
		model.addAttribute("doType", "add");
		return new ModelAndView("/backend/admin/adminAction");
	}

	@RequestMapping(value = "saveAdmin", method = RequestMethod.POST)
	public String saveAdmin(@ModelAttribute("admin") Admin admin, HttpSession session) {
		admin.setId(UUIDUtils.generateUUID());
		admin.setAdminType(2);
		admin.setPassWd(MD5Util.MD5("123456"));//初始化
		admin.setCreateTime(new Date());
		adminService.insert(admin);
		return "redirect:/backendadmin/adminManagement";
	}
	
	@RequestMapping("getAdmin")
	public ModelAndView getAdmin(String id,HttpServletRequest request){
		Admin admin = (Admin) adminService.getById(id);
		ModelAndView mv = new ModelAndView("/backend/admin/adminAction");
		mv.addObject("doType", "edit");
		mv.addObject("admin",admin);
		return mv;
	}
	
	@RequestMapping(value = "updateAdmin", method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("admin") Admin admin, HttpSession session){
		adminService.update(admin);
		return "redirect:/backendadmin/adminManagement";
	}
	
	@RequestMapping(value = "deleteAdmin", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, Object> deleteAdmin(String id,HttpSession session,HttpServletRequest request) {
		Map<String, Object> modelMap = new HashMap<String, Object>();
		try {
			adminService.deleteById(id);
				modelMap.put("success", "true");
		} catch (Exception e) {
			modelMap.put("error", "true");
			e.printStackTrace();
		}  finally {

		}
		return modelMap;
	}
}
