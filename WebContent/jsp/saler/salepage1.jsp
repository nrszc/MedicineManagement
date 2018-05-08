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
                <li class="pure-menu-item"><a href="../../saleServlet?method=mysale" class="pure-menu-link">我的销售</a></li>

                      
            </ul>
        </div>
    </div>

    <div id="main">
    <p><%=salerNo%>，你好，你已经成功登陆！&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="../../Servlet?method=logout">注销！</a></p>
        <div class="header">
            <h1>欢迎光临</h1>
            <h2>第八天为您服务</h2>
        </div>

        <div class="content">

            <h2 class="content-subhead">Let's go!</h2>
            <p>
第八天医药信息管理系统是集进、销、调、存、以及会员管理的专业药店管理软件，严格按照国家药监局要求,符合国家最新GSP需求的管理软件,操作简单、管理方便。系统采用标准的客户端/服务器架构开发，性能稳定，运行安全。是一款有效的提高企业现代化管理水平，节约药店管理资源的医药行业管理软件.适合于各类连锁药店、批发公司、以及单体医店。本系统引进先进的信息处理技术，提高企业的自动化程度和信息共享度，提高工作效率，降低成本；更重要的可以从根本上改变企业的战略发展，在经营和管理上更上一个台阶。
            </p>

            <div class="pure-g">
                <div class="pure-u-1-4">
                    <img class="pure-img-responsive" src="http://farm3.staticflickr.com/2875/9069037713_1752f5daeb.jpg" alt="Peyto Lake">
                </div>
                <div class="pure-u-1-4">
                    <img class="pure-img-responsive" src="http://farm3.staticflickr.com/2813/9069585985_80da8db54f.jpg" alt="Train">
                </div>
                <div class="pure-u-1-4">
                    <img class="pure-img-responsive" src="http://farm6.staticflickr.com/5456/9121446012_c1640e42d0.jpg" alt="T-Shirt Store">
                </div>
                <div class="pure-u-1-4">
                    <img class="pure-img-responsive" src="http://farm8.staticflickr.com/7357/9086701425_fda3024927.jpg" alt="Mountain">
                </div>
            </div>

        </div>
    </div>
</div>




<script src="../../js/ui.js"></script>

</body>
</html>