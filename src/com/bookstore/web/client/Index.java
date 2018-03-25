package com.bookstore.web.client;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.PageBean;
import com.bookstore.bean.QueryInfo;
import com.bookstore.service.BusinessService;
import com.bookstore.service.impl.BusinessServiceImpl;
import com.bookstore.utils.WebUtils;

/**
 * Servlet implementation class Index
 */
@WebServlet("/Index")
public class Index extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private BusinessService service = new BusinessServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Index() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List categories  = service.getAllCategory();
		QueryInfo info = WebUtils.request2bean(request, QueryInfo.class);
		String tb_category_id = request.getParameter("category_id");
		if(tb_category_id!=null&&(!tb_category_id.trim().equals(""))){
			info.setQueryName("tb_category_id");
			info.setQueryvalue(tb_category_id);
		}
		
		PageBean pagebean = service.pageQuery(info);
		request.setAttribute("pagebean", pagebean);
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
