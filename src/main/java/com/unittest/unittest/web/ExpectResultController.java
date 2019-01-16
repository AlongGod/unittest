package com.unittest.unittest.web;

import com.unittest.unittest.bean.Constant;
import com.unittest.unittest.bean.ResultBean;
import com.unittest.unittest.bo.ExpectResultBO;
import com.unittest.unittest.model.ExpectResult;
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
@RequestMapping(value="/expectResult")
public class ExpectResultController{

    @Autowired
    protected ExpectResultBO expectResultBO;
    /**
     * 普通ExpectResult列表
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ApiOperation(value="普通ExpectResult列表", httpMethod = "GET" , notes="普通ExpectResult列表")
    public ResultBean list(HttpServletRequest request,
                           @ApiParam(required = true, name = "pageNo", value = "第几页")
                           @RequestParam(defaultValue = "1", value = "pageNo") Integer pageNo,
                           @ApiParam(required = true, name = "pageSize", value = "每页显示条数")
                           @RequestParam(defaultValue = "10", value = "pageSize") Integer pageSize) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该ExpectResult没有查看ExpectResult列表权限");
        }
        return ResultBean.success(expectResultBO.find(pageSize,pageNo));
    }

    @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
    @ApiOperation(value="ExpectResult详情", httpMethod = "GET" , notes="ExpectResult详情")
    public ResultBean detail(HttpServletRequest request, @PathVariable java.lang.String id) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该ExpectResult没有删除ExpectResult权限");
        }
        ExpectResult expectResult = expectResultBO.get(id);
        return ResultBean.success(expectResult);
    }

    /**
     * 添加ExpectResult
     * @param request
     * @param response
     * @param expectResult
     * @return
     */
    @RequestMapping(value ="/add" , method= RequestMethod.POST)
    @ApiOperation(value="添加ExpectResult", httpMethod = "POST" , notes="添加ExpectResult")
    public ResultBean add(HttpServletRequest request, HttpServletResponse response,ExpectResult expectResult) {
        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该ExpectResult没有添加ExpectResult权限");
        }
        expectResultBO.insert(expectResult);
        return ResultBean.SUCCESS;

    }

    /**
     * 更新ExpectResult
     * @param request
     * @param response
     * @param expectResult
     * @return
     */
    @RequestMapping(value ="/update" , method= RequestMethod.POST)
    @ApiOperation(value="更新ExpectResult", httpMethod = "POST" , notes="更新ExpectResult")
    public ResultBean update(HttpServletRequest request, HttpServletResponse response,ExpectResult expectResult) {
        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该ExpectResult没有更新ExpectResult权限");
        }
        if(expectResultBO.get(expectResult.getId())==null){
            return ResultBean.error("查无此ExpectResult");
        }else {
            expectResultBO.update(expectResult,expectResult.getId());
            return ResultBean.SUCCESS;
        }
    }

    /**
     * 删除ExpectResult
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除ExpectResult", httpMethod = "DELETE" , notes="删除ExpectResult")
    public ResultBean delete(HttpServletRequest request, @PathVariable java.lang.String id) throws Exception {

        if(Constant.USER_TYPE_SPECIAL!=(int)request.getAttribute("type")){
            throw new HttpMessageNotReadableException("该ExpectResult没有删除ExpectResult权限");
        }
        expectResultBO.remove(id);
        return ResultBean.SUCCESS;
    }
}
