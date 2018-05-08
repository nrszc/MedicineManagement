<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/check.js"></script>
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

<div style="margin-top:5%; margin-left:35%;">
<form class="pure-form pure-form-aligned" action="Servlet?method=register" method="post">
    <fieldset>
        <table style="border-collapse:separate; border-spacing:0px 10px;">
        <tr>
            <td style="align:left"><label for="name">&#12288;用户名</label> </td>
            <td><input type="text" id="txtUser" name="username" placeholder="用户名" onBlur="return checkName()"> </td>
            <td><span id="tips_username" class="pure-form-message-inline">*用户名由6-18位字符组成</span> </td>
        </tr>
        <tr>
            <td><label for="password"> &#12288;&#12288;密码</label> </td>
            <td><input id = "txtPwd" name="password" type="password" placeholder="密码" onBlur="return checkPwd()"> </td>
            <td><span id = "tips_password" class="pure-form-message-inline">*密码由6-18位字符组成</span></td>
        </tr>
        <tr>
            <td><label for="password">确认密码&#12288;</label> </td>
            <td><input id = "txtRpt" name="txtPW" type="password" placeholder="确认密码" onBlur="return checkRpt()"> </td>
            <td><span id = "tips_repeat" class="pure-form-message-inline">*请再次输入你的密码</span></td>
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
            <td><input id = "txtDate" name="birthdate" type = "date" onBlur="return checktxtDate()"/></td>
            <td><span id = "tips_birthdate" class="pure-form-message-inline">*请选择你的出生日期</span></td>
        </tr>     
         <tr>
            <td><label for="name">手机号码</label> </td>
            <td><input id="phone" name="phone" type="text" placeholder="手机号码" onBlur="return checkPhone()"></input></td>
            <td><span id="tips_phone" class="pure-form-message-inline">*请输入你的11位手机号码</span> </td>
        </tr>     
         <tr>
            <td><label for="name">&#12288;&#12288;住址</label> </td>
            <td><input id = "address" name="address" type = "text" placeholder="住址" onBlur="return checkAddress()"></input></td>
            <td><span id="tips_address" class="pure-form-message-inline">*请输入你的住址</span> </td>
        </tr>     
        <tr>
            <td><label for="name">电子邮件</label> </td>
            <td><input id = "txtMail" name="email" type = "email" placeholder="电子邮件" onBlur="return checkEmail()"></input></td>
            <td><span id = "tips_email" class="pure-form-message-inline">*请填写常用的EMAIL</span></td>
        </tr>
        <tr>
            <td><label>用户类型</label> </td>
            <td><select for="state" name = "usertype" id = "selUser" onBlur="return checkUser()">
                <option >请选择</option>
                <option value = "顾客">顾客</option>
                </select>
            </td>
            <td><span id = "tips_usertype" class="pure-form-message-inline">*请选择用户类型</span></td>
        </tr> 
        <tr></tr>
        <tr></tr>  
        <tr></tr>  
        <tr>
            <td></td>
            <td><input type="submit" class="pure-button pure-button-primary" value="立即注册"/>&nbsp;&nbsp;
            <input type = "reset" class="pure-button pure-button-primary" value = "清除重置" />
            </td>
            <td></td>
        </tr>
        </table>
    </fieldset>
</form>
</div>
</body>
</html>