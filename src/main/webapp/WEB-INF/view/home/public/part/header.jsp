<%--
    博客顶部部分
    包括：顶部菜单，主要菜单(包括搜索按钮)，面包屑
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<%--导航 start--%>
<header id="masthead" class="site-header">
    <%--顶部菜单 start--%>
    <nav id="top-header">
        <div class="top-nav">
            <div class="user-login">
                <c:choose>
                    <c:when test="${sessionScope.user==null}">
                        	欢迎光临！&nbsp;&nbsp;&nbsp;&nbsp;<a href="/SSMBlog/home/user/login"><i class="fa fa-smile-o" aria-hidden="true">&nbsp;</i>登录</a>
                    </c:when>
                    <c:otherwise>
                        	欢迎：<span style="color:red;">${user.user_name}</span>&nbsp;&nbsp;<a href="/SSMBlog/home/user/logout">退出登录</a>
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="menu-topmenu-container">
                <ul id="menu-topmenu" class="top-menu">
                    <c:forEach items="${staticMenuList}" var="m">
                        <li class="menu-item">
                        <c:if test="${m.menu_level==1}">
                                <a href="${m.menu_url}" class="menuUrl">
                                    <i class="${m.menu_icon}"></i>
                                    <span class="font-text">${m.menu_name}&nbsp;</span>&nbsp;
                                </a>
                            </c:if>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </nav><!-- #top-header -->
    <%--顶部菜单 end--%>

    <%--主要菜单 satrt--%>
    <div id="menu-box">
        <div id="top-menu">
                <span class="nav-search">
                    <i class="fa fa-search"></i>
                </span>
            <div class="logo-site"><h1 class="site-title">
                <a href="/SSMBlog/home/index" title="${staticOption.option_site_title}">${staticOption.option_site_title}</a>
            </h1>
                <p class="site-description">${staticOption.option_site_description}</p>
            </div><!-- .logo-site -->
            <div id="site-nav-wrap">
                <div id="sidr-close">
                    <a href="#sidr-close" class="toggle-sidr-close">×</a>
                </div>
                <nav id="site-nav" class="main-nav">
                    <a href="#sidr-main" id="navigation-toggle" class="bars">
                        <i class="fa fa-bars"></i>
                    </a>
                    <div class="menu-pcmenu-container">
                        <ul id="menu-pcmenu" class="down-menu nav-menu sf-js-enabled sf-arrows">

                            <li>
                                <a href="/SSMBlog/home/index">
                                    <i class="fa-home fa"></i>
                                    <span class="font-text">首页</span>
                                </a>
                            </li>

                            <c:forEach items="${staticCategoryList}" var="category">
                                <c:if test="${category.category_pid==0}">
                                    <li>
                                        <a href="" onclick="alert('请选择二级分类  一级分类不进行跳转')">
                                            <i class="${category.category_icon}"></i>
                                            <span class="font-text">${category.category_name}&nbsp;</span>
                                        </a>
                                        <ul class="sub-menu">
                                            <c:forEach items="${staticCategoryList}" var="cate">
                                            	<!-- pid等于id时则证明是这个分类的二级分类 -->
                                                <c:if test="${cate.category_pid==category.category_id}">
                                                    <li>
                                                        <a href="/SSMBlog/home/articleListByCategory/${cate.category_id}">${cate.category_name}</a>
                                                    </li>
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                    </li>
                                </c:if>
                            </c:forEach>
                            <%--主要菜单其余部分--%>
                            <c:forEach items="${staticMenuList}" var="m">
                                <c:if test="${m.menu_level == 2}">
                                    <li>
                                        <a href="${m.menu_url}">
                                            <i class="${m.menu_icon}"></i>
                                            <span class="font-text">${m.menu_name}&nbsp;</span>
                                        </a>
                                    </li>
                                </c:if>
                            </c:forEach>
                        </ul>
                    </div>
                </nav>
            </div>
            <div class="clear"></div>
        </div><!-- #top-menu -->
    </div><!-- #menu-box -->
    <%--主要菜单 satrt--%>

</header><!-- #masthead -->
<%--导航 end start--%>

<%--搜索框 start--%>
<div id="search-main">
    <div class="searchbar">
        <form method="get" id="searchform" action="/SSMBlog/home/article/search" accept-charset="UTF-8">
            <span>
                <input type="text" value="" name="keywords" id="s" placeholder="输入搜索内容"required="">
                <button type="submit" id="searchsubmit">搜索</button>
            </span>
        </form>
    </div>
    <div class="clear"></div>
</div>
<%--搜索框 end--%>

<rapid:block name="breadcrumb"></rapid:block>

<!-- 点击关于本站弹出提示信息 -->
<script>
	var menuUrls = document.getElementsByClassName("menuUrl");
	for(var i = 0;i < menuUrls.length;i++){
		//判断此连接是‘关于本站’的连接则进行判断是否进行跳转
		if(menuUrls[i].href == "https://liuyanzhao.com/6347.html"){
			menuUrls[i].setAttribute("href","#");
			menuUrls[i].onclick = function(){
				var isSure = confirm("此博客参照【言曌博客】开源项目\n点击确认进行跳转，点击取消留在本页面。");
				if(isSure){
					window.open("https://liuyanzhao.com/6347.html");
				}
			}
		}
	}
</script>
