package com.bee.myApp.blog.web.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 单点登录过滤器
 * @author Linfeng
 *
 */
//@WebFilter("/*")
public class SingleSignOnFilter implements Filter {
	private final static Logger logger = LoggerFactory.getLogger(SingleSignOnFilter.class);
	private List<String> excludeUriList = new ArrayList<String>();
    /**
     * Default constructor. 
     */
    public SingleSignOnFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		//获取请求uri
		String uri = request.getRequestURI();
		boolean isContains = this.isContains(uri);
		//对拦截白名单里的uri放行
		if(isContains){
			chain.doFilter(req, res);
			return;
		}
		String tokenParam = request.getParameter("token");
		String tokenHeader = request.getHeader("token");
		String token = StringUtils.isEmpty(tokenParam) ? tokenHeader : tokenParam;
		if(StringUtils.isEmpty(token)){
			//未登录  
			req.getRequestDispatcher("/").forward(req, res);
		}
		String[] tokenInfo = token.split("\\-");
		if(tokenInfo.length != 2){
			//登录信息有误
			req.getRequestDispatcher("/").forward(req, res);
		}
		//TODO
		
		chain.doFilter(request, response);
	}


	public void init(FilterConfig config) throws ServletException {
		//加载配置文件中不需要拦截的uri
		String urisStr = config.getInitParameter("excludeUris");
		logger.info("LoginFilter init parameters:{}",urisStr);
		if(urisStr != null){
			String[] uris = urisStr.split(";");
			for (int i = 0; i < uris.length; i++) {
				excludeUriList.add(uris[i]);
			}
		}
	}
	
	/***
	 * 判断请求的uri是否在拦截白名单里
	 * @param uri
	 * @return boolean
	 */
	private boolean isContains(String uri){
		for (String excludeUri : excludeUriList) {
			if(excludeUri.startsWith(uri)){
				return true;
			}
		}
		return false;
	}

}
