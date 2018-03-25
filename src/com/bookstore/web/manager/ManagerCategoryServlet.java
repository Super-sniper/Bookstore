package com.bookstore.web.manager;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Category;
import com.bookstore.service.BusinessService;
import com.bookstore.service.impl.BusinessServiceImpl;
import com.bookstore.utils.WebUtils;

/**
 * Servlet implementation class ManagerCategoryServlet
 */
@WebServlet("/ManagerCategoryServlet")
public class ManagerCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService service = new BusinessServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("add".equals(method)){
			add(request,response);
		}
		if("getAll".equals(method)){
			getAll(request,response);
		}
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> categories = service.getAllCategory();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/jsp/listCategory.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Category category = WebUtils.request2bean(request, Category.class);
			category.setId(UUID.randomUUID().toString());
			service.addCategory(category);
			request.setAttribute("message", "添加成功！！");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "添加失败！！");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
