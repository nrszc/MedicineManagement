<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import = "henu.bean.DaoMJB"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../../js/check.js"></script>
<link rel="stylesheet" type="text/css" href="../../medicines/details.css"> 
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
<Script Language="javascript">  
 
</Script>  
<style type="text/css">
div dt{
	float:left;
}
div dd{
	margin:0px; float:left;
}
div strong{
	color:red;
}
hr{
    height: 10px;
    border: none;
    margin: 0px;
    padding: 0px;
    width: 100%;
    }
</style>
</head>
<body>
<%
DaoMJB mjb = (DaoMJB)session.getAttribute("details");
%>
<div style="margin-left:25%; margin-top:10%;">
<div style="float:left;">
<a href="details.jsp"><img src="../../images/<%=mjb.getMimg() %>" width="500" height="425" border="1"/></a>
</div>
<form name="form" action="../../Servlet?method=incart&mNo=<%=mjb.getmNo() %>" method="post" > 
<div style="width:250; height:400; float:left; margin-left:3%; margin-top:0%; padding:0%;">  
            <dl>  
                    <dt>商品名:</dt>  
                    <dd>  
                       <span><%=mjb.getMname()%></span>
                    </dd>  
                </dl>  
                <hr/>   
                <dl>  
                    <dt>商城价:</dt>  
                    <dd>   
                        <strong>￥:<%=mjb.getMprice()%>元</strong>  
                            参考价：  
                            <del>￥<%=Float.valueOf(mjb.getMprice())+200%>元</del>  
                    </dd>  
                </dl>  
                <hr/>
                    <dl>  
                        <dt>功效:</dt>  
                        <dd>  
                                <span><%=mjb.getMefficacy()%></span>
                        </dd>  
                    </dl> 
                    <br/>
                    <hr/>
                    <dl>  
                        <dt>产地:</dt>  
                        <dd>  
                                <span><%=mjb.getMcity()%></span>
                        </dd>  
                    </dl> 
                    <br/>
                     <hr/>
                    <dl>  
                        <dt>服用方法:</dt>  
                        <dd>  
                                <span><%=mjb.getMmode()%></span>
                        </dd>  
                    </dl> 
                    <br/>
                    <hr/>
                    <dl>  
                        <dt>库存:</dt>  
                        <dd>  
                                <span><%=mjb.getMstock()%></span>
                        </dd>  
                    </dl>  
                    <br/>
                    <hr/>     
                <div>  
                        <dl>  
                            <dt>购买数量:</dt>  
                            <dd>  
                                <input size="1" id="count" name="count" value="1" maxlength="4" onBlur="return checkCount()" type="text"/>  
                            </dd>  
                            <dd>  
                                件 &nbsp;&nbsp; <span id="tips_count">*商品数量</span>
                            </dd>  
                        </dl>  
                    </div>
                    <br/>
                    <hr/> 
                     <dl>  
                            <dt>销售人员:</dt>  
                            <dd>  
                                <input size="15" name="staff" id="staff" type="text" onBlur="return checkStaff()"/>  
                            </dd>  
                                 
                            <dd>  
                            <span id="tips_staff">*销售人员工号</span>
                            </dd>  
                        </dl>   
                       <br/>
                       <hr/>
             <hr/>
                       <div style="width:50px; height:25px;">
                    <table>
                    <tr><td>
                     <input style ="font-size:25px;" class="pure-button pure-button-primary" type="submit" name="s1" value="立即购买" onclick="return checkCount();checkStaff();" />                        
                     </td><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><td>
                     <input style ="font-size:25px;" class="pure-button pure-button-primary" type="submit" Name="s2" value="加入购物车" onclick="return checkCount();checkStaff();"/>      
                        </td>
                    </table>
                    </div>
             
</div>
</form> 
</div>
</body>
</html>