package controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.loginDAO;

import VO.Regvo;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
	
		Regvo regvo = new Regvo();
		regvo.setEmail(email);
		regvo.setPassword(password);
		
		loginDAO loginDAO = new loginDAO();
		List list =  loginDAO.authentication(regvo);
		
		if(list != null && list.size()==1)
		{
			
			Iterator itr = list.iterator();
			
			//while(itr.hasNext()){
			Regvo user=(Regvo) itr.next();
			
			int y = (Integer)user.getUser_id();
			session.setAttribute("loginID",y);
			
			

			
			ServletContext context= getServletContext();
			RequestDispatcher rd= context.getRequestDispatcher("/product");
			rd.forward(request, response);
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
