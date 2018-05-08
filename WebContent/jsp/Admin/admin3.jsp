<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A layout example with a side menu that hides on mobile, just like the Pure website.">
    <title>Responsive Side Menu &ndash; Layout Examples &ndash; Pure</title>
   
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-" crossorigin="anonymous">
    
        <!--[if lte IE 8]>
            <link rel="stylesheet" href="../../css/menu/side-menu-old-ie.css">
        <![endif]-->
        <!--[if gt IE 8]><!-->
            <link rel="stylesheet" href="../../css/menu/side-menu.css">
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
                <li class="pure-menu-item"><a href="admin2.jsp" class="pure-menu-link">添加员工</a></li>
                <li class="menu-item-divided pure-menu-selected"><a href="../../saleServlet?method=findstaff" class="pure-menu-link">查看员工</a></li>
                <li class="pure-menu-item"><a href="admin5.jsp" class="pure-menu-link">添加经销商</a></li>
                <li class="pure-menu-item"><a href="../../saleServlet?method=findagency" class="pure-menu-link">查看经销商</a></li>
            </ul>
        </div>
    </div>

    <div id="main">
    <p><%=adminNo%>，你好，你已经成功登陆！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../Servlet?method=logout">注销！</a></p>
        <div class="header">
            <h1>查看员工</h1>
            <h2>看看我们可爱的员工们</h2>
        </div>
<center>
        <div class="content" style="margin-top:3%; margin-left:4%;">
        <table class="pure-table" style="width:145%;">
    <thead>
        <tr>
            <th>员工号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>用户类型</th>
            <th>手机号码</th>
            <th>电子邮件</th>
            <th>地址</th>
            <th>出生日期</th>
            <th>操作</th>
        </tr>
    </thead>

    <tbody>
  <%
  String sb = (String)session.getAttribute("list5");
  out.print(sb);
  %>
    </tbody>
</table> 
        </div>
        </center> 
    </div>
</div>




<script src="../../js/ui.js"></script>

</body>
</html>