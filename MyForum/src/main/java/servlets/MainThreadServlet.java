package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ForumPost;
import entity.ForumThread;
import log.Logger;
import storage.Storage;

/**
 * Servlet implementation class MainThreadServlet
 */
public class MainThreadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	static enum Command {
		add_post,
		load_thread,
		save_thread
	}
	
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
		Logger.console("get");
		request.setAttribute("thread", mt);
		getServletContext().getRequestDispatcher("/jsp/mainthread.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.setCharacterEncoding("UTF-8"); теперь в фильтре
		Command comd = parseCommand(request);
		Logger.console("post:\t"+comd);
		switch(comd) {
		case add_post:
			String new_post = (String) request.getParameter("add_post");
			Logger.console("new post:\t"+new_post);
			mt.addPost(new ForumPost(new_post));
			request.setAttribute("thread", mt);
			getServletContext().getRequestDispatcher("/jsp/mainthread.jsp").forward(request, response);
			break;
		case load_thread:
			mt = Storage.loadMainThread();
			request.setAttribute("thread", mt);
			getServletContext().getRequestDispatcher("/jsp/mainthread.jsp").forward(request, response);
			break;
		case save_thread:
			Storage.saveMainThread(mt);
			getServletContext().getRequestDispatcher("/jsp/mainthread.jsp").forward(request, response);
			break;
		default:
			throw new IllegalArgumentException("No such command: " + comd);
		}
	}
	
	private Command parseCommand(HttpServletRequest request) {
		String command = (String) request.getParameter("command");
		switch(command) {
			case "add_post":
				return Command.add_post;
			case "load_thread":
				return Command.load_thread;
			case "save_thread":
				return Command.save_thread;
			default:
				throw new IllegalArgumentException("No such command: " + command);
		}
	}

}
