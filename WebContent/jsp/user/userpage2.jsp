<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "henu.bean.DaoJB"
    %>
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
        
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" crossorigin="anonymous">
    
    <!--[if lte IE 8]>
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/grids-responsive-old-ie-min.css">
    <![endif]-->
    <!--[if gt IE 8]><!-->
        <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/grids-responsive-min.css">
    <!--<![endif]-->
    
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Raleway:200">
    
        <!--[if lte IE 8]>
            <link rel="stylesheet" href="/combo/1.18.13?/css/main-grid-old-ie.css&/css/main-old-ie.css&/css/rainbow/baby-blue.css">
        <![endif]-->
        <!--[if gt IE 8]><!-->
            <link rel="stylesheet" href="/combo/1.18.13?/css/main-grid.css&/css/main.css&/css/rainbow/baby-blue.css">
        <!--<![endif]-->

    <!--[if lt IE 9]>
        <script src="http://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7/html5shiv.js"></script>
    <![endif]-->
</head>
<body>
<%
DaoJB jb = new DaoJB();
jb = (DaoJB)session.getAttribute("jb");
String userNo = (String)session.getAttribute("userNo");
%>

<div id="layout">
    <!-- Menu toggle -->
    <a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>

    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="userpage1.jsp">Company</a>

            <ul class="pure-menu-list">
                <li class="menu-item-divided pure-menu-selected"><a href="../../Servlet?method=usernews" class="pure-menu-link">个人信息</a></li>
                <li class="pure-menu-item"><a href="../../Servlet?method=store" class="pure-menu-link">医药商城</a></li>

                <li class="pure-menu-item">
                    <a href="../../Servlet?method=cart" class="pure-menu-link">购物车</a>
                </li>

                <li class="pure-menu-item"><a href="../../Servlet?method=myorder" class="pure-menu-link">我的订单</a></li>
            </ul>
        </div>
    </div>

    <div id="main">
    <p><%=userNo %>，你好，你已经成功登陆！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../Servlet?method=logout">注销！</a></p>
        <div class="header">
            <h1>我的个人信息</h1>
            <h2>你可以看看，也可以修改哦，亲</h2>
        </div>
       <div style="margin-top:2%; margin-left:35%;">
<form class="pure-form pure-form-aligned" action="../../Servlet?method=updateuser" method="post">
    <fieldset>
        <table style="border-collapse:separate; border-spacing:0px 10px;">
        <tr>
            <td style="align:left"><label for="name">&#12288;用户名</label> </td>
            <td><input type="text" id="txtUser" name="username" placeholder="用户名" value=<%=jb.getUsername() %> onBlur="return checkName()"> </td>
            <td><span id="tips_username" class="pure-form-message-inline">*用户名由6-18位字符组成</span> </td>
        </tr>
        <tr>
            <td><label for="password"> &#12288;原密码</label> </td>
            <td><input id = "txtPwd" name="password" type="password" placeholder="原密码" onBlur="return checkPwd()"> </td>
            <td><span id = "tips_password" class="pure-form-message-inline">*请输入你的原密码，密码由6-18位字符组成</span></td>
        </tr>
        <tr>
            <td><label for="password">&#12288;新密码&#12288;</label> </td>
            <td><input id = "newpassword" name="newpassword" type="password" placeholder="新密码" onBlur="return checkNewpassword()"> </td>
            <td><span id = "tips_newpassword" class="pure-form-message-inline">*请输入你的新密码，密码由6-18位字符组成</span></td>
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
            <td><input id = "txtDate" name="birthdate" type = "date" value=<%=jb.getBirthdate() %> onBlur="return checktxtDate()"/></td>
            <td><span id = "tips_birthdate" class="pure-form-message-inline">*请选择你的出生日期</span></td>
        </tr>     
         <tr>
            <td><label for="name">手机号码</label> </td>
            <td><input id="phone" name="phone" type="text" value=<%=jb.getPhone() %> placeholder="手机号码" onBlur="return checkPhone()"></input></td>
            <td><span id="tips_phone" class="pure-form-message-inline">*请输入你的11位手机号码</span> </td>
        </tr>     
         <tr>
            <td><label for="name">&#12288;&#12288;住址</label> </td>
            <td><input id = "address" name="address" type = "text" value=<%=jb.getAddress() %> placeholder="住址" onBlur="return checkAddress()"></input></td>
            <td><span id="tips_address" class="pure-form-message-inline">*请输入你的住址</span> </td>
        </tr>     
        <tr>
            <td><label for="name">电子邮件</label> </td>
            <td><input id = "txtMail" name="email" type="email" value=<%=jb.getEmail() %> placeholder="电子邮件" onBlur="return checkEmail()"></input></td>
            <td><span id = "tips_email" class="pure-form-message-inline">*请填写常用的EMAIL</span></td>
        </tr>
        <tr>
            <td><label for="name">用户类型</label> </td>
            <td><input name="usertype" type="text" value=<%=jb.getUsertype()%> readonly="readonly"></input></td>
            <td><span class="pure-form-message-inline">*不可修改</span></td>
        </tr>
        <tr></tr>
        <tr></tr>  
        <tr></tr>  
        <tr>
            <td></td>
            <td><input type="submit" class="pure-button pure-button-primary" value="立即修改"/>&nbsp;&nbsp;
            <input type = "reset" class="pure-button pure-button-primary" value = "清除重置" />
            </td>
            <td></td>
        </tr>
        </table>
    </fieldset> 
</form>
</div>
</div>




<script src="../../js/ui.js"></script>

</body>
</html>