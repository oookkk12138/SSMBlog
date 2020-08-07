<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

    <rapid:override name="title">
        - 添加链接
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
              <a href="/SSMBlog/admin/link/index">链接列表</a>
              <a><cite>添加链接</cite></a>
        </span>
    </blockquote>
    <div class="layui-row">
        <div class="layui-col-md4">
            <form class="layui-form" method="post" id="myForm" action="/SSMBlog/admin/link/insertSubmit">
                <div class="layui-form-item">
                    <div class="layui-input-block">
                        <strong>编辑链接</strong>
                    </div>
                    <input type="hidden" name="link_id" value="">
                    <div class="layui-input-block">
                        名称 <span style="color: #FF5722; ">*</span>
                        <input type="text" name="link_name" value="" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        URL <span style="color: #FF5722; ">*</span>
                        <input type="text" name="link_url" value="" autocomplete="off" class="layui-input" required>
                    </div>
                    <br>
                    <div class="layui-input-block">
                        联系方式
                        <input type="text" name="link_owner_contact" value="" autocomplete="off" class="layui-input" >
                    </div>
                    <br>
                    <div class="layui-input-block">
                        描述
                        <input type="text" name="link_description" value="" autocomplete="off" class="layui-input" >
                    </div>

                    <br>
                    <div class="layui-input-block">
                         Order
                        <input type="number" name="link_order" value="" autocomplete="off" class="layui-input" min="0" max="10">
                    </div>
                    <br>
                    <div class="layui-input-block">
                                           状态 <br>
                        <input type="radio" name="link_status" value="0" title="待审核">
                        <input type="radio" name="link_status" value="1" title="已通过">
                    </div>
                    <br>
                    <div class="layui-input-block">
                        <button class="layui-btn" lay-filter="formDemo" type="submit">添加</button>
                    </div>
                </div>
            </form>
            <blockquote class="layui-elem-quote layui-quote-nm">
                温馨提示：
                <ul>
                    <li>URL：如 http://101.201.196.73/SSMTmall</li>
                    <li>Order：默认是0，Order越大排名越靠前</li>
                </ul>
            </blockquote>
        </div>
        <div class="layui-col-md8">
            <table class="layui-table" >
                <colgroup>
                    <col width="50">
                    <col width="300">
                    <col width="100">
                    <col width="50">
                    <col width="100">
                </colgroup>
                <thead>
                <tr>
                    <th>id</th>
                    <th>名称</th>
                    <th>URL</th>
                    <th>Order</th>
                    <th>操作</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${linkList}" var="link">

                    <tr>
                        <td>${link.link_id}</td>
                        <td>
                            ${link.link_name}
                        </td>
                        <td>
                             ${link.link_url}
                        </td>
                        <td>
                            ${link.link_order}
                        </td>
                        <td>
                            <a href="/SSMBlog/admin/link/edit/${link.link_id}" class="layui-btn layui-btn-mini">编辑</a>
                            <a href="/SSMBlog/admin/link/delete/${link.link_id}" class="layui-btn layui-btn-danger layui-btn-mini" onclick="return confirmDelete()">删除</a>

                        </td>
                    </tr>

                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>






</rapid:override>
<rapid:override name="footer-script">
    <script>

    </script>
</rapid:override>

<%@ include file="../public/framework.jsp"%>
