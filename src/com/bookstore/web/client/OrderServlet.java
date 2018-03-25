package com.bookstore.web.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Car;
import com.bookstore.bean.User;
import com.bookstore.service.BusinessService;
import com.bookstore.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class OrderServlet
 */
@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService service = new BusinessServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		if("buy".equals(method)){
			Buy(request,response);
		}
		
		if("cancel".equals(method)){
			Cancel(request,response);
		}
		
		
	}

	private void Cancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getSession().setAttribute("car", null);
		request.getRequestDispatcher("/jsp/listcar.jsp").forward(request, response);
	}

	private void Buy(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = (User) request.getSession().getAttribute("user");
		if(user==null){
			request.setAttribute("message", "请先登录！！");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
			return;
		}
		
		try {
			Car car = (Car) request.getSession().getAttribute("car");
			service.saveOrder(car, user);
			request.setAttribute("message", "订单生成成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "订单生成失败！");
		}
		request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
