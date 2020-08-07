<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    - 编辑用户
</rapid:override>
<rapid:override name="header-style">
    <style>
        .layui-form-item .layui-input-inline {
            width: 300px;
        }
        .layui-form-label {
            width: 120px;
        }
        .layui-word-aux {
            color: #FF5722 !important;
        }
    </style>
</rapid:override>

<rapid:override name="content">

    <blockquote class="layui-elem-quote">
         <span class="layui-breadcrumb" lay-separator="/">
              <a href="/SSMBlog/admin/index">首页</a>
              <a href="/SSMBlog/admin/user/index">用户列表</a>
              <a><cite>编辑用户</cite></a>
        </span>
    </blockquote>
    <br><br>
    <form class="layui-form" action="/SSMBlog/admin/user/editSubmit" id="userForm"
          method="post">
        <input type="hidden" name="user_id" id="userId" value="${user.user_id}">
        <div class="layui-form-item">
            <label class="layui-form-label">头像</label>
            <div class="layui-input-inline">
                <div class="layui-upload">
                    <div class="layui-upload-list" style="">
                        <img class="layui-upload-img" src="${user.user_avator}" id="demo1" width="100"
                             height="100">
                        <p id="demoText"></p>
                    </div>
                    <button type="button" class="layui-btn" id="test1">上传图片</button>
                    <input type="hidden" name="user_avator" id="userAvatar" value="${user.user_avator}">
                </div>
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">用户名 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" value="${user.user_name}" name="user_name" id="userName" required
                       lay-verify="userName"
                       autocomplete="off" class="layui-input" onblur="checkUserName()">
            </div>
            <div class="layui-form-mid layui-word-aux" id="userNameTips"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">密码 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="password" name="user_password" value="${user.user_password}" id="userPass" required
                       autocomplete="off" class="layui-input" min="3" max="20">
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">昵称 <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="text" name="user_nickname" value="${user.user_nickname}" required
                       placeholder="" autocomplete="off" min="2" max="10"
                       class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">Email <span style="color: #FF5722; ">*</span></label>
            <div class="layui-input-inline">
                <input type="email" name="user_email" value="${user.user_email}" id="userEmail" required
                       lay-verify="userEmail"
                       class="layui-input" onblur="checkUserEmail()">
            </div>
            <div class="layui-form-mid layui-word-aux" id="userEmailTips"></div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">URL </label>
            <div class="layui-input-inline">
                <input type="url" name="user_url" value="${user.user_url}" placeholder="" autocomplete="off"
                       class="layui-input">
            </div>
        </div>
        <div class="layui-form-item">
            <label class="layui-form-label">状态</label>
            <div class="layui-input-block">
                <input type="radio" name="user_status" value="1" title="正常" <c:if test="${user.user_status==1}">checked</c:if>>
                <input type="radio" name="user_status" value="0" title="禁用" <c:if test="${user.user_status==0}">checked</c:if>>
            </div>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="demo1" id="submit-btn">保存</button>
                <!-- type为reset时能够把表单的数据都重置，上传的图片无法重置 -->
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>


</rapid:override>
<rapid:override name="footer-script">

    <script>
        //上传图片
        layui.use('upload', function () {
            var $ = layui.jquery,
                upload = layui.upload;
            var uploadInst = upload.render({
            	//绑定元素
                elem: '#test1',
                //限制上传的文件格式只能是jpg和png
                ext:'jpg|png',
              	//对应的controller(返回值必须是json格式，并且包含code，msg，data这三项数据)
                url: '/SSMBlog/admin/user/uploadUserAvator/avator',
                //预读本地文件示例
                before: function (obj) {
                    obj.preview(function (index, file, result) {
                        $('#demo1').attr('src', result);//图片链接
                    });
                },
                done: function (res) {
                	 //修改头像的图片src的值，点击保存是就能修改用户的头像地址了
                    $("#userAvatar").attr("value", res.data.src);
                    //若上传失败则提示上传失败
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                },
                //演示失败状态，并实现重传
                error: function () {
                    var demoText = $('#demoText');
                    demoText.html('' +
                        '<span style="color: #FF5722;">上传失败</span>' +
                        ' <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
            });

        });
    </script>
</rapid:override>

<%@ include file="../public/framework.jsp" %>
