<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

    <rapid:override name="title">
        - 分类列表
    </rapid:override>
<rapid:override name="header-style">
    <style>
        .layui-input-block {
            margin:0px 10px;
        }
    </style>
</rapid:override>

<rapid:override name="content">


    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
              <a href="/SSMBlog/admin/index">首页</a>
              <a href="/SSMBlog/admin/category/index">分类列表</a>
              <a><cite>编辑分类</cite></a>
        </span>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-md4" >
            <form class="layui-form"  method="post" id="myForm" action="/SSMBlog/admin/category/editSubmit">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>修改分类</strong>
                    </div>
                    <input type="hidden" name="category_id" value="${category.category_id}">
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" name="category_name" value="${category.category_name}" placeholder="" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        父节点 <span style="color: #FF5722; ">*</span>
                        <select name="category_pid" class="layui-input" required>
                            <c:forEach items="${categoryList}" var="c">
                                <c:choose>
                                    <c:when test="${c.category_id==category.category_pid}">
                                        <option value="${c.category_id}" selected>${c.category_name}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <c:if test="${c.category_pid==0}">
                                            <option value="${c.category_id}">${c.category_name}</option>
                                        </c:if>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                            <option value="0" <c:if test="${category.category_pid==0}">selected</c:if> >无</option>
                        </select>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        分类描述
                        <input type="text" name="category_description" value="${category.category_description}"  class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        图标样式
                        <input type="text" name="category_icon" value="${category.category_icon}"class="layui-input" >
                    </div>
                    <br>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">保存</button>
                    </div>
                </div>
            </form>
            <br><br>
        </div>
        <div class="layui-col-md8" >
            <table class="layui-table" >
                <colgroup>
                    <col width="300">
                    <col width="100">
                    <col width="100">
                    <col width="100">
                    <col width="50">
                    <col width="50">
                </colgroup>
                <thead>
                <tr>
                    <th>名称</th>
                    <th>文章数</th>
                    <th>操作</th>
                    <th>ID</th>
                    <th>pid</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${categoryList}" var="c">
                    <c:if test="${c.category_pid==0}">
                        <tr>
                            <td>
                                <a href="/SSMBlog/home/articleListByCategory/${c.category_id}">${c.category_name}</a>
                            </td>
                            <td>
                                <a href="/SSMBlog/home/articleListByCategory/${c.category_id}">${fn:length(c.articleList)}</a>
                            </td>
                            <td>
                                <a href="/SSMBlog/admin/category/edit/${c.category_id}" class="layui-btn layui-btn-mini">编辑</a>
                                <c:if test="${fn:length(c.articleList)==0}">
                                    <a href="/SSMBlog/admin/category/delete/${c.category_id}" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                                </c:if>
                            </td>
                            <td>${c.category_id}</td>
                            <td>${c.category_pid}</td>
                        </tr>
                        <c:forEach items="${categoryList}" var="c2">
                            <c:if test="${c2.category_pid==c.category_id}">
                                <tr>
                                    <td>
                                        <a href="/SSMBlog/home/articleListByCategory/${c2.category_id}">——${c2.category_name}</a>
                                    </td>
                                    <td>
                                        <a href="/SSMBlog/home/articleListByCategory/${c2.category_id}">${fn:length(c2.articleList)}</a>
                                    </td>
                                    <td>
                                        <a href="/SSMBlog/admin/category/edit/${c2.category_id}" class="layui-btn layui-btn-mini">编辑</a>
                                        <c:if test="${fn:length(c2.articleList)==0}">
                                            <a href="/SSMBlog/admin/category/delete/${c2.category_id}" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                                        </c:if>
                                    </td>
                                    <td class="cate-parent">${c2.category_id}</td>
                                    <td>${c2.category_pid}</td>
                                </tr>
                            </c:if>
                        </c:forEach>
                    </c:if>


                </c:forEach>
                </tbody>
            </table>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>分类最多只有两级，一级分类pid=0，二级分类pid=其父节点id</li>
                    <li>如果该分类包含文章，将不可删除</li>
                </ul>
            </blockquote>
        </div>

    </div>






</rapid:override>
<rapid:override name="footer-script">

</rapid:override>

<%@ include file="../public/framework.jsp"%>
