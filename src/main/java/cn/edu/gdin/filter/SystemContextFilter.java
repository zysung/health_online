package cn.edu.gdin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import cn.edu.gdin.po.SystemContext;

public class SystemContextFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		int offset = 0;
		try {
			offset = Integer.parseInt(req.getParameter("pager.offset"));
		} catch (NumberFormatException e) {
		}
		try {
			SystemContext.setOffset(offset);
			SystemContext.setSize(6);
			chain.doFilter(req, resp);
		}finally {
			SystemContext.removeOffset();
			SystemContext.removeSize();
		}
	}

	public void init(FilterConfig arg0) throws ServletException {

	}

}
