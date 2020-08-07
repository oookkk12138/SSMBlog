<%@ page import="java.security.MessageDigest" %>
<%@ page import="java.security.NoSuchAlgorithmException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 评论列表
</rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/
        .layui-table {
            margin-top: 0;
        }
    </style>
</rapid:override>

<rapid:override name="content">
    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/SSMBlog/admin/index">首页</a>
              <a><cite>评论列表</cite></a>
        </span>
    </blockquote>
    <div class="layui-tab layui-tab-card">
        <table class="layui-table" lay-even lay-skin="nob">
            <colgroup>
                <col width="100">
                <col width="300">
                <col width=200">
                <col width="150">
                <col width="50">
            </colgroup>
            <thead>
            <tr>
                <th>作者</th>
                <th>评论内容</th>
                <th>回复至</th>
                <th>提交于</th>
                <th>ID</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${pageInfo.list}" var="c">
                <tr>
                    <td>
                        <img src="${c.comment_author_avator}" alt="" width="64px">
                        <strong>${c.comment_author_name}</strong>
                        <br>
                            	地址：${c.comment_author_url} <br>
                            	邮箱：${c.comment_author_email} <br>
                            	IP：${c.comment_ip}
                    </td>
                    <td class="dashboard-comment-wrap">
                            ${c.comment_content}
                        <div class="row-actions">
                            <span class="">
                                        <a href="/SSMBlog/admin/comment/edit/${c.comment_id}">编辑</a>
                                     </span>
                                     <!-- javascript:void(0)相当于return false;停止触发a标签的效果 -->
                                     <!-- 若有jstl表达式和js可以使用传参的形式把js分离 -->
                            <span class=""> |
                                        <a href="javascript:void(0)" onclick="deleteComment(${c.comment_id})">删除</a>
                                     </span>
                        </div>
                    </td>
                    <td>
                        <a href="/SSMBlog/home/article/${c.article.article_id}#comment">${c.article.article_title}</a>
                    </td>
                    <td>
                        <fmt:formatDate value="${c.comment_create_time}" pattern="yyyy年MM月dd日 HH:dd:ss"/>
                    </td>
                    <td>${c.comment_id}</td>

                </tr>
            </c:forEach>
            </tbody>

        </table>

        <div id="nav" style="">
            <%@ include file="../public/paging.jsp" %>
        </div>
    </div>


</rapid:override>

<%@ include file="../public/framework.jsp" %>
