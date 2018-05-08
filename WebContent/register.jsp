<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/register/register.css">
</head>
<body>
<form class="smart-green" action="Servlet?method=register" method="post" class="STYLE-NAME">
<h1>Contact Form
<span>Please fill all the texts in the fields.</span>
</h1>
<label>
<span>名字 :</span>
<input name="username" id="txtUser" type="text" placeholder="您的名字" onBlur="return checkName()"></input>
</label>
<label>
<span>密码 :</span>
<input id ="txtPwd" name="password" type = "password" placeholder="您的密码" onBlur="checkPwd()"></input>
</label>
<label>
<span>确认密码 :</span>
<input id = "txtRpt" type = "password" placeholder="再次确认密码" onBlur="return checkRpt()"></input>
</label>
<label>
<br>
性别 :
<input name = "gender" type = "radio" value = "男" onBlur="return checkGender()"/>男
<input name = "gender" type = "radio" value = "女" onBlur="return checkGender()"/>女
<hr/>
</label>
<label>
<span>出生日期:</span>
<input id ="txtDate" name="birthdate" placeholder="出生日期" type = "date" onBlur="return checktxtDate()"/>
</label>
<label>
<span>手机号码:</span>
<input name="phone" type="text" placeholder="手机号码" onBlur="return checkName()"></input>
</label>
<label>
<span>住址:</span>
<input id = "address" name="address" type = "text" placeholder="住址"></input>
</label>
<label>
<span>电子邮件:</span>
<input id = "txtMail" name="email" type = "email" placeholder="电子邮件" onBlur="return checkEmail()"></input>
</label>
<label>
<span>用户类型:</span>
<select name = "usertype" id = "selUser" onBlur="return checkUser()">
   <option>请选择</option>
    <option value = "顾客">顾客</option>
    <option value = "销售人员">销售人员</option>
    <option value = "采购人员">采购人员</option>
   </select>
</label>
<br>
<center>
<label>
<span>&nbsp;</span>
<input type="submit" class="button" value="立即注册" />
</label>
</center>
</form>
</body>
</html>