<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
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
</head>
<body>



<%
String purchaseNo = (String)session.getAttribute("purchaseNo");
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
                <li class="pure-menu-item"><a href="../../saleServlet?method=salernews" class="pure-menu-link">个人信息</a></li>
                <li class="pure-menu-item"><a href="purchasepage3.jsp" class="pure-menu-link">添加商品</a></li>

                <li class="menu-item-divided pure-menu-selected">
                    <a href="../../saleServlet?method=viewmedicines" class="pure-menu-link">查看商品</a>
                </li>
            
            </ul>
        </div>
    </div>

    <div id="main">
    <p><%=purchaseNo%>，你好，你已经成功登陆！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../Servlet?method=logout">注销！</a></p>
        <div class="header">
            <h1>查看商品</h1>
            <h2>全都在这里，可修改可删除</h2>
        </div>
        <div class="content" style="margin:3% 0% 0% 0%; padding:0% 0% 0% 0%;">
        
     
        <table class="pure-table" style="width:145%; margin-left:15%;">
    <thead>
        <tr>
            <th>商品号</th>
            <th>商品名</th>
            <th>服用方法</th>
            <th>功效</th>
            <th>库存</th>
            <th>单价</th>
            <th>产地</th>
            <th>经销商</th>
            <th>操作</th>
        </tr>
    </thead>

    <tbody>
  <%
  String sb = (String)session.getAttribute("list3");
  out.print(sb);
  %>
    </tbody>
</table>

        </div>  
    </div>
</div>




<script src="../../js/ui.js"></script>

</body>
</html>