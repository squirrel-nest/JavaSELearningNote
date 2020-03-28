/**
 * <p>Title:电信资源动态管理系统</p>
 * <p>Description:汉字过滤器</p>
 * <p>Copyright: Fujian Fujitsu Communication Software Co., Ltd. Copyright (c)2006</p>
 * <p>Company:福建富士通信息软件有限公司</p>
 * @date 2006-04-20
 * @author licm
 * @version 1.0
 */
package com.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

public class ContextSecurityFilter implements Filter {

	public static final String module = ContextSecurityFilter.class.getName();

	public FilterConfig config;

	public void init(FilterConfig config) {
		this.config = config;
	}

	public void setFilterConfig(FilterConfig config) {
		this.config = config;
	}

	public FilterConfig getFilterConfig() {
		return config;
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletResponse res = (HttpServletResponse) response;
		try {
			// set no cache
			res.setHeader("Cache-Control", "max-age=0");
			res.setHeader("Cache-Control", "no-cache");
			res.setHeader("Cache-Control", "no-store");
			res.setDateHeader("Expires", 0);
			res.setHeader("Pragma", "no-cache");

			// set the encoding
			String encode = config.getInitParameter("encoding");
			encode = encode == null || "".equals(encode) ? "GBK" : encode;
			request.setCharacterEncoding(encode);
			response.setContentType("text/html; charset=" + encode);
			if (chain != null && response != null) chain.doFilter(request, res);
		} catch (ServletException sx) {
			config.getServletContext().log(sx.getMessage());
		} catch (IOException iox) {
			config.getServletContext().log(iox.getMessage());
		}
	}

	public void destroy() {
		config = null;
	}

}
