package com.example.springbootwebadmin.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登錄檢查
 * 1. 配置好攔截器要攔截哪些請求
 * 2. 把這些配置放在容器中
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目標方法執行之前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object loginUser = session.getAttribute("loginUser");
        if(loginUser != null){
            //放行
            return true;
        }
        //攔截住。未登錄，跳轉到登錄頁
        request.setAttribute("msg","請先登錄");
        request.getRequestDispatcher("/").forward(request,response);

        return false;
    }

    /**
     * 目標方法執行之後
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
