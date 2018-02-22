package controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import VO.Regvo;
import DAO.Regdao;




/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s1=request.getParameter("email");
		String s2=request.getParameter("password");
		
		Regvo vo=new Regvo();
		vo.setEmail(s1);
		
		vo.setPassword(s2);
		
		Regdao d=new Regdao();
		d.insert(vo);
		
		response.sendRedirect("login.jsp");
		
		
		
		
		
	}
	
	
		
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
	}
	
		
		
		
		
		
		
		/*response.sendRedirect("Company/login.jsp");
		
		HttpSession session=request.getSession();
		System.out.println(v.getLogin_Id());
		System.out.println(v1.getRegistration_Id());*/	
		
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
}
