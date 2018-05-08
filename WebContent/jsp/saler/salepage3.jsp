<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "henu.bean.DaoOrder"
    import = "java.util.ArrayList"
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
ArrayList<DaoOrder> list = new ArrayList<DaoOrder>();
list = (ArrayList<DaoOrder>)session.getAttribute("list2");
String salerNo = (String)session.getAttribute("salerNo");
%>



<div id="layout">
    <!-- Menu toggle -->
    <a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>

    <div id="menu">
        <div class="pure-menu">
            <a class="pure-menu-heading" href="salepage1.jsp">Company</a>

            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="../../saleServlet?method=salernews" class="pure-menu-link">个人信息</a></li>
                <li class="menu-item-divided pure-menu-selected"><a href="../../saleServlet?method=mysale" class="pure-menu-link">我的销售</a></li>
            
            </ul>
        </div>
    </div>

    <div id="main">
    <p><%=salerNo%>，你好，你已经成功登陆！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../Servlet?method=logout">注销！</a></p>
        <div class="header">
            <h1>我的销售</h1>
            <h2>很棒哦，加油</h2>
        </div>
<center>
        <div class="content" style="margin-top:3%;">
        <table class="pure-table">
    <thead>
        <tr>
            <th>商品号</th>
            <th>商品名</th>
            <th>数量</th>
            <th>单价</th>
            <th>总金额</th>
            <th>下单时间</th>
        </tr>
    </thead>

    <tbody>
    <% 
    if(list!=null&&list.size()>0)
    {
        for(int i=0;i<list.size();i++)
        {
       	 DaoOrder order = list.get(i);
       	 Float p = Float.parseFloat(order.getPrice())*Float.parseFloat(order.getNum());
    %>
        <tr>
            <td><%=order.getmNo()%></td>
            <td><%=order.getMname() %></td>
            <td><%=order.getNum() %></td>
            <td><%=order.getPrice() %></td>
            <td><%=p %></td>
            <td><%=order.getTime() %></td>
        </tr>
        <%}} %>
    </tbody>
</table>
        </div>  
        </center>    
    </div>
</div>




<script src="../../js/ui.js"></script>

</body>
</html>