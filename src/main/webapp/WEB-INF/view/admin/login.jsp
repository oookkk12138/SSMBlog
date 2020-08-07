<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<!--[if IE 8]>
<html xmlns="http://www.w3.org/1999/xhtml" class="ie8" lang="zh-CN">
<![endif]-->
<!--[if !(IE 8) ]><!-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<!--<![endif]-->
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh-CN">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>${options.optionSiteTitle} &lsaquo; 登录</title>
    <link rel="stylesheet" href="/SSMBlog/resource/plugin/font-awesome/css/font-awesome.min.css">
    <link rel="shortcut icon" href="/SSMBlog/resource/img/logo.png">
    <link rel='stylesheet' id='dashicons-css'  href='/SSMBlog/resource/plugin/login/dashicons.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='buttons-css'  href='/SSMBlog/resource/plugin/login/buttons.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='forms-css'  href='/SSMBlog/resource/plugin/login/forms.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='l10n-css'  href='/SSMBlog/resource/plugin/login/l10n.min.css' type='text/css' media='all' />
    <link rel='stylesheet' id='login-css'  href='/SSMBlog/resource/plugin/login/login.min.css' type='text/css' media='all' />
    <style type="text/css">
        body{
            font-family: "Microsoft YaHei", Helvetica, Arial, Lucida Grande, Tahoma, sans-serif;
            background: url(/SSMBlog/resource/img/loginBg.jpg);
            width:100%;
            height:100%;
        }
        .login h1 a {
            background-size: 220px 50px;
            width: 220px;
            height: 50px;
            padding: 0;
            margin: 0 auto 1em;
        }
        .login form {
            background: #fff;
            background: rgba(255, 255, 255, 0.6);
            border-radius: 2px;
            border: 1px solid #fff;
        }
        .login label {
            color: #000;
            font-weight: bold;
        }

        #backtoblog a, #nav a {
            color: #fff !important;
        }

    </style><meta name='robots' content='noindex,follow' />
    <meta name="viewport" content="width=device-width" />
    <style>
        body {
            background-repeat: no-repeat;
            background-size: 100% 100%;
            background-attachment: fixed;
        }
    </style>
</head>
<body class="login login-action-login wp-core-ui  locale-zh-cn">
<div id="login">
    <!-- 读取cookie数据，把之前加到cookie的username和password获取到，记住密码的原理就是这样做的 -->
    <%
         String username = "";
         String password = "";
         //获取当前站点的所有Cookie
         Cookie[] cookies = request.getCookies();
         for (int i = 0; i < cookies.length; i++) {//对cookies中的数据进行遍历，找到用户名、密码的数据
             if ("username".equals(cookies[i].getName())) {
                    username = cookies[i].getValue();
             } else if ("password".equals(cookies[i].getName())) {
                 password = cookies[i].getValue();
             }
         }
     %>
    <form name="loginForm" id="loginForm"  method="post">
        <p>
            <label for="user_login">用户名或电子邮件地址<br />
                <input type="text" name="username" id="user_login" class="input" value="<%=username%>" size="20" required placeholder="测试账号：root" onfocus="this.placeholder=''" onblur="this.placeholder='测试账号：root'"/></label>
        </p>
        <p>
            <label for="user_pass">密码<br />
                <input type="password" name="password" id="user_pass" class="input" value="<%=password%>" size="20" required placeholder="测试密码：admin" onfocus="this.placeholder=''" onblur="this.placeholder='测试密码：admin'"/>
            </label>
        </p>
        <p class="forgetmenot">
        	<!-- 若点击了记住密码则进行cookie处理 -->
        	<label for="rememberme"><input name="rememberme" type="checkbox" id="rememberme" value="rememberme" checked /> 记住密码</label>
        </p>
        <p class="submit">
            <input type="button" name="wp-submit" id="submit-btn" class="button button-primary button-large" value="登录" />
        </p>
    </form>


    <script type="text/javascript">
        function wp_attempt_focus(){
            setTimeout( function(){ try{
                d = document.getElementById('user_login');
                d.focus();
                d.select();
            } catch(e){}
            }, 200);
        }

        wp_attempt_focus();
        if(typeof wpOnload=='function')wpOnload();
    </script>

    <p id="backtoblog"><a href="/SSMBlog/home/index">&larr; 回到前台页面</a></p>

</div>


<div class="clear"></div>

<script src="/SSMBlog/resource/js/jquery.min.js"></script>
<script type="text/javascript">


    <%--登录验证 AJAX--%>
    var userLogin = document.getElementById("user_login");
    var userPass = document.getElementById("user_pass");
    var rememberme = document.getElementById("rememberme");
    var submitBtn = document.getElementById("submit-btn");
    submitBtn.onclick = function(){
    	if(userLogin.value == ''){
    		alert("用户名不能为空");
    	}
    	else if(userPass == ''){
    		alert("密码不能为空");
    	}else{
    		var ajax;
        	try {
                ajax = new XMLHttpRequest();
            } catch (e) {
                ajax = new ActiveXObject("microsoft.xmlhttp");
            }
            ajax.open("post","/SSMBlog/admin/loginVerify", true);
            ajax.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			ajax.send("username=" + userLogin.value + "&password=" + userPass.value + "&rememberme=" + rememberme.checked);
			ajax.onreadystatechange = function () {
                if (ajax.readyState == 4 && ajax.status == 200) {
                    var message = ajax.responseText;
                    if(message == "userName_error"){
                    	alert("用户不存在");
                	}
                    else if(message == "userPassword_error"){
                    	alert("密码错误");
                    }
                    else if(message == "userStatus_error"){
                    	alert("此用户被禁用了")
                    }
                    else{
                		window.location.href =  "/SSMBlog/admin/index";
            		}
        		}
			}
    	}
	}

</script>
</body>
</html>

