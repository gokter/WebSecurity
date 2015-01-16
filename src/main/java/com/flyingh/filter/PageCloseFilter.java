package com.flyingh.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class PageCloseFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		App.getSemaphore().release();
		System.out.println("current available:" + App.getSemaphore().availablePermits());
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
