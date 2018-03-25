package com.bookstore.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class HtmlFilter
 */

public class HtmlFilter implements Filter {

    /**
     * Default constructor. 
     */
    public HtmlFilter() {
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
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse response = (HttpServletResponse)resp;
		MyRequest myrequest = new MyRequest(request);
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	
	class MyRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request;
		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request = request;
			// TODO Auto-generated constructor stub
		}
		@Override
		public String getParameter(String name) {
			// TODO Auto-generated method stub
			String value = request.getParameter(name);
			return filter(value);
		}
		
		   public  String filter(String message) {

		        if (message == null)
		            return (null);

		        char content[] = new char[message.length()];
		        message.getChars(0, message.length(), content, 0);
		        StringBuilder result = new StringBuilder(content.length + 50);
		        for (int i = 0; i < content.length; i++) {
		            switch (content[i]) {
		            case '<':
		                result.append("&lt;");
		                break;
		            case '>':
		                result.append("&gt;");
		                break;
		            case '&':
		                result.append("&amp;");
		                break;
		            case '"':
		                result.append("&quot;");
		                break;
		            default:
		                result.append(content[i]);
		            }
		        }
		        return (result.toString());

		    }
		
		
		
		
	}

}
