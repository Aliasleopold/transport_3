package com.transport.servlet;

import java.io.IOException;
import java.util.logging.Filter;
import java.util.logging.LogRecord;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharSetFilter implements Filter {
    private String charset;

    public void init(FilterConfig conf) throws ServletException {
        charset = conf.getInitParameter("charset");
        System.out.println("charset:" + charset);
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {
        req.setCharacterEncoding(charset);
        chain.doFilter(req, res);
    }

	public boolean isLoggable(LogRecord arg0) {
		// TODO Auto-generated method stub
		return false;
	}
}
