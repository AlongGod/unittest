package com.unittest.unittest.interceptor;

import com.alibaba.fastjson.JSON;
import com.unittest.unittest.bean.ResultBean;
import com.unittest.unittest.util.redis.RedisUtil;
import com.unittest.unittest.util.EncryptUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 登录拦截器
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {


    @Autowired
    private RedisUtil redisUtil;

    //预处理回调方法，实现处理器的预处理（如登录检查）
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String token =request.getHeader("Authorization");
        //String token="ERR15zAv0B1PA64RfD9BTA==";
        if(token!=null){
            String name= EncryptUtil.aesDecrypt(token, EncryptUtil.KEY);
            String toke1=redisUtil.get(name).toString();
            if(token.equals(toke1)){
                request.setAttribute("token",token);
                return true;
            }
        }

        ResultBean resultBean=ResultBean.error("token无效");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(JSON.toJSONString(resultBean));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

        return false;
    }


}
