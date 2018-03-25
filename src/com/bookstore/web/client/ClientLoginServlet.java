package com.bookstore.web.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.bean.User;
import com.bookstore.service.BusinessService;
import com.bookstore.service.impl.BusinessServiceImpl;

/**
 * Servlet implementation class ClientLoginServlet
 */
@WebServlet("/ClientLoginServlet")
public class ClientLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService  service = new BusinessServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClientLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
			
			String method =  request.getParameter("method");
			if("login".equals(method)){
				login(request,response);
			}
			
			if("logout".equals(method)){
				logout(request,response);
			}
			
			
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			HttpSession session = request.getSession();
			session.setAttribute("user", null);
			request.setAttribute("message", "×¢Ïú³É¹¦£¡");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "×¢ÏúÊ§°Ü£¡");
			request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
		}
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			User user = service.findUser(username, password);
			if(user==null){
				request.setAttribute("message", "ÃÜÂë´íÎó£¡£¡");
				request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
				return;
			}
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			//response.sendRedirect("/BookStore/index.jsp");
			response.sendRedirect(request.getContextPath()+"/Index");
			return;
		
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("message", "µÇÂ¼Ê§°Ü£¡");
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
