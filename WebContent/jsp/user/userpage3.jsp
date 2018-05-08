<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "henu.bean.DaoMJB"
    import = "java.util.ArrayList"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="A layout example with a side menu that hides on mobile, just like the Pure website.">
    <title>Responsive Side Menu &ndash; Layout Examples &ndash; Pure</title>
    <link rel="stylesheet" type="text/css" href="../../medicines/medicineshow.css"> 
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" integrity="sha384-" crossorigin="anonymous">
    
    
    
        <!--[if lte IE 8]>
            <link rel="stylesheet" href="../../css/menu/side-menu-old-ie.css">
        <![endif]-->
        <!--[if gt IE 8]><!-->
            <link rel="stylesheet" href="../../css/menu/side-menu.css">
        <!--<![endif]-->
        <style type="text/css">
        center div{
	      float:left;
	      margin: 10px;
	   }
	   center div dd{
	      margin:0px;
	      font-size:10pt;
	   }
	   center div dd.dd_name
	   {
	      color:blue;
	   }
	   center div dd.dd_city
	   {
	      color:#000;
	   }
	   </style>
</head>
<body>


<%
ArrayList<DaoMJB> list = new ArrayList<DaoMJB>();
list = (ArrayList<DaoMJB>)session.getAttribute("list");
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
                <li class="pure-menu-item"><a href="../../Servlet?method=usernews" class="pure-menu-link">个人信息</a></li>
                <li class="menu-item-divided pure-menu-selected""><a href="../../Servlet?method=store" class="pure-menu-link">医药商城</a></li>

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
            <h1>医药商城</h1>
            <h2>买！买！买！给老子使劲买！</h2>
        </div>

      <center>
    <table width="1000" height="160" cellpadding="0" cellspacing="0" border="0">
      <tr>
        <td>
          
          <!-- 商品循环开始 -->
           <% 
               if(list!=null&&list.size()>0)
               {
	               for(int i=0;i<list.size();i++)
	               {
	                  DaoMJB mjb = list.get(i);
           %>   
          <div>
             <dl>
               <dt>
                 <a href="../../Servlet?method=details&mNo=<%=mjb.getmNo()%>"><img src="../../images/<%=mjb.getMimg()%>" width="300" height="250" border="1"/></a>
               </dt>
               <dd class="dd_name"><%=mjb.getMname() %></dd> 
               <dd class="dd_city">产地:<%=mjb.getMcity()%>&nbsp;&nbsp;价格:￥ <%=mjb.getMprice() %></dd> 
             </dl>
          </div>
          <!-- 商品循环结束 -->
        
          <%
                   }
              } 
          %>
        </td>
      </tr>
    </table>
    </center>
        </div>
    </div>




<script src="../../js/ui.js"></script>

</body>
</html>