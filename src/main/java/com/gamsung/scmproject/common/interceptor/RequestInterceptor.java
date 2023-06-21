package com.gamsung.scmproject.common.interceptor;

import com.gamsung.scmproject.common.constant.ModelObjectKey;
import com.gamsung.scmproject.common.constant.SessionKeys;
import com.gamsung.scmproject.member.vo.LoginResultVo;
import com.gamsung.scmproject.member.vo.MemberForSessionVo;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class RequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("========================== interceptor =========================");
        HttpSession session = request.getSession();
        MemberForSessionVo loginInfo = (MemberForSessionVo) session.getAttribute(SessionKeys.LOGIN_ID_INFO);
        if(loginInfo == null){
            log.info("no login session");
            response.sendRedirect("/login");
            return false;
        } else {
            log.info("login session exist");
            log.info("{} : {} {}",loginInfo.getId(),loginInfo.getDepartment(), loginInfo.getName());
//            log.info("{}",loginInfo.toString());
            return true;
        }
//        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
