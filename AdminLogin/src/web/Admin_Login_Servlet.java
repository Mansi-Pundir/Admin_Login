package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Admin_Login_Member;
import database.Admin_Login_Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class Admin_Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Admin_Login_Dao loginDao = new Admin_Login_Dao();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Admin_Login_Member loginBean = new Admin_Login_Member();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
		
		if (loginDao.validate(loginBean))
		{
			response.sendRedirect("Admin_Home.jsp");
			
		}
		else 
		{
			//HttpSession session = request.getSession();
			response.sendRedirect("Admin_Login.jsp");
			
		}
		
	}

}
