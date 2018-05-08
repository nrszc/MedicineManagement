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
</head>
<body>



<%
DaoJB jb = (DaoJB)session.getAttribute("jbb");
%>

   <div style="margin-top:2%; margin-left:35%; ">
<form class="pure-form pure-form-aligned" action="../../saleServlet?method=updatestaff1" method="post">
    <fieldset>
        <table style="border-collapse:separate; border-spacing:0px 10px;">
        <tr>
            <td><label for="name">&#12288;员工号</label> </td>
            <td><input type="text" name="staffNo" value=<%=jb.getUserNo() %> readonly="readonly" /> </td>
            <td><span id="tips_staffNo" class="pure-form-message-inline">*员工号不可修改</span> </td>
        </tr>
        <tr>
            <td style="align:left"><label for="name">&#12288;用户名</label> </td>
            <td><input type="text" id="txtUser" name="username" value=<%=jb.getUsername() %> onBlur="return checkName()"> </td>
            <td><span id="tips_username" class="pure-form-message-inline">*用户名由6-18位字符组成</span> </td>
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
            <td><input id = "txtDate" name="birthdate" value=<%=jb.getBirthdate() %> type = "date" onBlur="return checktxtDate()"/></td>
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
            <td><input id = "txtMail" name="email" type = "email" value=<%=jb.getEmail() %> placeholder="电子邮件" onBlur="return checkEmail()"></input></td>
            <td><span id = "tips_email" class="pure-form-message-inline">*请填写常用的EMAIL</span></td>
        </tr>
        <tr>
            <td><label for="name">用户类型</label> </td>
            <td><input name="usertype" type="text" value=<%=jb.getUsertype() %> readonly="readonly" /></td>
            <td><span id = "tips_usertype" class="pure-form-message-inline">*用户类型不可修改</span></td>
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