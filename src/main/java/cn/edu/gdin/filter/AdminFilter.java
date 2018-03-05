package cn.edu.gdin.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.gdin.po.Admin;

public class AdminFilter implements Filter {

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest hsq = (HttpServletRequest)req;
		Admin a = (Admin)hsq.getSession().getAttribute("loginAdmin");
		if(a==null) {
			
			((HttpServletResponse)resp).sendRedirect(hsq.getContextPath()+"/admin/");
		}
		chain.doFilter(req, resp);

	}
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
