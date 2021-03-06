package a.Package;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		
		//sets the response type and add tools for that
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		// starts up a new bean gets the cookie
		aBean bean=new aBean();
		Cookie[] cookies = request.getCookies();
		bean.setName(name);
		bean.setPassword(password);
		request.setAttribute("bean", bean);
		//reads the cookie and kills it afterwards
		//updates new username & password
		for(Cookie cookie : cookies){
		    bean.update(cookie.getName());
		    cookie.setMaxAge(0);
		    response.addCookie(cookie);
		}
		// Sets new cookie
		Cookie cookie = new Cookie(name, "true");
		cookie.setMaxAge(180);
		response.addCookie(cookie);
		//opens new page with update successful
		RequestDispatcher rd=request.getRequestDispatcher("UpdateSuccess.jsp");
		rd.forward(request, response);
	}

}
