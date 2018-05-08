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
        <link rel="stylesheet" href="http://www.17sucai.com/preview/220220/2014-11-11/%E8%B4%AD%E7%89%A9%E8%BD%A6%EF%BC%88%E6%BA%90%E4%BB%A3%E7%A0%81%EF%BC%89ok/css/style.css"/>
    <style type="text/css">
.tb960x90 {display:none!important;display:none}</style>
    
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
ArrayList<DaoOrder> list = new ArrayList<DaoOrder>();
list = (ArrayList<DaoOrder>)session.getAttribute("list2");
String userNo = (String)session.getAttribute("userNo");
%>




<div id="layout">
    <!-- Menu toggle -->
    <a href="#menu" id="menuLink" class="menu-link">
        <!-- Hamburger icon -->
        <span></span>
    </a>

    <div id="menu">
        <div class="pure-menu" style="font-size:17.6px;">
            <a class="pure-menu-heading" href="userpage1.jsp" style="text-decoration:none;">Company</a>

            <ul class="pure-menu-list">
                <li class="pure-menu-item"><a href="../../Servlet?method=usernews" class="pure-menu-link" style="text-decoration:none;">个人信息</a></li>
                <li class="pure-menu-item"><a href="../../Servlet?method=store" class="pure-menu-link" style="text-decoration:none;">医药商城</a></li>

                <li class="pure-menu-item">
                    <a href="../../Servlet?method=cart" class="pure-menu-link" style="text-decoration:none;">购物车</a>
                </li>

                <li class="menu-item-divided pure-menu-selected"><a href="../../Servlet?method=myorder" class="pure-menu-link" style="text-decoration:none;">我的订单</a></li>
            </ul>
        </div>
    </div>

    <div id="main"><br/>
     <p style="font-size:16px;"><%=userNo %>，你好，你已经成功登陆！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../Servlet?method=logout">注销！</a></p>
        <div class="header">
            <h1>我的购物车</h1>
            <br>
            <br>
            <h2>要懂得爱惜自己，做真正的自己</h2>
            <br>
            <br>
        </div>

        <div class="content" style="margin-top:3%;">
            <div class="catbox">

	<table id="cartTable">
		<thead>
			<tr>
				<th>商品详情</th>
				<th>下单时间</th>
				<th>单价</th>
				<th>数量</th>
				<th>小计</th>
				<th>操作</th>
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
				<td class="goods"><img src="../../images/<%=order.getMimg() %>" alt=""/><span><%=order.getMname() %></span></td>
				<td class="price"><%=order.getTime() %></td>
				<td class="price"><%=order.getPrice() %></td>
				<td class="count"><span><%=order.getNum() %></span></td>
				<td class="subtotal"><%=p %></td>
				<td class="operation"><span class="delete"><a href="../../Servlet?method=deleteorder&mNo=<%=order.getmNo()%>">删除</a></span>
				</td>
			</tr>
		<%
             }
         }
		%>
		</tbody>
	</table>
</div>
        </div>
    </div>
</div>




<script src="../../js/ui.js"></script>

</body>
</html>