package com.bookstore.web.client;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Orders;
import com.bookstore.bean.User;
import com.bookstore.service.BusinessService;
import com.bookstore.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class MyOrderServlet
 */
@WebServlet("/MyOrderServlet")
public class MyOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService service = new BusinessServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("find".equals(method)){
			find(request,response);
			
		}
		
		if("listorder".equals(method)){
			listorder(request,response);
		}
		
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Orders order = service.findOrder(id);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/jsp/myorderdetail.jsp").forward(request, response);
	}

	private void listorder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("message", "ÇëÄúÏÈµÇÂ¼£¡£¡");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		List<Orders> list = service.getAllOrder(user.getId());
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/myorder.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
