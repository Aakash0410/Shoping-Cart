package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import DAO.orderDAO;
import VO.Regvo;
import VO.order_VO;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
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
		int id=(Integer)session.getAttribute("loginID");
		int cardnumber=Integer.parseInt(request.getParameter("cardnumber"));
		Regvo v1=new Regvo();
		v1.setUser_id(id);
		order_VO v=new order_VO();
		v.setCreditcard_number(cardnumber);
		v.setUser_id(v1);
		
		orderDAO dao=new orderDAO();
		List l=dao.search(v);		
		
		
		session.setAttribute("search",l);
		RequestDispatcher rd=request.getRequestDispatcher("displaydetails.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
