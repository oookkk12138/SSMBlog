<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <link rel="shortcut icon" href="/SSMBlog/resource/img/logo.png">
    <title>
        SSMBlog后台
            <rapid:block name="title"></rapid:block>
    </title>
    <link rel="stylesheet" href="/SSMBlog/resource/plugin/layui/css/layui.css">
    <link rel="stylesheet" href="/SSMBlog/resource/css/back.css">
    <link rel="stylesheet" href="/SSMBlog/resource/plugin/font-awesome/css/font-awesome.min.css">
    <rapid:block name="header-style"></rapid:block>
    <rapid:block name="header-script"></rapid:block>
</head>
<body>
<div class="layui-layout layui-layout-admin">
    <div class="layui-header">
        <div class="layui-logo"><a href="/SSMBlog/admin/index" style="color:#009688;">
        SSMBlog后台
        </a>
        </div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left">
            <li class="layui-nav-item"><a href="/SSMBlog/home/index">前台</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">新建</a>
                <dl class="layui-nav-child">
                    <dd><a href="/SSMBlog/admin/article/insert">文章</a></dd>
                    <dd><a href="/SSMBlog/admin/page/insert">页面</a></dd>
                    <dd><a href="/SSMBlog/admin/category/index">分类</a></dd>
                    <dd><a href="/SSMBlog/admin/notice/insert">公告</a></dd>
                    <dd><a href="/SSMBlog/admin/link/insert">链接</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="${sessionScope.user.user_avator}" class="layui-nav-img">
                    ${sessionScope.user.user_name}
                </a>
                <dl class="layui-nav-child">
                    <dd><a href="/SSMBlog/admin/user/profile">基本资料</a></dd>
                </dl>
            </li>
            <li class="layui-nav-item">
                <a href="/SSMBlog/admin/user/logout">退出</a>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="test">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;">文章</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/SSMBlog/admin/article/index">全部文章</a></dd>
                        <dd><a href="/SSMBlog/admin/article/insert">写文章</a></dd>
                        <dd><a href="/SSMBlog/admin/category/index">全部分类</a></dd>
                        <dd><a href="/SSMBlog/admin/tag/index">全部标签</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">页面</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/SSMBlog/admin/page/index">全部页面</a></dd>
                        <dd><a href="/SSMBlog/admin/page/insert">添加页面</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        链接
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/SSMBlog/admin/link/index">全部链接</a></dd>
                        <dd><a href="/SSMBlog/admin/link/insert">添加链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">公告</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/SSMBlog/admin/notice/index">全部公告</a></dd>
                        <dd><a href="/SSMBlog/admin/notice/insert">添加公告</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="/SSMBlog/admin/comment/index">
                        评论
                    </a>
                </li>
                <li class="layui-nav-item">
                    <a class="" href="javascript:;">
                        用户
                    </a>
                    <dl class="layui-nav-child">
                        <dd><a href="/SSMBlog/admin/user/index">全部用户</a></dd>
                        <dd><a href="/SSMBlog/admin/user/insert">添加用户</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">设置</a>
                    <dl class="layui-nav-child">
                        <dd><a href="/SSMBlog/admin/menu/index">菜单</a></dd>
                        <dd><a href="/SSMBlog/admin/option/index">主要选项</a></dd>
                    </dl>
                </li>
            </ul>
        </div>
    </div>

    <div class="layui-body">
        <!-- 内容主体区域 -->
        <div style="padding: 15px;">
            <rapid:block name="content">

            </rapid:block>
        </div>
    </div>

    <div class="layui-footer">
        <!-- 底部固定区域 -->
        © <a href="#">SSMBlog</a> 2020  (页脚暂时留空 等待备案号下发)
    </div>
</div>

<script src="/SSMBlog/resource/js/jquery.min.js"></script>
<script src="/SSMBlog/resource/plugin/layui/layui.all.js"></script>
<script src="/SSMBlog/resource/js/back.js"></script>
<rapid:block name="footer-script">

</rapid:block>
<script>
    //给文本编辑器的iframe引入代码高亮的css
    $("iframe").contents().find("head").append("<link rel=\"stylesheet\" href=\"/css/highlight.css\">\n");

</script>

</body>
</html>
