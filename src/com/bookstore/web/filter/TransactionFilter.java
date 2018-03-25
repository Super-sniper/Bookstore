package com.bookstore.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.bookstore.utils.JdbcUtils;

/**
 * Servlet Filter implementation class TransactionFilter
 */

public class TransactionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TransactionFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		try {
			//拦截下来后：获取连接，开始事务，并把连接绑到当前线程上
			JdbcUtils.startTransaction();
			chain.doFilter(request, response);
			//获取当前线程上绑定的连接：提交事务，并关闭连接，接触当前线程与连接的绑定
			JdbcUtils.commitTransaction();
		} finally {
			JdbcUtils.closeConn();
		}
		
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
