<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/login/login.css">
</head>
<body>
<div>
  <div id="div-ground">
    <form action="Servlet?method=login" method="post">
         <div id="div-login-font">登      录</div>
         <input type="text" name="username" placeholder="UserName" />
         <hr class="hr6" />
         <input type="password" name="password" placeholder="PassWord" />
         <hr class="hr6"/>
         <select name = "usertype" id = "selUser">
         <option>请选择</option>
         <option value = "顾客">顾客</option>
         <option value = "销售人员">销售人员</option>
         <option value = "采购人员">采购人员</option>
         <option value = "管理员">管理员</option>
         </select>
         <br>
         <div id="div-jiange"></div>
         <input id="input-login-button" type="submit" name="login" value="登       录" />
         <hr class="hr6"/>
                还没有注册本系统？
       <a href="register1.jsp">立即注册</a>
    </form>
</div>
</div>
</body>
</html>