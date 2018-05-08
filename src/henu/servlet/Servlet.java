package henu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import henu.bean.DaoCart;
import henu.bean.DaoJB;
import henu.bean.DaoMJB;
import henu.bean.DaoOrder;
import henu.dao.IF.DaoIF;
import henu.factory.DaoFactory;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			myway(request, response);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void myway(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("method");
		if(action.equals("register"))
			register(request, response);
		else if(action.equals("login"))
			login(request, response);
		else if(action.equals("usernews"))
			updateuserview(request, response);
		else if(action.equals("updateuser"))
		    updateusernews(request, response);
		else if(action.equals("store"))
			store(request, response);
		else if(action.equals("logout"))
			logout(request, response);
		else if(action.equals("check"))
			check(request, response);
		else if(action.equals("details"))
			details(request, response);
		else if(action.equals("incart")){
			if(request.getParameter("s1")!=null)
			    buy(request, response,0);
			else if(request.getParameter("s2")!=null)
	            incart(request, response);
		}
	    else if(action.equals("cart"))
	    	cart(request, response);
	    else if(action.equals("deletecart"))
	    	deletecart(request, response);
	    else if(action.equals("myorder"))
	    	myorder(request, response);
	    else if(action.equals("buy"))
	    	buy(request, response,1);
	    else if(action.equals("deleteorder"))
	    	delectorder(request, response);
	}
	

	private void delectorder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userNo = (String)request.getSession().getAttribute("userNo");
		String mNo = request.getParameter("mNo");
		DaoIF g = DaoFactory.getUserDaoInstance();
		DaoOrder order = new DaoOrder();
		order.setmNo(mNo);
		order.setUserNo(userNo);
		boolean result = g.deleteorder(order);
		if(result)
			myorder(request, response);
	}

	private void buy(HttpServletRequest request, HttpServletResponse response,int a) throws IOException {
		String mNo = request.getParameter("mNo");
		String staffNo = request.getParameter("staff");
	    String count = request.getParameter("count");
	    System.out.println(count);
	    String userNo = (String)request.getSession().getAttribute("userNo");
	    Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String time = dateFormat.format(now);
	    DaoOrder order = new DaoOrder();
	    order.setmNo(mNo);
	    order.setNum(count);
	    order.setStaffNo(staffNo);
	    order.setUserNo(userNo);
	    order.setTime(time);
		DaoIF g = DaoFactory.getUserDaoInstance();
	    boolean result = g.buy(order);
	    PrintWriter out = response.getWriter();
	    if(result){
	    	if(a==0)
			    out.println("<script>alert('购买成功!');window.location.href='/MedicineManagement/jsp/user/userpage3.jsp'</script>");
	    	else{
	    		out.println("<script>alert('购买成功!');</script>");
	    		cart(request, response);
	    	}
	    }
	    else
			out.println("<script>alert('商品库存为不够,购买失败!');history.back();</script>");
	}

	private void myorder(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 String userNo = (String)request.getSession().getAttribute("userNo");
		    DaoIF g = DaoFactory.getUserDaoInstance();
		    ArrayList<DaoOrder> list = g.myorder(userNo);
			request.getSession().setAttribute("list2", list);
			response.sendRedirect("jsp/user/userpage5.jsp");
	}

	private void deletecart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String userNo = (String)request.getSession().getAttribute("userNo");
		String mNo = request.getParameter("mNo");
		DaoIF g = DaoFactory.getUserDaoInstance();
		DaoCart cart = new DaoCart();
		cart.setmNo(mNo);
		cart.setUserNo(userNo);
		boolean result = g.deletecart(cart);
		if(result)
			cart(request, response);
	}

	private void cart(HttpServletRequest request, HttpServletResponse response) throws IOException {
	    String userNo = (String)request.getSession().getAttribute("userNo");
	    DaoIF g = DaoFactory.getUserDaoInstance();
	    ArrayList<DaoCart> list = g.cartview(userNo);
		request.getSession().setAttribute("list1", list);
		PrintWriter out = response.getWriter();
		out.println("<script>window.location.href='/MedicineManagement/jsp/user/userpage4.jsp'</script>");
	}

	private void incart(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mNo = request.getParameter("mNo");
		String staffNo = request.getParameter("staff");
	    String count = request.getParameter("count");
	    String userNo = (String)request.getSession().getAttribute("userNo");
	    DaoCart cart = new DaoCart();
	    cart.setmNo(mNo);
	    cart.setNum(count);
	    cart.setStaffNo(staffNo);
	    cart.setUserNo(userNo);
		DaoIF g = DaoFactory.getUserDaoInstance();
	    boolean result = g.incart(cart);
	    if(result)
	    {
	    	PrintWriter out = response.getWriter();
	    	out.println("<script>alert('已经加入您的购物车内啦!');window.location.href='/MedicineManagement/jsp/user/userpage3.jsp'</script>");
	    	//response.sendRedirect("jsp/user/userpage3.jsp");
	    }
	}

	private void details(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String mNo = request.getParameter("mNo");
		DaoIF g = DaoFactory.getUserDaoInstance();
		DaoMJB mjb = g.details(mNo);
		request.getSession().setAttribute("details", mjb);
		response.sendRedirect("jsp/user/details.jsp");
	}

	private void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String userNo = (String)request.getSession().getAttribute("userNo");
		String salerNo = (String)request.getSession().getAttribute("salerNo");
		String purchaseNo = (String)request.getSession().getAttribute("purchaseNo");
		String adminNo = (String)request.getSession().getAttribute("adminNo");
		if(userNo!=null)
			response.sendRedirect("jsp/user/userpage1.jsp");
		else if(salerNo!=null)  
			response.sendRedirect("jsp/saler/salepage1.jsp");
		else if(purchaseNo!=null)
			response.sendRedirect("jsp/purchase/purchasepage1.jsp");
		else if(adminNo!=null)
			response.sendRedirect("jsp/Admin/admin1.jsp");
		else
			response.sendRedirect("login.jsp");
	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession().invalidate();  
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>alert('注销成功!');window.location.href='/MedicineManagement/main.html'</script>");
	}


	private void store(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DaoIF user = DaoFactory.getUserDaoInstance();
		ArrayList<DaoMJB> list  = user.store();
		request.getSession().setAttribute("list", list);
		response.sendRedirect("jsp/user/userpage3.jsp");
	}

	//注册
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		DaoJB jb = new DaoJB();
		//生成顾客编号
		Date curDate = new Date();
		long d = curDate.getTime();
		String userNO = String.valueOf(d);
		MessageDigest md5=MessageDigest.getInstance("MD5");
	    BASE64Encoder base64en = new BASE64Encoder();
	    String newstr=base64en.encode(md5.digest(request.getParameter("password").getBytes("utf-8")));
		jb.setUserNo(userNO);
		jb.setUsername(request.getParameter("username"));
		jb.setPassword(newstr);
		jb.setGender(request.getParameter("gender"));
		jb.setPhone(request.getParameter("phone"));
		jb.setUsertype(request.getParameter("usertype"));
		jb.setBirthdate(request.getParameter("birthdate"));
		jb.setEmail(request.getParameter("email"));
		jb.setAddress(request.getParameter("address"));
		
		DaoIF user = DaoFactory.getUserDaoInstance();
		boolean result = user.register(jb);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		if(result)
		{
			out.println("<script>alert('注册成功!');window.location.href='/MedicineManagement/main.html'</script>");
			//RequestDispatcher dispatcher = request.getRequestDispatcher("main.html");
			//dispatcher.forward(request, response);
		}
		else 
		{ 
            out.println("<script>alert('注册失败!');history.back();</script>"); 
		}	
	}
	
	//登录
	public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
		DaoJB jb = new DaoJB();
		MessageDigest md5=MessageDigest.getInstance("MD5");
	    BASE64Encoder base64en = new BASE64Encoder();
	    String newstr=base64en.encode(md5.digest(request.getParameter("password").getBytes("utf-8")));
		jb.setUsername(request.getParameter("username"));
		jb.setPassword(newstr);
		jb.setUsertype(request.getParameter("usertype"));
		
		DaoIF user = DaoFactory.getUserDaoInstance();
		String userNo = user.login(jb);
		if(userNo!=null)
		{
		request.getSession().setMaxInactiveInterval(30*60);
	    if(jb.getUsertype().equals("顾客")){
		request.getSession().setAttribute("userNo", userNo);
		response.sendRedirect("jsp/user/userpage1.jsp");
	    }
	    if(jb.getUsertype().equals("销售人员"))
	    {
	    	request.getSession().setAttribute("salerNo", userNo);
			response.sendRedirect("jsp/saler/salepage1.jsp");
	    }
	    if(jb.getUsertype().equals("采购人员"))
	    {
	    	request.getSession().setAttribute("purchaseNo", userNo);
			response.sendRedirect("jsp/purchase/purchasepage1.jsp");
	    }
	    if(jb.getUsertype().equals("管理员"))
	    {
	    	request.getSession().setAttribute("adminNo", userNo);
			response.sendRedirect("jsp/Admin/admin1.jsp");
	    }
		}
		else 
		{
			response.setContentType("text/html;charset=utf-8");
			PrintWriter   out   =   response.getWriter(); 
            out.println("<script>alert('用户名或密码错误!');history.back();</script>"); 
		}
	}
	
	public void updateuserview(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userNo = (String)request.getSession().getAttribute("userNo");
	    DaoIF user = DaoFactory.getUserDaoInstance();
	    DaoJB jb = user.updateuserview(userNo);
	    request.getSession().setAttribute("jb", jb);
	    response.sendRedirect("jsp/user/userpage2.jsp");
	}
	
	public void updateusernews(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
	    DaoJB jb = new DaoJB();
	    MessageDigest md5=MessageDigest.getInstance("MD5");
	    BASE64Encoder base64en = new BASE64Encoder();
	    String newstr=base64en.encode(md5.digest(request.getParameter("password").getBytes("utf-8")));
	    jb.setAddress(request.getParameter("address"));
	    jb.setBirthdate(request.getParameter("birthdate"));
	    jb.setEmail(request.getParameter("email"));
	    jb.setGender(request.getParameter("gender"));
	    jb.setPassword(newstr);
	    jb.setPhone(request.getParameter("phone"));
	    jb.setUsername(request.getParameter("username"));
	    jb.setUserNo((String)request.getSession().getAttribute("userNo"));
	    jb.setUsertype(request.getParameter("usertype"));
	    String pwd=base64en.encode(md5.digest(request.getParameter("newpassword").getBytes("utf-8")));
	    jb.setNewpassword(pwd);
	    DaoIF user = DaoFactory.getUserDaoInstance();
	    jb = user.updateusernews(jb);
	    PrintWriter out = response.getWriter();
	    if(jb==null)
	    out.println("<script>alert('修改失败，请确保输入信息正确!');history.back();</script>");
	    else{
	    request.getSession().setAttribute("jb", jb);
		out.println("<script>alert('修改成功!');window.location.href='/MedicineManagement/jsp/user/userpage2.jsp'</script>");
	    }
	    
	    //response.sendRedirect("jsp/user/userpage2.jsp");
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
