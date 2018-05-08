package henu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

import henu.bean.DaoJB;
import henu.bean.DaoMJB;
import henu.bean.DaoOrder;
import henu.dao.IF.DaoIF;
import henu.dao.IF.saleDaoIF;
import henu.factory.DaoFactory;
import sun.misc.BASE64Encoder;

/**
 * Servlet implementation class saleServlet
 */
@WebServlet("/saleServlet")
public class saleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ServletConfig servletconfig; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config)throws ServletException{
    	this.servletconfig = config;
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			myway(request, response);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void myway(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException, NoSuchAlgorithmException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("method");
		if(action.equals("salernews")){
			newsviwe(request, response);
		}
		else if(action.equals("updatesaler")){
			updatesaler(request, response);
		}
		else if(action.equals("mysale"))
			mysale(request, response);
		else if(action.equals("addmedicines"))
			addmedicines(request, response,0);
		else if(action.equals("viewmedicines"))
			viewmedicines(request, response);
		else if(action.equals("delete"))
			delete(request, response);
		else if(action.equals("update"))
			update(request, response);
		else if(action.equals("update1"))
			update1(request, response);
		else if(action.equals("addstaff"))
			addstaff(request, response);
		else if(action.equals("findstaff"))
			findstaff(request, response,0);
		else if(action.equals("deletestaff"))
			deletestaff(request, response);
		else if(action.equals("updatestaff"))
			updatestaff(request, response);
		else if(action.equals("updatestaff1"))
			updatestaff1(request, response);
		else if(action.equals("addagency"))
			addagency(request, response);
		else if(action.equals("findagency"))
			findagency(request, response,0);
		else if(action.equals("deleteagency"))
			deleteagency(request, response);
		else if(action.equals("updateagency"))
			updateagency(request, response);
		else if(action.equals("updateagency1"))
			updateagency1(request, response);
	}

	private void updateagency1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DaoJB jb = new DaoJB();
		
		jb.setUserNo(request.getParameter("name"));
		jb.setUsername(request.getParameter("username"));
		jb.setPhone(request.getParameter("phone"));
		jb.setEmail(request.getParameter("email"));
		jb.setAddress(request.getParameter("address"));
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		boolean result = saler.updateagency(jb);
		PrintWriter out = response.getWriter();
		if(result)
			findagency(request, response,1);
		else
			out.println("<script>alert('修改失败!');history.back();</script>");
	}

	private void updateagency(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		DaoJB jb = saler.updateagency(name);
		request.getSession().setAttribute("jbbb", jb);
		response.sendRedirect("jsp/Admin/admin7.jsp");
	}

	private void deleteagency(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		boolean result = saler.deleteagency(name);
		if(result)
			findagency(request, response,0);																																																																	
	}

	private void findagency(HttpServletRequest request, HttpServletResponse response,int a) throws IOException {
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		String sb = saler.findagency();
		request.getSession().setAttribute("list6", sb);
		PrintWriter out = response.getWriter();
		if(a==1){
			out.println("<script>alert('修改成功!');window.location.href='/MedicineManagement/jsp/Admin/admin6.jsp';</script>");
		    }
		    else
		    out.println("<script>window.location.href='/MedicineManagement/jsp/Admin/admin6.jsp';</script>");
	}

	private void addagency(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DaoJB jb = new DaoJB();
		jb.setUsername(request.getParameter("username"));
		jb.setPhone(request.getParameter("phone"));
		jb.setEmail(request.getParameter("email"));
		jb.setAddress(request.getParameter("address"));
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		boolean result = saler.addagency(jb);
		PrintWriter out = response.getWriter();
		if(result){
			out.println("<script>alert('添加成功!');history.back();</script>");
		}
		else
			out.println("<script>alert('添加失败!');history.back();</script>");
	}

	private void updatestaff1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		DaoJB jb = new DaoJB();
		jb.setUserNo(request.getParameter("staffNo"));
		jb.setUsername(request.getParameter("username"));
		jb.setGender(request.getParameter("gender"));
		jb.setPhone(request.getParameter("phone"));
		jb.setUsertype(request.getParameter("usertype"));
		jb.setBirthdate(request.getParameter("birthdate"));
		jb.setEmail(request.getParameter("email"));
		jb.setAddress(request.getParameter("address"));
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		boolean result = saler.updatestaff(jb);
		if(result)
			findstaff(request, response,1);
	}

	private void updatestaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String staffNo = request.getParameter("staffNo");
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		DaoJB jb = saler.updatestaff(staffNo);
		request.getSession().setAttribute("jbb", jb);
		response.sendRedirect("jsp/Admin/admin4.jsp");
	}

	private void deletestaff(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String staffNo = request.getParameter("staffNo");
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		boolean result = saler.deletestaff(staffNo);
		if(result)
			findstaff(request, response,0);
	}

	private void findstaff(HttpServletRequest request, HttpServletResponse response,int a) throws IOException {
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		String sb = saler.findstaff();
		request.getSession().setAttribute("list5", sb);
		PrintWriter out = response.getWriter();
	    if(a==1){
		out.println("<script>alert('修改成功!');window.location.href='/MedicineManagement/jsp/Admin/admin3.jsp';</script>");
	    }
	    else
	    out.println("<script>window.location.href='/MedicineManagement/jsp/Admin/admin3.jsp';</script>");
	}

	private void addstaff(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
		DaoJB jb = new DaoJB();
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
		saleDaoIF user = DaoFactory.getsalerDaoInstance();
		boolean result = user.addstaff(jb);
		PrintWriter out = response.getWriter();
		if(result){
			out.println("<script>alert('添加成功!');history.back();</script>");
		}
		else
			out.println("<script>alert('添加失败!');history.back();</script>");
	}

	private void update1(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String mNo = request.getParameter("mNo");
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		boolean result = saler.delete(mNo);
		if(result)
			addmedicines(request, response, 1);
	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String mNo = request.getParameter("mNo");
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		DaoMJB mjb = saler.update(mNo);
		request.getSession().setAttribute("xs", mjb);
		response.sendRedirect("jsp/purchase/purchasepage5.jsp");
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws IOException {
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		String mNo = request.getParameter("mNo");
	    boolean result = saler.delete(mNo);
	    if(result)
	    	viewmedicines(request, response);
	}

	private void viewmedicines(HttpServletRequest request, HttpServletResponse response) throws IOException {
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
	    String sb = saler.viewmedicines();
	    request.getSession().setAttribute("list3", sb);
	    PrintWriter out = response.getWriter();
		out.println("<script>window.location.href='/MedicineManagement/jsp/purchase/purchasepage4.jsp';</script>");

	}

	private void addmedicines(HttpServletRequest request, HttpServletResponse response, int a) throws IOException {
		SmartUpload su = new SmartUpload();
		try{
			su.initialize(servletconfig, request, response);
		}catch(ServletException e)
		{
			e.printStackTrace();
		}
		su.setAllowedFilesList("jpg,png");
		su.setMaxFileSize(10*1024*1024);
		su.setTotalMaxFileSize(12*1024*1024);
		try{
			su.upload();
		}catch(ServletException e1)
		{
			e1.printStackTrace();
		}catch(IOException e1)
		{
			e1.printStackTrace();
		}catch(SmartUploadException e1)
		{
			e1.printStackTrace();
		}
		Request req = su.getRequest();
		Files files = su.getFiles();
		File file = files.getFile(0);
		String extFile = file.getFileExt();
		Date curDate = new Date();
		long d = curDate.getTime();
		String mainFile = String.valueOf(d);
		String filename = "/images/" + mainFile + "." + extFile;
		try{
			file.saveAs(filename);
		}catch(IOException e1)
		{
			e1.printStackTrace();
		}
		catch(SmartUploadException e1){
			e1.printStackTrace();
		}
		String mname = req.getParameter("mname");
		String mmode = req.getParameter("mmode");
		String mstock = req.getParameter("mstock");
		String mefficacy = req.getParameter("mefficacy");
		String staffNo = (String)request.getSession().getAttribute("purchaseNo");
		String city = req.getParameter("city");
		String mprice = req.getParameter("mprice");
		String name = req.getParameter("name");
		filename = mainFile + "." + extFile;
		DaoMJB mjb = new DaoMJB();
		mjb.setMname(mname);
		mjb.setMmode(mmode);
		mjb.setMstock(mstock);
		mjb.setStaffNo(staffNo);
		mjb.setMefficacy(mefficacy);
		mjb.setMcity(city);
		mjb.setMprice(mprice);
		mjb.setMimg(filename);
		mjb.setmNo(mainFile);
		mjb.setName(name);
		saleDaoIF g = DaoFactory.getsalerDaoInstance();
	    boolean result = g.addmedicines(mjb);
	    PrintWriter out = response.getWriter();
		if(result)
		{
			if(a==0){
		 		out.println("<script>alert('添加成功!');window.location.href='/MedicineManagement/jsp/purchase/purchasepage3.jsp'</script>");
			}
			else if(a==1){
		 		out.println("<script>alert('修改成功!');</script>");
				viewmedicines(request, response);
			}
		}	
		else
			out.println("<script>alert('添加失败，请确保输入信息正确!');history.back();</script>");
	}

	private void mysale(HttpServletRequest request, HttpServletResponse response) throws IOException {
		 String salerNo = (String)request.getSession().getAttribute("salerNo");
		 saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		 ArrayList<DaoOrder> list = saler.mysale(salerNo);
		 request.getSession().setAttribute("list2", list);
		 response.sendRedirect("jsp/saler/salepage3.jsp");
	}

	private void updatesaler(HttpServletRequest request, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
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
	    String s = (String)request.getSession().getAttribute("salerNo");
	    if(s!=null)
	    jb.setUserNo(s);
	    else
	    {
	    	jb.setUserNo((String)request.getSession().getAttribute("purchaseNo"));
	    }
	    jb.setUsertype(request.getParameter("usertype"));
	    String pwd=base64en.encode(md5.digest(request.getParameter("newpassword").getBytes("utf-8")));
	    jb.setNewpassword(pwd);
	    saleDaoIF saler = DaoFactory.getsalerDaoInstance();
	    jb = saler.updatesaler(jb);
	    PrintWriter out = response.getWriter();
	    if(jb==null)
		    out.println("<script>alert('修改失败，请确保输入信息正确!');history.back();</script>");
	    else{
	    request.getSession().setAttribute("jb", jb);
	    if(s!=null){
	 		out.println("<script>alert('修改成功!');window.location.href='/MedicineManagement/jsp/saler/salepage2.jsp'</script>");
	    }
	    else{
	 		out.println("<script>alert('修改成功!');window.location.href='/MedicineManagement/jsp/purchase/purchasepage2.jsp'</script>");
	    }
	    }
	}

	private void newsviwe(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String salerNo = (String)request.getSession().getAttribute("salerNo");
		String purchaseNo = (String)request.getSession().getAttribute("purchaseNo");
		saleDaoIF saler = DaoFactory.getsalerDaoInstance();
		if(salerNo!=null)
		{
	    DaoJB jb = saler.newsview(salerNo);
	    request.getSession().setAttribute("jb", jb);
	    response.sendRedirect("jsp/saler/salepage2.jsp");
		}
		else 
		{
			DaoJB jb = saler.newsview(purchaseNo);
		    request.getSession().setAttribute("jb", jb);
		    response.sendRedirect("jsp/purchase/purchasepage2.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
