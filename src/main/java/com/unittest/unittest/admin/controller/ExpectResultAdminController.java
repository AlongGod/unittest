package com.unittest.unittest.admin.controller;

import com.unittest.unittest.model.CompareResult;
import com.xushuzn.common.dao.OrderBy;
import com.xushuzn.common.model.GeneralResponse;
import com.xushuzn.common.pagination.PaginationUtils;
import com.unittest.unittest.bo.ExpectResultBO;
import com.unittest.unittest.model.ExpectResult;
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
 * ExpectResult业务后台管理
 */
@Controller
@RequestMapping(value = "backendexpectResult")
public class ExpectResultAdminController extends PaginationController {
	@Autowired
	private ExpectResultBO expectResultBO;

	/**
	 * ExpectResult管理首页
	 *
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/expectResultManagement")
	public ModelAndView index(HttpServletRequest request, Model model) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/expectResult/expectResultManagement");
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
	 * 异步加载ExpectResult数据列表
	 * 
	 * @param expectResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/queryExpectResultMap", method = RequestMethod.POST)
	@ResponseBody
	public ModelMap queryExpectResultMap(@ModelAttribute("expectResult") ExpectResult expectResult,
			@RequestParam(defaultValue = "1") int pageNow, Model model,
									  @RequestParam(defaultValue = "10") int pageSize, String sortName, String sortOrder) {
		int totalNumberOfElements = expectResultBO.count(expectResult);
		OrderBy orderBy = new OrderBy();
		if (sortName != null && !("".equalsIgnoreCase(sortName))) {
			if (!StringUtil.isNumeric(sortName)) {
				sortName = sortName.replace("Text", "");
				orderBy.add(sortName, "asc".equalsIgnoreCase(sortOrder) ? true : false);
			}
		}
		orderBy.add("updatedAt",false);
		orderBy.add("createdAt",false);
		List<ExpectResult> elements = expectResultBO.find(expectResult, orderBy,pageSize,
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
	 * 新增ExpectResult
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/newExpectResult")
	public ModelAndView newExpectResult(Model model) {
		model.addAttribute("doType", "add");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/expectResult/expectResultAction");
		model.addAttribute("expectResult", new ExpectResult());
		return mv;
	}
	
	/**
	 * 保存ExpectResult
	 */
	@RequestMapping(value = "/saveExpectResult", method = RequestMethod.POST)
	@ResponseBody
	public String saveExpectResult(ExpectResult expectResult, HttpSession session) {
		//expectResult.setCreatedAt(new java.util.Date());
		//expectResult.setCreatedBy((String)session.getAttribute("adminId"));
		expectResultBO.insert(expectResult);
		return "redirect:/backendexpectResult/expectResultManagement";
	}

	/**
	 * 编辑ExpectResult
	 * @return
	 */
	@RequestMapping(value = "/{id}/editExpectResult")
	public ModelAndView edit(@PathVariable @ModelAttribute("id") java.lang.String id,
			@ModelAttribute("redirectUrl") String redirectUrl, Model model) {
		ExpectResult expectResult = expectResultBO.get(id);
		model.addAttribute("doType", "edit");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/backend/expectResult/expectResultAction");
		model.addAttribute("expectResult", expectResult);
		return mv;
	}

	/**
	 * 更新ExpectResult
	 * @return
	 */
	@RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
	@ResponseBody
	public String update(ExpectResult expectResult, @PathVariable java.lang.String id, HttpSession session) {
		//expectResult.setUpdatedAt(new java.util.Date());
		//expectResult.setUpdatedBy((String)session.getAttribute("adminId"));
		expectResultBO.update(expectResult, id);
		return "redirect:/backendexpectResult/expectResultManagement";
	}

	/**
	 * 更新ExpectResult
	 * @return
	 */
	@RequestMapping(value = "/updateByName", method = RequestMethod.POST)
	@ResponseBody
	public String updateByName(ExpectResult expectResult, HttpSession session) {
		//expectResult.setUpdatedAt(new java.util.Date());
		//expectResult.setUpdatedBy((String)session.getAttribute("adminId"));
		ExpectResult condition = new ExpectResult();
		condition.setName(expectResult.getName());
		List<ExpectResult> expectResults = expectResultBO.find(condition);
		if(expectResults!=null&&expectResults.size()>0){
			expectResultBO.update(expectResult, expectResults.get(0).getName());
		}
		return "redirect:/backendexpectResult/expectResultManagement";
	}

	/**
	 * 删除ExpectResult
	 * @return
	 */
	@RequestMapping(value = "/{id}/remove", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> remove(@PathVariable java.lang.String id) {
		Map<String, Object> modelMap = new HashMap<>();
		try {
			expectResultBO.remove(id);
			modelMap.put("success", "true");
		} catch (Exception e) {
			modelMap.put("error", "true");
			e.printStackTrace();
		}
		return modelMap;
	}


	/**
	 * 对比ExpectResult
	 */
	@RequestMapping(value = "/compareExpectResult", method = RequestMethod.POST)
	@ResponseBody
	public GeneralResponse compareExpectResult(ExpectResult result, HttpSession session) {
		GeneralResponse response = new GeneralResponse();
		Map<String, Object> modelMap = new HashMap<>();
		try {
			ExpectResult expectResult1 = new ExpectResult();
			expectResult1.setName(result.getName());
			List<ExpectResult> expectResults = expectResultBO.find(expectResult1);
			if (expectResults != null && expectResults.size() > 0) {
				String jsonExpectResult = expectResults.get(0).getJsonresult();
				String jsonResult = result.getJsonresult();
				Boolean isEqual=true;
				CompareResult compareResult = StringUtil.compareJsonResult( jsonExpectResult,  jsonResult,isEqual);
				modelMap.put("compareResult", compareResult);
				response.setData(modelMap);
				response.setCode(0);
				response.setMsg("对比成功");

			} else {
				modelMap.put("result", false);
				modelMap.put("reason", "ExpectResult does not exist!");
				response.setData(modelMap);
				response.setCode(0);
				response.setMsg("对比成功");
			}
		}catch (Exception e){
			modelMap.put("reason", e.toString());
			response.setData(modelMap);
			response.setCode(8);
			response.setMsg("对比失败");
		}
		System.out.println("result:"+modelMap.get("result"));

		return response;
	}
}
