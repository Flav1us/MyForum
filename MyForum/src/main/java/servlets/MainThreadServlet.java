package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ForumPost;
import entity.ForumThread;

/**
 * Servlet implementation class MainThreadServlet
 */
public class MainThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ForumThread mt = new ForumThread();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainThreadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get");
		request.setAttribute("thread", mt);
		getServletContext().getRequestDispatcher("/jsp/mainthread.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8"); теперь в фильтре
		System.out.println("post");
		String new_post = (String) request.getParameter("add_post");
		System.out.println(new_post);
		mt.addPost(new ForumPost(new_post));
		request.setAttribute("thread", mt);
		getServletContext().getRequestDispatcher("/jsp/mainthread.jsp").forward(request, response);
	}

}
