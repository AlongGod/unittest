package com.unittest.unittest.web;

import com.unittest.unittest.bean.Constant;
import com.unittest.unittest.bean.ResultBean;
import com.unittest.unittest.bo.TestCaseBO;
import com.unittest.unittest.model.TestCase;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by https://www.ixushu.com .
 */
@RestController
@RequestMapping(value="/testCase")
public class TestCaseController{

    @Autowired
    protected TestCaseBO testCaseBO;
    /**
     * 普通TestCase列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation(value="普通TestCase列表", httpMethod = "GET" , notes="普通TestCase列表")
    public ResultBean list(HttpServletRequest request,
                           @ApiParam(required = true, name = "pageNo", value = "第几页")
                           @RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo,
                           @ApiParam(required = true, name = "pageSize", value = "每页显示条数")
                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该TestCase没有查看TestCase列表权限");
        }
        return ResultBean.success(testCaseBO.find(pageSize,pageNo));
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    @ApiOperation(value="TestCase详情", httpMethod = "GET" , notes="TestCase详情")
    public ResultBean detail(HttpServletRequest request, @PathVariable java.lang.String id) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该TestCase没有删除TestCase权限");
        }
        TestCase testCase = testCaseBO.get(id);
        return ResultBean.success(testCase);
    }

    /**
     * 添加TestCase
     * @param request
     * @param response
     * @param testCase
     * @return
     */
    @RequestMapping(value ="/add" , method= RequestMethod.POST)
    @ApiOperation(value="添加TestCase", httpMethod = "POST" , notes="添加TestCase")
    public ResultBean add(HttpServletRequest request, HttpServletResponse response,TestCase testCase) {
        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该TestCase没有添加TestCase权限");
        }
        testCaseBO.insert(testCase);
        return ResultBean.SUCCESS;

    }

    /**
     * 更新TestCase
     * @param request
     * @param response
     * @param testCase
     * @return
     */
    @RequestMapping(value ="/update" , method= RequestMethod.POST)
    @ApiOperation(value="更新TestCase", httpMethod = "POST" , notes="更新TestCase")
    public ResultBean update(HttpServletRequest request, HttpServletResponse response,TestCase testCase) {
        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该TestCase没有更新TestCase权限");
        }
        if(testCaseBO.get(testCase.getId())==null){
            return ResultBean.error("查无此TestCase");
        }else {
            testCaseBO.update(testCase,testCase.getId());
            return ResultBean.SUCCESS;
        }
    }

    /**
     * 删除TestCase
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除TestCase", httpMethod = "DELETE" , notes="删除TestCase")
    public ResultBean delete(HttpServletRequest request, @PathVariable java.lang.String id) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该TestCase没有删除TestCase权限");
        }
        testCaseBO.remove(id);
        return ResultBean.SUCCESS;
    }
}
