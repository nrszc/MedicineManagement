package henu.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import henu.bean.DaoJB;
import henu.bean.DaoMJB;
import henu.bean.DaoOrder;
import henu.dao.IF.saleDaoIF;
import henu.util.DbcpPool;

public class saleDaoImpl implements saleDaoIF{

	@Override
	public DaoJB newsview(String salerNo) {
		String sql = "select * from staffs where staffNo='"+salerNo+"'";
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
			jb.setUsername(rs.getString("staffname"));
			jb.setUserNo(rs.getString("staffNo"));
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
	public DaoJB updatesaler(DaoJB jb) {
		int result = 0 ;
		int count = 0;
		String sql = "select count(*) from staffs where staffNo='"+jb.getUserNo()+"' and password='"+jb.getPassword()+"'";
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
			sql = "update staffs set staffname=?,password=?,gender=?,birthdate=?,"
					+"email=?,phone=?,address=? where staffNo=?";
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
	public ArrayList<DaoOrder> mysale(String salerNo) {
		String sql = "select * from myorder a,medicines b where a.mNo=b.mNo and a.staffNo='"+salerNo+"'";
		ArrayList<DaoOrder> list = new ArrayList<DaoOrder>();
        ResultSet rs = null;
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			DaoOrder order = new DaoOrder();
			order.setUserNo(rs.getString("a.userNo"));
			order.setmNo(rs.getString("b.mNo"));
			order.setNum(rs.getString("a.num"));
			order.setMname(rs.getString("b.mname"));
			order.setPrice(rs.getString("b.mprice"));
			order.setTime(rs.getString("a.ordertime"));
			list.add(order);
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return list;
	}

	@Override
	public boolean addmedicines(DaoMJB mjb) {
		int result = 0;
		int count = 0;
		String sql = "select count(*) from agency where name='"+mjb.getName()+"'";
		ResultSet rs = null;
		try{
			rs = DbcpPool.executeQuery(sql);
			rs.next();
			count = rs.getInt("count(*)");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		if(count==0)
			return false;
		sql = "INSERT INTO medicines(mNo,mname,mmode,"
				+ "mefficacy,mstock,mimg,staffNo,mcity,mprice,name)"
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		try {
			ps.setString(1, mjb.getmNo());
			ps.setString(2, mjb.getMname());
			ps.setString(3, mjb.getMmode());
			ps.setString(4, mjb.getMefficacy());
			ps.setString(5, mjb.getMstock());
			ps.setString(6, mjb.getMimg());
			ps.setString(7, mjb.getStaffNo());
			ps.setString(8, mjb.getMcity());
			ps.setString(9, mjb.getMprice());
			ps.setString(10, mjb.getName());
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
	public String viewmedicines() {
		String sql = "select * from medicines";
        ResultSet rs = null;
        String sb = "";
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			DaoMJB mjb = new DaoMJB();
			mjb.setMcity(rs.getString("mcity"));
			mjb.setMefficacy(rs.getString("mefficacy"));
			mjb.setMmode(rs.getString("mmode"));
			mjb.setMname(rs.getString("mname"));
			mjb.setMstock(rs.getString("mstock"));			
			mjb.setmNo(rs.getString("mNo"));
			mjb.setMprice(rs.getString("mprice"));
			mjb.setName(rs.getString("name"));
			String s=view(mjb);
			sb=sb+s;
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return sb;
	}

	private String view(DaoMJB mjb) {
		StringBuffer sb = new StringBuffer();
		String mNo = "";
		mNo = mjb.getmNo();
		sb.append("<tr><td>");
		sb.append(mNo);
		sb.append("</td><td>");
		sb.append(mjb.getMname());
		sb.append("</td><td>");
		sb.append(mjb.getMmode());
		sb.append("</td><td>");
		sb.append(mjb.getMefficacy());
		sb.append("</td><td>");
		sb.append(mjb.getMstock());
		sb.append("</td><td>");
		sb.append(mjb.getMprice());
		sb.append("</td><td>");
		sb.append(mjb.getMcity());
		sb.append("</td><td>");
		sb.append(mjb.getName());
		sb.append("</td><td>");
		sb.append("<a href = '../../saleServlet?mNo="+mNo+"&method=delete'>删除</a>");
		sb.append("&nbsp;");
		sb.append("<a href = '../../saleServlet?mNo="+mNo+"&method=update'>修改</a>");
		sb.append("</td></tr>");
		return sb.toString();
	}
	
	public boolean delete(String mNo)
	{
		int result = 0;
		String sql = "delete from medicines where mNo='"+mNo+"'";
		result = DbcpPool.executeUpdate(sql);
		if(result>0)
			return true;
		else 
		    return false;
	}

	@Override
	public DaoMJB update(String mNo) {
		String sql = "select * from medicines where mNo='"+mNo+"'";
		ResultSet rs = null;
		DaoMJB mjb = new DaoMJB();
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			mjb.setMcity(rs.getString("mcity"));
			mjb.setMefficacy(rs.getString("mefficacy"));
			mjb.setMmode(rs.getString("mmode"));
			mjb.setMname(rs.getString("mname"));
			mjb.setMstock(rs.getString("mstock"));			
			mjb.setmNo(rs.getString("mNo"));
			mjb.setMprice(rs.getString("mprice"));
			mjb.setName(rs.getString("name"));
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return mjb;
	}

	@Override
	public boolean addstaff(DaoJB jb) {
		String sql = "INSERT INTO staffs(staffname,password,"
				+ "gender,birthdate"
				+ ",email,usertype,phone,address,staffNo) "
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
	public String findstaff() {
		String sql = "select * from staffs";
        ResultSet rs = null;
        String sb = "";
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			DaoJB jb = new DaoJB();
			jb.setAddress(rs.getString("address"));
			jb.setBirthdate(rs.getString("birthdate"));
			jb.setEmail(rs.getString("email"));
			jb.setGender(rs.getString("gender"));
			jb.setPhone(rs.getString("phone"));
			jb.setUserNo(rs.getString("staffNo"));
			jb.setUsername(rs.getString("staffname"));
			jb.setUsertype(rs.getString("usertype"));
			String s=view(jb);
			sb=sb+s;
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return sb;
	}

	private String view(DaoJB jb) {
		StringBuffer sb = new StringBuffer();
		String staffNo = "";
		staffNo = jb.getUserNo();
		sb.append("<tr><td>");
		sb.append(staffNo);
		sb.append("</td><td>");
		sb.append(jb.getUsername());
		sb.append("</td><td>");
		sb.append(jb.getGender());
		sb.append("</td><td>");
		sb.append(jb.getUsertype());
		sb.append("</td><td>");
		sb.append(jb.getPhone());
		sb.append("</td><td>");
		sb.append(jb.getEmail());
		sb.append("</td><td>");
		sb.append(jb.getAddress());
		sb.append("</td><td>");
		sb.append(jb.getBirthdate());
		sb.append("</td><td>");
		sb.append("<a href = '../../saleServlet?staffNo="+staffNo+"&method=deletestaff'>删除</a>");
		sb.append("&nbsp;");
		sb.append("<a href = '../../saleServlet?staffNo="+staffNo+"&method=updatestaff'>修改</a>");
		sb.append("</td></tr>");
		return sb.toString();
	}

	@Override
	public boolean deletestaff(String staffNo) {
		int result = 0;
		String sql = "delete from staffs where staffNo='"+staffNo+"'";
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		if(result>0)
			return true;
		else 
		    return false;
	}

	@Override
	public DaoJB updatestaff(String staffNo) {
		String sql = "select * from staffs where staffNo='"+staffNo+"'";
        ResultSet rs = null;
        DaoJB jb = new DaoJB();
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			jb.setAddress(rs.getString("address"));
			jb.setBirthdate(rs.getString("birthdate"));
			jb.setEmail(rs.getString("email"));
			jb.setGender(rs.getString("gender"));
			jb.setPhone(rs.getString("phone"));
			jb.setUsername(rs.getString("staffname"));
			jb.setUserNo(rs.getString("staffNo"));
			jb.setUsertype(rs.getString("usertype"));
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return jb;
	}

	@Override
	public boolean updatestaff(DaoJB jb) {
		String sql = "update staffs set staffname='"+jb.getUsername()+"',"
				+ "address='"+jb.getAddress()+"',birthdate='"+jb.getBirthdate()+"',"
				+ "email='"+jb.getEmail()+"',gender='"+jb.getGender()+"',"
				+ "phone='"+jb.getPhone()+"' where staffNo='"+jb.getUserNo()+"'";
		int result = 0;
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		if(result>0)
			return true;
		else
			return false;
	}

	@Override
	public boolean addagency(DaoJB jb) {
		String sql = "INSERT INTO agency(name,email,phone,address) "
				+ "VALUES (?,?,?,?)";
		PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
		int result = 0 ;
		try {
			ps.setString(1, jb.getUsername());
			ps.setString(2, jb.getEmail());
			ps.setString(3, jb.getPhone());
			ps.setString(4, jb.getAddress());
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
	public String findagency() {
		String sql = "select * from agency";
        ResultSet rs = null;
        String sb = "";
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			DaoJB jb = new DaoJB();
			jb.setAddress(rs.getString("address"));
			jb.setEmail(rs.getString("email"));
			jb.setPhone(rs.getString("phone"));
			jb.setUsername(rs.getString("name"));
			String s=view1(jb);
			sb=sb+s;
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return sb;
	}

	private String view1(DaoJB jb) {
		StringBuffer sb = new StringBuffer();
		String name = "";
		name = jb.getUsername();
		sb.append("<tr><td>");
		sb.append(name);
		sb.append("</td><td>");
		sb.append(jb.getPhone());
		sb.append("</td><td>");
		sb.append(jb.getEmail());
		sb.append("</td><td>");
		sb.append(jb.getAddress());
		sb.append("</td><td>");
		sb.append("<a href = '../../saleServlet?name="+name+"&method=deleteagency'>删除</a>");
		sb.append("&nbsp;");
		sb.append("<a href = '../../saleServlet?name="+name+"&method=updateagency'>修改</a>");
		sb.append("</td></tr>");
		return sb.toString();
	}

	@Override
	public boolean deleteagency(String name) {
		int result = 0;
		String sql = "delete from agency where name='"+name+"'";
		result = DbcpPool.executeUpdate(sql);
		DbcpPool.close();
		if(result>0)
			return true;
		else 
		    return false;
	}

	@Override
	public DaoJB updateagency(String name) {
		String sql = "select * from agency where name='"+name+"'";
        ResultSet rs = null;
        DaoJB jb = new DaoJB();
		try{
			rs = DbcpPool.executeQuery(sql);
			while(rs.next()){
			jb.setAddress(rs.getString("address"));
			jb.setEmail(rs.getString("email"));
			jb.setPhone(rs.getString("phone"));
			jb.setUsername(rs.getString("name"));
			}
			rs.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		DbcpPool.close();
		return jb;
	}

	@Override
	public boolean updateagency(DaoJB jb) {
		int result = 0;
		String sql = "update agency set name=?,"
				+"email=?,phone=?,address=? where name=?";
	PreparedStatement ps = DbcpPool.executePreparedStatement(sql);
	try {
		ps.setString(1, jb.getUsername());
		ps.setString(2, jb.getEmail());
		ps.setString(3, jb.getPhone());
		ps.setString(4, jb.getAddress());
		ps.setString(5, jb.getUserNo());
		result = ps.executeUpdate();
		ps.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	DbcpPool.close();
	if(result>0)
		return true;
	else
		return false;
	}

}
