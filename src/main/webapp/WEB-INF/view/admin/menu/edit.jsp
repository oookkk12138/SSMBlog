<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 编辑菜单项目
</rapid:override>

<rapid:override name="header-style">
    <style>
        /*覆盖 layui*/
        .layui-input-block {
            margin:0px 10px;
        }
        .layui-table {
            margin-top: 0;
        }
        .layui-col-md4 {
            padding:10px;
        }
        .layui-col-md8 {
            padding:10px;
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
          <a href="/SSMBlog/admin/menu/index">菜单内容列表</a>
          <a><cite>编辑菜单内容</cite></a>
        </span>
    </blockquote>

    <div class="layui-row">
        <div class="layui-col-md4" >
            <form class="layui-form"  method="post" id="myForm" action="/SSMBlog/admin/menu/editSubmit">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>修改菜单项目</strong>
                    </div>
                    <input type="hidden" name="menu_id" value="${menu.menu_id}">
                    <div class="layui-input-block">
                        名称
                        <span style="color: #FF5722; ">*</span>
                        <input type="text" name="menu_name" value="${menu.menu_name}" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        URL
                        <span style="color: #FF5722; ">*</span>
                        <input type="text" name="menu_url" value="${menu.menu_url}" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        图标
                        <input type="text" name="menu_icon" value="${menu.menu_icon}" layui-input="" class="layui-input"  >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        菜单位置
                        <select name="menu_level" id="">
                            <option value="1" <c:if test="${menu.menu_level==1}">selected</c:if>>顶部菜单</option>
                            <option value="2" <c:if test="${menu.menu_level==2}">selected</c:if> >次级菜单</option>
                        </select>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        Order
                        <input type="number" name="menu_order" value="${menu.menu_order}" layui-input="" class="layui-input" min="0" max="10" required>
                    </div>
                    <br>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">保存</button>
                    </div>
                </div>
            </form>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>1、Order范围为0-10,默认为0</li>
                    <li>2、图标为名称前面的字体图标，可选。采用的是 <a href="http://fontawesome.io/icons/" target="_blank">fontawesome</a>图标</li>
                    <li>3、目前只有两种菜单：顶部菜单和次级菜单</li>
                </ul>
            </blockquote>
        </div>
        <div class="layui-col-md8">

            <div class="layui-tab layui-tab-card">
                <ul class="layui-tab-title">
                    <li class="layui-this">顶部菜单</li>
                    <li>次级菜单</li>
                </ul>
                <div class="layui-tab-content" style="height: auto;">
                    <div class="layui-tab-item layui-show">

                        <table class="layui-table" >
                            <colgroup>
                                <col width="100">
                                <col width="200">
                                <col width="50">
                                <col width="100">
                            </colgroup>
                            <thead>
                            <tr>
                                <th>名称</th>
                                <th>URL</th>
                                <th>Order</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${menuList}" var="m">
                                <c:if test="${m.menu_level==1}">
                                    <tr>
                                        <td>
                                            <i class="${m.menu_icon}"></i>
                                                ${m.menu_name}
                                        </td>
                                        <td>
                                            <a href="${m.menu_url}" target="_blank">${m.menu_url}</a>
                                        </td>
                                        <td>${m.menu_order}</td>
                                        <td>
                                            <a href="/SSMBlog/admin/menu/edit/${m.menu_id}" class="layui-btn layui-btn-mini">编辑</a>
                                            <a href="/SSMBlog/admin/menu/delete/${m.menu_id}" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                    <divx class="layui-tab-item">
                        <table class="layui-table" >
                            <colgroup>
                                <col width="100">
                                <col width="200">
                                <col width="50">
                                <col width="50">
                                <col width="100">
                            </colgroup>
                            <thead>
                            <tr>
                                <th>名称</th>
                                <th>URL</th>
                                <th>Order</th>
                                <th>操作</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${menuList}" var="m">
                                <c:if test="${m.menu_level==2}">
                                    <tr>
                                        <td>
                                            <i class="${m.menu_icon}"></i>
                                                ${m.menu_name}
                                        </td>
                                        <td>
                                            <a href="${m.menu_url}" target="_blank">${m.menu_url}</a>
                                        </td>
                                        <td>${m.menu_order}</td>
                                        <td>
                                            <a href="/SSMBlog/admin/menu/edit/${m.menu_id}" class="layui-btn layui-btn-mini">编辑</a>
                                            <a href="/SSMBlog/admin/menu/delete/${m.menu_id}" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>
                                        </td>
                                    </tr>
                                </c:if>
                            </c:forEach>
                            </tbody>
                        </table>
                    </divx>
                    <br><br><br>
                </div>
            </div>
        </div>
    </div>
</rapid:override>

<rapid:override name="footer-script">
    <script>

    </script>
</rapid:override>

<%@ include file="../public/framework.jsp"%>
