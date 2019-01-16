package com.unittest.unittest.admin.controller;

import com.xushuzn.common.dao.OrderBy;
import com.xushuzn.common.pagination.PaginationUtils;
import com.unittest.unittest.bo.TestCaseBO;
import com.unittest.unittest.model.TestCase;
import com.unittest.unittest.util.StringUtil;
import com.unittest.unittest.util.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * TestCase业务后台管理
 */
@Controller
@RequestMapping(value = "backendtestCase")
public class TestCaseAdminController extends PaginationController {
	@Autowired
	private TestCaseBO testCaseBO;

	/**
	 * TestCase管理首页
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/testCaseManagement")
	public ModelAndView index(HttpServletRequest request, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/testCase/testCaseManagement");
		String activeTab = (request.getParameter("activeTab") == null ? ""
				: request.getParameter("activeTab"));
		if (activeTab != null && activeTab != "") {
			model.addAttribute("activeTab", activeTab);
		} else {
			model.addAttribute("activeTab", "tab_0");
		}
		return mv;
	}

	/**
	 * 异步加载TestCase数据列表
	 * 
	 * @param testCase
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryTestCaseMap", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap queryTestCaseMap(@ModelAttribute("testCase") TestCase testCase,
			@RequestParam(defaultValue = "1") int pageNow, Model model,
									  @RequestParam(defaultValue = "10") int pageSize, String sortName, String sortOrder) {
		int totalNumberOfElements = testCaseBO.count(testCase);
		OrderBy orderBy = new OrderBy();
		if (sortName != null && !("".equalsIgnoreCase(sortName))) {
			if (!StringUtil.isNumeric(sortName)) {
				sortName = sortName.replace("Text", "");
				orderBy.add(sortName, "asc".equalsIgnoreCase(sortOrder) ? true : false);
			}
		}
		orderBy.add("updatedAt",false);
		orderBy.add("createdAt",false);
		List<TestCase> elements = testCaseBO.find(testCase, orderBy,pageSize,
				pageNow);
		model.addAttribute("p", PaginationUtils.newPagination(
				pageSize, pageNow, totalNumberOfElements,
				elements));
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("records", elements);
		modelMap.addAttribute("iTotalRecords", totalNumberOfElements);
		modelMap.addAttribute("iTotalDisplayRecords", totalNumberOfElements);
		modelMap.addAttribute("sStatus", "OK");
		return modelMap;
	}

	/**
	 * 新增TestCase
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/newTestCase")
	public ModelAndView newTestCase(Model model) {
		model.addAttribute("doType", "add");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/testCase/testCaseAction");
		model.addAttribute("testCase", new TestCase());
		return mv;
	}
	
	/**
	 * 保存TestCase
	 */
	@RequestMapping(value = "/saveTestCase", method = RequestMethod.POST)
	public String saveTestCase(TestCase testCase, HttpSession session) {
		//testCase.setCreatedAt(new java.util.Date());
		//testCase.setCreatedBy((String)session.getAttribute("adminId"));
		testCaseBO.insert(testCase);
		return "redirect:/backendtestCase/testCaseManagement";
	}

	/**
	 * 编辑TestCase
	 * @return
	 */
	@RequestMapping(value = "/{id}/editTestCase")
	public ModelAndView edit(@PathVariable @ModelAttribute("id") java.lang.String id,
			@ModelAttribute("redirectUrl") String redirectUrl, Model model) {
		TestCase testCase = testCaseBO.get(id);
		model.addAttribute("doType", "edit");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/testCase/testCaseAction");
		model.addAttribute("testCase", testCase);
		return mv;
	}

	/**
	 * 更新TestCase
	 * @return
	 */
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	public String update(TestCase testCase, @PathVariable java.lang.String id, HttpSession session) {
		//testCase.setUpdatedAt(new java.util.Date());
		//testCase.setUpdatedBy((String)session.getAttribute("adminId"));
		testCaseBO.update(testCase, id);
		return "redirect:/backendtestCase/testCaseManagement";
	}

	/**
	 * 删除TestCase
	 * @return
	 */
	@RequestMapping(value = "/{id}/remove", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> remove(@PathVariable java.lang.String id) {
		Map<String, Object> modelMap = new HashMap<>();
		try {
			testCaseBO.remove(id);
			modelMap.put("success", "true");
		} catch (Exception e) {
			modelMap.put("error", "true");
			e.printStackTrace();
		}
		return modelMap;
	}
}
