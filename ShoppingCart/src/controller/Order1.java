package controller;

import java.io.IOException;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.addressDAO;
import DAO.cardDAO;
import DAO.orderDAO;
import VO.Regvo;
import VO.addressVO;
import VO.cardVO;
import VO.cartItems;
import VO.cartVO;
import VO.lineVO;

import VO.order_VO;
import VO.productVO;

/**
 * Servlet implementation class Order
 */
@WebServlet("/Order1")
public class Order1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Order1() {
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
//		
     	List<cartVO> l=(List) session.getAttribute("search1");
	   
     	int loginid=(Integer)session.getAttribute("loginID");
		
		String address=request.getParameter("address");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String zipcode=request.getParameter("zipcode");
		int cardnumber=Integer.parseInt(request.getParameter("cardnumber"));
		int cvv=Integer.parseInt(request.getParameter("cvv"));
		int exp=Integer.parseInt(request.getParameter("exp"));
		
		
		/*
		*/
		Regvo regvo=new Regvo();
		regvo.setUser_id(loginid);
		addressVO vo=new addressVO();
		vo.setAddress(address);
		vo.setCity(city);
		vo.setState(state);
		vo.setZipcode(zipcode);
		vo.setUser_id(regvo);
		
		addressDAO dao=new addressDAO();
		dao.insert(vo);
		
		System.out.println("Address inserted");
		
		/*cardVO cardvo=new cardVO();
		cardvo.setCardnumber(cardnumber);
		cardvo.setCvv(cvv);
		cardvo.setExpiration_date(exp);
		
		cardDAO carddao=new cardDAO();
		carddao.insert(cardvo);*/
		
		for(int i=0;i<l.size();i++)
		{
			int cart_id=l.get(i).getCart_id();
			System.out.println("###CART_ID"+cart_id);
			Regvo reg=new Regvo();
			reg.setUser_id(loginid);
			cartVO cartvo=new cartVO();
			cartvo.setCart_id(cart_id);
			
			order_VO ordervo=new order_VO();
			ordervo.setCreditcard_number(cardnumber);
			ordervo.setCart_id(cartvo);
			ordervo.setUser_id(reg);
			
			orderDAO orderdao=new orderDAO();
			orderdao.insert(ordervo);
			
		}
     	/*session.setAttribute("flag","updateflag");
		response.sendRedirect("Cart");*/
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/Cart?flag=updateflag");
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
