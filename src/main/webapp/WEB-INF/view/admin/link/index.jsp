<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

    <rapid:override name="title">
        - 链接列表
    </rapid:override>
<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/

        .layui-table {
            margin-top: 0;
        }

        .layui-btn {
            margin: 2px 0!important;
        }
    </style>
</rapid:override>

<rapid:override name="content">
    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/SSMBlog/admin/index">首页</a>
              <a><cite>链接列表</cite></a>
        </span>
    </blockquote>

    <table class="layui-table" >
        <colgroup>
            <col width="80">
            <col width=50">
            <col width="100">
            <col width="100">
            <col width="50">
            <col width="70">
            <col width="100">
            <col width="50">
        </colgroup>
        <thead>
        <tr>
            <th>名称</th>
            <th>URL</th>
            <th>联系方式</th>
            <th>创建时间</th>
            <th>Order</th>
            <th>状态</th>
            <th>操作</th>
            <th>ID</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${linkList}" var="l">
            <tr>
                <td>
                    ${l.link_name}
                </td>
                <td >
                    <a href="${l.link_url}" target="_blank">${l.link_url}</a>
                </td>
                <td>
                    ${l.link_owner_contact}
                </td>
                <td>
                      <fmt:formatDate value="${l.link_create_time}" pattern="yyyy年MM月dd日"/>
                </td>
                <td>
                    ${l.link_order}
                </td>
                <td>
                    <c:choose>
                        <c:when test="${l.link_status==1}">
                           已审核
                        </c:when>
                        <c:otherwise>
                            <span style="color:#FF5722;">待审核</span>
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>
                    <a href="/SSMBlog/admin/link/edit/${l.link_id}" class="layui-btn layui-btn-mini">编辑</a>
                    <a href="/SSMBlog/admin/link/delete/${l.link_id}" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                </td>
                <td>${l.link_id}</td>
            </tr>

        </c:forEach>
        </tbody>
    </table>





</rapid:override>
<rapid:override name="footer-script">
    <script>

    </script>
</rapid:override>

<%@ include file="../public/framework.jsp"%>
