package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.apphosting.utils.remoteapi.RemoteApiPb.Request;

import DAO.cartDAO;
import DAO.productDAO;
import VO.Regvo;
import VO.cartItems;
import VO.cartVO;
import VO.lineVO;
import VO.productVO;

/**
 * Servlet implementation class Cart
 */
@WebServlet("/Cart")
public class Cart extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cart() {
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
		
		String flag=request.getParameter("flag");
		System.out.println("flag is"+flag);
		if(flag==null)
		{
			search(request,response);
		}
		if(flag!=null && flag.equals("updateflag"))
		{
			
			updateflag(request,response);
		}
		if(flag!=null && flag.equals("update"))
		{
			update(request,response);
		}
		
		if(flag!=null && flag.equals("insert"))
		{
			insert(request,response);
		}
		
		if(flag!=null && flag.equals("remove"))
		{
			remove(request,response);
		}
		
}
	
	
private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	HttpSession session=request.getSession();
	   int id=(Integer)session.getAttribute("loginID");
	   Regvo vo=new Regvo();
	   vo.setUser_id(id);
	   cartVO cartvo=new cartVO();
	   cartvo.setLogin_id(vo);
	   cartDAO dao=new cartDAO();
	   List l= dao.search(cartvo);
	   session.setAttribute("search1", l);
		RequestDispatcher rd=request.getRequestDispatcher("yourcart.jsp");
		rd.forward(request, response);
	}

private void updateflag(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	   HttpSession session=request.getSession();
	   int id=(Integer)session.getAttribute("loginID");
	   Regvo vo=new Regvo();
	   vo.setUser_id(id);
	   cartVO cartvo=new cartVO();
	   cartDAO dao=new cartDAO();
	   String status="N";
	   cartvo.setLogin_id(vo);
	   cartvo.setActiveflag(status);
	   dao.updateflag(cartvo);
	   response.sendRedirect("thankyou.jsp");
		
	}

/*	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			HttpSession session=request.getSession();
			int loginid=(Integer)session.getAttribute("loginID");
			Regvo vo=new Regvo();
			vo.setUser_id(loginid);
			cartVO v=new cartVO();
			v.setLogin_id(vo);
			cartDAO dao=new cartDAO();
			dao.delete(v);	
			RequestDispatcher rd=request.getRequestDispatcher("thankyou.jsp");
			rd.forward(request, response);
		
	}*/

	private void remove(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		int id=(Integer)session.getAttribute("loginID");
		
       int productId1=Integer.parseInt(request.getParameter("productId"));
      
       Regvo v=new Regvo();
		v.setUser_id(id);
		cartVO v1=new cartVO();
		v1.setCart_id(productId1);
		v1.setLogin_id(v);
		cartDAO cartdao=new cartDAO();
		cartdao.remove(v1);
		List l1=cartdao.search(v1);
		session.setAttribute("search1", l1);
		RequestDispatcher rd=request.getRequestDispatcher("yourcart.jsp");
		rd.forward(request, response);
		
	}

	private void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		int loginId=(Integer)session.getAttribute("loginID");
		int productId=Integer.parseInt(request.getParameter("productId"));
		String quant = request.getParameter("quantity");
		System.out.println(quant);
		System.out.println("Product id is"+productId);
		
		productVO v1=new productVO();
		v1.setProduct_Id(productId);
		
		Regvo regvo=new Regvo();
		regvo.setUser_id(loginId);
		
		productDAO d= new productDAO();
		List<productVO> l=d.display(v1);
		
 
		String name=null;
		int price=0;

		
		
		 for(int i=0;i<l.size();i++)
		 {

	        
	            name=l.get(i).getProduct_Name();
	            price=l.get(i).getProduct_Price();
	           
	     }
		 
		 int quantity;
         try 
         {
             quantity = Integer.parseInt(quant);
             if (quantity < 0) 
             {
                 quantity = 1;
             }
         } catch (NumberFormatException nfe) {
             quantity = 1;
         }
       
		String status="Y";
		cartVO cartvo=new cartVO();
		cartvo.setLogin_id(regvo);
		cartvo.setProduct_id(v1);
		cartvo.setName(name);
		cartvo.setPrice(price);
		cartvo.setQuantity(quantity);
		cartvo.setActiveflag(status);
		
		cartDAO cartdao=new cartDAO();
		cartdao.insert(cartvo);
		
	
		List l1=cartdao.search(cartvo);
		session.setAttribute("search1", l1);
		RequestDispatcher rd=request.getRequestDispatcher("yourcart.jsp");
		rd.forward(request, response);
		
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		HttpSession session=request.getSession();
		System.out.println("You are in update method");
		int productId1=Integer.parseInt(request.getParameter("productId"));
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		int id=(Integer)session.getAttribute("loginID");
		Regvo vo=new Regvo();
		vo.setUser_id(id);
		
		
		productVO v=new productVO();
		v.setProduct_Id(productId1);
		cartVO v1=new cartVO();
		v1.setProduct_id(v);
		v1.setQuantity(quantity);
		v1.setLogin_id(vo);
		
		cartDAO cartdao=new cartDAO();
		cartdao.update(v1);
		
		List l1=cartdao.search(v1);
		session.setAttribute("search1", l1);
		RequestDispatcher rd=request.getRequestDispatcher("yourcart.jsp");
		rd.forward(request, response);
		
		
		
		
		// TODO Auto-generated method stub
		
	}


	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
	}

}
