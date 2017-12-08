package servlet.basic.filter;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.util.*;

@WebFilter(servletNames="log-filter", urlPatterns= {"/*"})
public class LogFilter implements Filter {
	protected FilterConfig config;
	private ServletContext context;
	private String filterName;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws ServletException, IOException {
		HttpServletRequest req = (HttpServletRequest) request;
		context.log(req.getRemoteHost() + " tried to access " + req.getRequestURL() + " on " + new Date() + ". "
				+ "(Reported by " + filterName + ".)");
		chain.doFilter(request, response);
	}

	public void init(FilterConfig config) throws ServletException {
		this.config = config; // In case it is needed by subclass.
		context = config.getServletContext();
		filterName = config.getFilterName();
	}

	public void destroy() {
	}
}
