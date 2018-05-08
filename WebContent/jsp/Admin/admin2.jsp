<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A layout example with a side menu that hides on mobile, just like the Pure website.">
    <title>Responsive Side Menu &ndash; Layout Examples &ndash; Pure</title>
    <script type="text/javascript" src="../../js/check.js"></script>
    
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-" crossorigin="anonymous">
    
    
    
        <!--[if lte IE 8]>
            <link rel="stylesheet" href="../../css/menu/side-menu-old-ie.css">
        <![endif]-->
        <!--[if gt IE 8]><!-->
            <link rel="stylesheet" href="../../css/menu/side-menu.css">
        <!--<![endif]-->
</head>
<body>



<%
String adminNo = (String)session.getAttribute("adminNo");
%>



<div id="layout">
    <!-- Menu toggle -->
    <a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>

    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="purchasepage1.jsp">Company</a>

            <ul class="pure-menu-list">
                <li class="menu-item-divided pure-menu-selected"><a href="admin2.jsp" class="pure-menu-link">添加员工</a></li>
                <li class="pure-menu-item"><a href="../../saleServlet?method=findstaff" class="pure-menu-link">查看员工</a></li>
  <li class="pure-menu-item"><a href="admin5.jsp" class="pure-menu-link">添加经销商</a></li>
                <li class="pure-menu-item"><a href="../../saleServlet?method=findagency" class="pure-menu-link">查看经销商</a></li>
            </ul>
        </div>
    </div>

    <div id="main">
    <p><%=adminNo%>，你好，你已经成功登陆！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../Servlet?method=logout">注销！</a></p>
        <div class="header">
            <h1>添加用户</h1>
            <h2>用户越多公司越强大</h2>
        </div>

        <div class="content">
           <center>
<form class="pure-form pure-form-aligned" action="../../saleServlet?method=addstaff" method="post">
    <fieldset>
        <table style="border-collapse:separate; border-spacing:0px 10px;">
        <tr>
            <td style="align:left"><label for="name">&#12288;用户名</label> </td>
            <td><input type="text" id="username" name="username" placeholder="用户名" onBlur="return checkName()"> </td>
            <td><span id="tips_username" class="pure-form-message-inline">*请输入姓名</span> </td>
        </tr>
        <tr>
            <td><label for="password"> &#12288;&#12288;密码</label> </td>
            <td><input id = "txtPwd" name="password" type="password" placeholder="密码" onBlur="return checkPwd()"> </td>
            <td><span id = "tips_password" class="pure-form-message-inline">*密码由6-18位字符组成</span></td>
        </tr>
        <tr>
            <td><label for="password">确认密码&#12288;</label> </td>
            <td><input id = "txtRpt" name="txtPW" type="password" placeholder="确认密码" onBlur="return checkRpt()"> </td>
            <td><span id = "tips_repeat" class="pure-form-message-inline">*请再次输入你的密码</span></td>
        </tr>    
         <tr>
            <td><label for="option-two">&#12288;&#12288;性别</label> </td>
            <td>
                <input name = "gender" type = "radio" value = "男" onBlur="return checkGender()"/>男
                <input name = "gender" type = "radio" value = "女" onBlur="return checkGender()"/>女
            </td>
            <td><span id = "tips_gender" class="pure-form-message-inline" >*请选择你的性别</span></td>
        </tr>     
         <tr>
            <td><label>出生日期</label> </td>
            <td><input id = "txtDate" name="birthdate" type = "date" onBlur="return checktxtDate()"/></td>
            <td><span id = "tips_birthdate" class="pure-form-message-inline">*请选择你的出生日期</span></td>
        </tr>     
         <tr>
            <td><label for="name">手机号码</label> </td>
            <td><input id="phone" name="phone" type="text" placeholder="手机号码" onBlur="return checkPhone()"></input></td>
            <td><span id="tips_phone" class="pure-form-message-inline">*请输入你的11位手机号码</span> </td>
        </tr>     
         <tr>
            <td><label for="name">&#12288;&#12288;住址</label> </td>
            <td><input id = "address" name="address" type = "text" placeholder="住址" onBlur="return checkAddress()"></input></td>
            <td><span id="tips_address" class="pure-form-message-inline">*请输入你的住址</span> </td>
        </tr>     
        <tr>
            <td><label for="name">电子邮件</label> </td>
            <td><input id = "txtMail" name="email" type = "email" placeholder="电子邮件" onBlur="return checkEmail()"></input></td>
            <td><span id = "tips_email" class="pure-form-message-inline">*请填写常用的EMAIL</span></td>
        </tr>
        <tr>
            <td><label>用户类型</label> </td>
            <td><select for="state" name = "usertype" id = "selUser" onBlur="return checkUser()">
                <option >请选择</option>
                <option value = "销售人员">销售人员</option>
                <option value = "采购人员">采购人员</option>
                </select>
            </td>
            <td><span id = "tips_usertype" class="pure-form-message-inline">*请选择用户类型</span></td>
        </tr> 
        <tr></tr>
        <tr></tr>  
        <tr></tr>  
        <tr>
            <td></td>
            <td><input type="submit" class="pure-button pure-button-primary" value="立即注册"/>&nbsp;&nbsp;
            <input type = "reset" class="pure-button pure-button-primary" value = "清除重置" />
            </td>
            <td></td>
        </tr>
        </table>
    </fieldset>
</form>
</center>
    </div>
</div>




<script src="../../js/ui.js"></script>

</body>
</html>