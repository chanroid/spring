package com.company.first.common.logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class LoggerInterceptor implements HandlerInterceptor {
	protected Logger log = Logger.getLogger(getClass());

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("================== START ==================");
		if (log.isDebugEnabled()) {
			log.debug("================== START ==================");
			log.debug("Request URL \t: " + request.getRequestURI());
		}
		return false; // true면 다음 interceptor가 있을시 요청이 넘어감
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("================== END ==================");
		if (log.isDebugEnabled()) {
			log.debug("================== END ==================");
			log.debug("Request URL \t: " + request.getRequestURI());
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("================== AFTER COMPLETION ==================");
		if (log.isDebugEnabled()) {
			log.debug("================== AFTER COMPLETION ==================");
			log.debug("Request URL \t: " + request.getRequestURI());
		}
	}
}
