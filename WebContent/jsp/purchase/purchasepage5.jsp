<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import = "henu.bean.DaoMJB"
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
</head>
<body style="background-image:url(../../img/common/bg.jpg) no-repeat; " >



<%
String purchaseNo = (String)session.getAttribute("purchaseNo");
DaoMJB mjb = (DaoMJB)session.getAttribute("xs");
%>

   <div style="margin-top:2%; margin-left:35%; ">
<form class="pure-form pure-form-aligned" enctype="multipart/form-data" action="../../saleServlet?method=update1&mNo=<%=mjb.getmNo() %>" method="post">
    <fieldset>
        <table style="border-collapse:separate; border-spacing:0px 10px;">
        <tr>
            <td><label for="name">&#12288;&#12288;图片</label> </td>
            <td><input type="file" name="fileName" /> </td>
            <td><span id="tips_file" class="pure-form-message-inline">*请上传一张商品图片</span> </td>
        </tr>
        <tr>
            <td style="align:left"><label for="name">&#12288;商品名&#12288;</label> </td>
            <td><input type="text" name="mname" placeholder="商品名" value=<%=mjb.getMname() %> /> </td>
            <td><span id="tips_mmode" class="pure-form-message-inline">*请输入商品名</span> </td>
        </tr>
        <tr>
            <td><label for="password"> 服用方法</label> </td>
            <td><input name="mmode" type="text" placeholder="服用方法" value=<%=mjb.getMmode() %> /> </td>
            <td><span id = "tips_mmode" class="pure-form-message-inline">*请输入药品服用方法</span></td>
        </tr>
        <tr>
            <td><label for="password">&#12288;&#12288;功效</label> </td>
            <td><input name="mefficacy" type="text" placeholder="功效" value=<%=mjb.getMefficacy() %> /> </td>
            <td><span id = "tips_mefficacy" class="pure-form-message-inline">*请输入药品功效</span></td>
        </tr>    
         <tr>
            <td><label>入货数量</label> </td>
            <td><input name="mstock" type ="text" placeholder="入货数量" value=<%=mjb.getMstock() %> /></td>
            <td><span id = "tips_mstock" class="pure-form-message-inline">*请输入入货数量</span></td>
        </tr>        
         <tr>
            <td><label for="name">&#12288;&#12288;产地</label> </td>
            <td><input name="city" type="text"  placeholder="产地" value=<%=mjb.getMcity() %> /></td>
            <td><span id="tips_city" class="pure-form-message-inline">*请输入药品产地</span> </td>
        </tr>     
        <tr>
            <td><label for="name">&#12288;&#12288;单价</label> </td>
            <td><input name="mprice" type="text"  placeholder="单价" value=<%=mjb.getMprice() %> /></td>
            <td><span id = "tips_mprice" class="pure-form-message-inline">*请输入药品单价</span></td>
        </tr>
        <tr>
            <td><label for="name">&#12288;经销商&#12288;</label> </td>
            <td><input name="name" type="text"  placeholder="经销商" value=<%=mjb.getName() %> /></td>
            <td><span id = "tips_mprice" class="pure-form-message-inline">*请输入经销商名称</span></td>
        </tr>
        <tr></tr>
        <tr></tr>  
        <tr></tr>  
        <tr>
            <td></td>
            <td><input type="submit" class="pure-button pure-button-primary" value="立即保存"/>&nbsp;&nbsp;
            <input type = "reset" class="pure-button pure-button-primary" value = "清除重置" />
            </td>
            <td></td>
        </tr>
        </table>
    </fieldset> 
</form>
</div>

<script src="../../js/ui.js"></script>

</body>
</html>