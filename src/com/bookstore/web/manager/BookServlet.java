package com.bookstore.web.manager;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.bean.Book;
import com.bookstore.bean.Category;
import com.bookstore.service.BusinessService;
import com.bookstore.service.impl.BusinessServiceImpl;
import com.bookstore.utils.WebUtils;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private BusinessService service = new BusinessServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String method = request.getParameter("method");
		if("addBookUI".equals(method)){
			addBookUI(request,response);
		}
		if("add".equals(method)){
			add(request,response);
		}
		if("getAll".equals(method)){
			getAll(request,response);
		}
	}

	private void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Book> list = service.getAllBook();
		request.setAttribute("list", list);
		request.getRequestDispatcher("/jsp/listbook.jsp").forward(request, response);
	}

	private void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String path="C:\\apache-tomcat-7.0.82\\apache-tomcat-7.0.82\\upload";
			//Book book = WebUtils.upload(request, this.getServletContext().getRealPath("/image"));
			Book book = WebUtils.upload(request, path);
			service.addBook(book);
			request.setAttribute("message", "添加成功！");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "添加失败！");
		}
		request.getRequestDispatcher("/jsp/message.jsp").forward(request, response);
	}

	private void addBookUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Category> categories = service.getAllCategory();
		request.setAttribute("categories", categories);
		request.getRequestDispatcher("/jsp/addBook.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
