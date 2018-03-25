package com.bookstore.web.manager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Orders;
import com.bookstore.service.BusinessService;
import com.bookstore.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class ManagerOrderServlet
 */
@WebServlet("/ManagerOrderServlet")
public class ManagerOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService service = new BusinessServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManagerOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		if("getAll".equals(method)){
			getAll(request,response);
		}
		if("find".equals(method)){
			find(request,response);
		}
		if("update".equals(method)){
			update(request,response);
		}
		
	
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String id = request.getParameter("id");
			service.updateState(id, true);
			request.setAttribute("message", "发货成功，请及时关注物流状态！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "操作失败！");
		}
		request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
	}

	private void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		Orders order = service.findOrder(id);
		request.setAttribute("order", order);
		request.getRequestDispatcher("/jsp/orderdetail.jsp").forward(request, response);
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String state = request.getParameter("state");
		List list = new ArrayList();
		if("false".equals(state)){
			list = service.getAllOrder(false);
		}else{
			list = service.getAllOrder(true);
		}
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/listorder.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
