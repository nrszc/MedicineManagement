package henu.dao.impl;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import henu.bean.DaoCart;
import henu.bean.DaoJB;
import henu.bean.DaoMJB;
import henu.bean.DaoOrder;
import henu.dao.IF.DaoIF;
import henu.factory.DaoFactory;
import henu.util.DbcpPool;

public class DaoImpl implements DaoIF{

	@Override
	public boolean register(DaoJB jb) {
		String sql = "INSERT INTO users (username,password,"
				+ "gender,birthdate"
				+ ",email,usertype,phone,address,userNo) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, jb.getUsername());
			ps.setString(2, jb.getPassword());
			ps.setString(3, jb.getGender());
			ps.setString(4, jb.getBirthdate());
			ps.setString(5, jb.getEmail());
			ps.setString(6, jb.getUsertype());
			ps.setString(7, jb.getPhone());
			ps.setString(8, jb.getAddress());
			ps.setString(9, jb.getUserNo());
			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		if(result>0)
		return true;
		else 
		return false;
	}

	@Override
	public String login(DaoJB jb) {
		boolean result = false;
		String username = jb.getUsername();
		String password = jb.getPassword();
		String usertype = jb.getUsertype();
		String sql=null;
		if(usertype.equals("顾客"))
		   sql = "select password, userNo from users "
				+ "where usertype='"+usertype+"' and username='"+username+"'";
		else if(usertype.equals("销售人员")||usertype.equals("采购人员")||usertype.equals("管理员"))
			sql = "select password, staffNo from staffs "
					+ "where usertype='"+usertype+"' and staffname='"+username+"'";
		ResultSet rs = DbcpPool.executeQuery(sql);
		String name=null;
		String userNo=null;
		try {
			if(usertype.equals("顾客")){
			if(rs.next())
			name = rs.getString("password");
		    userNo = rs.getString("userNo");
			}
			else if(usertype.equals("销售人员")||usertype.equals("采购人员")||usertype.equals("管理员")){
				if(rs.next())
					name = rs.getString("password");
				    userNo = rs.getString("staffNo");
			}
				
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		DbcpPool.close();
		if(password.equals(name))
		{
		   result = true;
		}
		if(result)
			return userNo;
		return null;
	}

	@Override
	public DaoJB updateuserview(String userNo) {
		// TODO Auto-generated method stub
		String sql = "select * from users where userNo='"+userNo+"'";
		DaoJB jb = new DaoJB();
        ResultSet rs = null;
		try{
			rs = DbcpPool.executeQuery(sql);
			rs.next();
			jb.setAddress(rs.getString("address"));
			jb.setBirthdate(rs.getString("birthdate"));
			jb.setEmail(rs.getString("email"));
			jb.setGender(rs.getString("gender"));
			jb.setPassword(rs.getString("password"));
			jb.setPhone(rs.getString("phone"));
			jb.setUsername(rs.getString("username"));
			jb.setUserNo(rs.getString("userNo"));
			jb.setUsertype(rs.getString("usertype"));
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return jb;
	}

	@Override
	public DaoJB updateusernews(DaoJB jb) {
		int result = 0 ;
		int count = 0;
		String sql = "select count(*) from users where userNo='"+jb.getUserNo()+"' and password='"+jb.getPassword()+"'";
		ResultSet rs = null;
		try{
			rs = DbcpPool.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(count>0){
			sql = "update users set username=?,password=?,gender=?,birthdate=?,"
					+"email=?,phone=?,address=? where userNo=?";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		try {
			ps.setString(1, jb.getUsername());
			ps.setString(2, jb.getNewpassword());
			ps.setString(3, jb.getGender());
			ps.setString(4, jb.getBirthdate());
			ps.setString(5, jb.getEmail());
			ps.setString(6, jb.getPhone());
			ps.setString(7, jb.getAddress());
			ps.setString(8, jb.getUserNo());
			result = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		DbcpPool.close();
		if(result>0)
		return jb;
		else 
		return jb;
		}
		return null;
	}

	@Override
	public ArrayList<DaoMJB> store() {
		 ArrayList<DaoMJB> list = new ArrayList<DaoMJB>();
		 String sql = "select * from medicines";
		 ResultSet rs = null;
		 try{
			 rs = DbcpPool.executeQuery(sql);
			 while(rs.next())
			 {
				 DaoMJB mjb = new DaoMJB();
				 mjb.setMefficacy(rs.getString("mefficacy"));
				 mjb.setMimg(rs.getString("mimg"));
				 mjb.setMmode(rs.getString("mmode"));
				 mjb.setMname(rs.getString("mname"));
				 mjb.setmNo(rs.getString("mNo"));
				 mjb.setMstock(rs.getString("mstock"));
				 mjb.setStaffNo(rs.getString("staffNo"));
				 mjb.setMcity(rs.getString("mcity"));
				 mjb.setMprice(rs.getString("mprice"));
				 list.add(mjb);
			 }
			 rs.close();
		     DbcpPool.close();
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		return list;
	}

	@Override
	public DaoMJB details(String mNo) {
		 String sql = "select * from medicines where mNo='"+mNo+"'";
		 ResultSet rs = null;
		 DaoMJB mjb = new DaoMJB();
		 try{
			 rs = DbcpPool.executeQuery(sql);
			 while(rs.next())
			 {
				 mjb.setMefficacy(rs.getString("mefficacy"));
				 mjb.setMimg(rs.getString("mimg"));
				 mjb.setMmode(rs.getString("mmode"));
				 mjb.setMname(rs.getString("mname"));
				 mjb.setmNo(rs.getString("mNo"));
				 mjb.setMstock(rs.getString("mstock"));
				 mjb.setStaffNo(rs.getString("staffNo"));
				 mjb.setMcity(rs.getString("mcity"));
				 mjb.setMprice(rs.getString("mprice"));	 
			 }
			 rs.close();
		     DbcpPool.close();
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		return mjb;
	}

	@Override
	public boolean incart(DaoCart cart) {
		String sql1 = "select count(mNo),num from cart where userNo='"+cart.getUserNo()+"' and mNo='"+cart.getmNo()+"'";
		ResultSet rs = null;
		int num = 0;
		int count = 0;
		 try{
			 rs = DbcpPool.executeQuery(sql1);	
			 rs.next(); 
			 count = rs.getInt("count(mNo)");
			 num = rs.getInt("num");
			 rs.close();
		     DbcpPool.close();
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		 if(count!=0)
		 {
			 num = num + Integer.parseInt(cart.getNum());
			 String sql2 = "update cart set num='"+num+"' where userNo='"+cart.getUserNo()+"' and mNo='"+cart.getmNo()+"'";
			 int result = DbcpPool.executeUpdate(sql2);
				if(result>0)
					return true;
				else 
				    return false;
		 }
		 else{
		String sql = "insert into cart(userNo,mNo,staffNo,num) values(?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result1 = 0;
		try{
			ps.setString(1, cart.getUserNo());
			ps.setString(2, cart.getmNo());
			ps.setString(3, cart.getStaffNo());
			ps.setString(4, cart.getNum());
			result1 = ps.executeUpdate();
			ps.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		if(result1>0)
			return true;
		else
		    return false;}
	}

	@Override
	public ArrayList<DaoCart> cartview(String userNo) {
		String sql = "select * from cart a,medicines b where a.mNo=b.mNo and a.userNo='"+userNo+"'";
		ArrayList<DaoCart> list = new ArrayList<DaoCart>();
		ResultSet rs = null;
		 try{
			 rs = DbcpPool.executeQuery(sql);
				
			 while(rs.next())
			 {
				 DaoCart cart = new DaoCart();
				 cart.setUserNo(rs.getString("a.userNo"));
				 cart.setmNo(rs.getString("a.mNo"));
				 cart.setMname(rs.getString("b.mname"));
				 cart.setNum(rs.getString("a.num"));
				 cart.setPrice(rs.getString("b.mprice"));
				 cart.setStaffNo(rs.getString("a.staffNo"));
				 cart.setMimg(rs.getString("b.mimg"));
				 list.add(cart);
			 }
			 rs.close();
		     DbcpPool.close();
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		return list;
	}

	@Override
	public boolean deletecart(DaoCart cart) {
		int result = 0;
		String sql = "delete from cart where userNo='"+cart.getUserNo()+"' and mNo='"+cart.getmNo()+"'";
		result = DbcpPool.executeUpdate(sql);
		if(result>0)
			return true;
		else 
		    return false;
	}

	@Override
	public ArrayList<DaoOrder> myorder(String userNo) {
		String sql = "select * from myorder a,medicines b where a.mNo=b.mNo and a.userNo='"+userNo+"'";
		ArrayList<DaoOrder> list = new ArrayList<DaoOrder>();
		ResultSet rs = null;
		 try{
			 rs = DbcpPool.executeQuery(sql);	
			 while(rs.next())
			 {
				 DaoOrder order = new DaoOrder();
				 order.setUserNo(rs.getString("a.userNo"));
				 order.setmNo(rs.getString("a.mNo"));
				 order.setMname(rs.getString("b.mname"));
				 order.setNum(rs.getString("a.num"));
				 order.setPrice(rs.getString("b.mprice"));
				 order.setStaffNo(rs.getString("a.staffNo"));
				 order.setMimg(rs.getString("b.mimg"));
				 order.setTime(rs.getString("a.ordertime"));
				 list.add(order);
			 }
			 rs.close();
		     DbcpPool.close();
		 }catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		return list;
	}

	@Override
	public boolean buy(DaoOrder order) {
		String sql2 = "select mstock from medicines where mNo='"+order.getmNo()+"'";
		ResultSet rs1 = null;
		int num = 0;
		try{
			rs1 = DbcpPool.executeQuery(sql2);
			while(rs1.next()){
				num = Integer.parseInt(rs1.getString("mstock"));
				if(num==0)
					return false;
			}
		}
		catch(SQLException e)
		 {
			 e.printStackTrace();
		 }
		
		String sql = "insert into myorder(userNo,mNo,staffNo,num,ordertime) values(?,?,?,?,?)";
		if(order.getNum()==null&&order.getStaffNo()==null)
		{
			String sql1 = "select * from cart where mNo='"+order.getmNo()+"' and userNo='"+order.getUserNo()+"'";
			ResultSet rs = null;
			try{
				 rs = DbcpPool.executeQuery(sql1);	
				 while(rs.next())
				 {
					 order.setStaffNo(rs.getString("staffNo"));
					 order.setNum(rs.getString("num"));
				 }
				 rs.close();
			     DbcpPool.close();
			 }catch(SQLException e)
			 {
				 e.printStackTrace();
			 }
		}
			int n = num - Integer.parseInt(order.getNum());
			String sql3 = "update medicines set mstock='"+n+"' where mNo = '"+order.getmNo()+"'";
			int re = DbcpPool.executeUpdate(sql3);
			if(re<0)
				return false;
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0;
		try{
			ps.setString(1, order.getUserNo());
			ps.setString(2, order.getmNo());
			ps.setString(3, order.getStaffNo());
			ps.setString(4, order.getNum());
			ps.setString(5, order.getTime());
			result = ps.executeUpdate();
			ps.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		DaoCart cart = new DaoCart();
		cart.setmNo(order.getmNo());
		cart.setUserNo(order.getUserNo());
		deletecart(cart);
		
		if(result>0)
			return true;
		else
		    return false;
	}

	@Override
	public boolean deleteorder(DaoOrder order) {
		int result = 0;
		String sql = "delete from myorder where userNo='"+order.getUserNo()+"' and mNo='"+order.getmNo()+"'";
		result = DbcpPool.executeUpdate(sql);
		if(result>0)
			return true;
		else 
		    return false;
	}

}
