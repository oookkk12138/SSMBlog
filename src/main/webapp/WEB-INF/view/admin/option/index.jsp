<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

    <rapid:override name="title">
        - 基本信息列表
    </rapid:override>
<rapid:override name="header-style">
    <style>
    </style>
</rapid:override>

<rapid:override name="content">
    <blockquote class="layui-elem-quote">
        <span class="layui-breadcrumb" lay-separator="/">
          <a href="/SSMBlog/admin/index">首页</a>
          <a><cite>基本信息</cite></a>
        </span>
    </blockquote>
    <form class="layui-form" action="/SSMBlog/admin/option/editSubmit" method="post">

    <div class="layui-tab layui-tab-brief" lay-filter="docDemoTabBrief">
        <ul class="layui-tab-title">
            <li class="layui-this">基本信息</li>
            <li>小工具</li>
        </ul>
        <div class="layui-tab-content">
            <br><br>
            <c:choose>
                <c:when test="${option.option_id>0}">
                    <input type="hidden" name="option_id" value="${option.option_id}">
                </c:when>
                <c:otherwise>
                    <%--给一个默认值，这个地方很奇怪，本来不需要加的--%>
                    <input type="hidden" name="option_id" value="1">
                </c:otherwise>
            </c:choose>

            <div class="layui-tab-item layui-show">
                <div class="layui-form-item">
                    <label class="layui-form-label">站点名称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="option_site_title"  value="${option.option_site_title}"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">站点描述</label>
                    <div class="layui-input-block">
                        <input type="text" name="option_site_description"   value="${option.option_site_description}"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">首页描述</label>
                    <div class="layui-input-block">
                        <input type="text" name="option_meta_description"  value="${option.option_meta_description}"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">首页关键词</label>
                    <div class="layui-input-block">
                        <input type="text" name="option_meta_keyword"  value="${option.option_meta_keyword}"   autocomplete="off" class="layui-input">
                    </div>
                </div>
            </div>
            <div class="layui-tab-item">
                <div class="layui-form-item">
                    <label class="layui-form-label">头像</label>
                    <div class="layui-input-inline">
                        <div class="layui-upload">
                            <div class="layui-upload-list" style="">
                                <img class="layui-upload-img" src="${option.option_aboutsite_avator}" id="demo1" width="100"
                                     height="100">
                                <p id="demoText"></p>
                            </div>
                            <button type="button" class="layui-btn" id="test1">上传图片</button>
                            <input type="hidden" id="optionAboutsiteAvatar" name="option_aboutsite_avator" value="${option.option_aboutsite_avator}">
                        </div>
                    </div>
                    <div class="layui-form-mid layui-word-aux">建议 150px*150px</div>

                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">昵称</label>
                    <div class="layui-input-inline">
                        <input type="text" name="option_aboutsite_title"   value="${option.option_aboutsite_title}"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">说明</label>
                    <div class="layui-input-block">
                        <input type="text" name="option_aboutsite_content"   value="${option.option_aboutsite_content}"   autocomplete="off" class="layui-input">
                    </div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">微信二维码</label>
                    <div class="layui-input-inline">
                        <div class="layui-upload">
                            <div class="layui-upload-list" style="">
                                <img class="layui-upload-img" src="${option.option_aboutsite_wechat}" id="demo2" width="100"
                                     height="100">
                                <p id="demoText2"></p>
                            </div>
                            <button type="button" class="layui-btn" id="test2">上传图片</button>
                            <input type="hidden" id="optionAboutsiteWechat" name="option_aboutsite_wechat" value="${option.option_aboutsite_wechat}">
                        </div>
                    </div>
                    <div class="layui-form-mid layui-word-aux">建议 430px*430px</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">QQ二维码</label>
                    <div class="layui-input-inline">
                        <div class="layui-upload">
                            <div class="layui-upload-list" style="">
                                <img class="layui-upload-img" src="${option.option_aboutsite_qq}" id="demo3" width="100"
                                     height="100">
                                <p id="demoText3"></p>
                            </div>
                            <button type="button" class="layui-btn" id="test3">上传图片</button>
                            <input type="hidden" id="optionAboutsiteQQ" name="option_aboutsite_qq" value="${option.option_aboutsite_qq}">
                        </div>
                    </div>
                    <div class="layui-form-mid layui-word-aux">建议 430px*430px</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">微博</label>
                    <div class="layui-input-inline">
                        <div class="layui-upload">
                            <div class="layui-upload-list" style="">
                                <img class="layui-upload-img" src="${option.option_aboutsite_weibo}" id="demo4" width="100"
                                     height="100">
                                <p id="demoText4"></p>
                            </div>
                            <button type="button" class="layui-btn" id="test4">上传图片</button>
                            <input type="hidden" id="optionAboutsiteWeiBo" name="option_aboutsite_weibo" value="${option.option_aboutsite_weibo}">
                        </div>
                    </div>
                    <div class="layui-form-mid layui-word-aux">建议 430px*430px</div>
                </div>
                <div class="layui-form-item">
                    <label class="layui-form-label">Github</label>
                    <div class="layui-input-inline">
                        <div class="layui-upload">
                            <div class="layui-upload-list" style="">
                                <img class="layui-upload-img" src="${option.option_aboutsite_github}" id="demo5" width="100"
                                     height="100">
                                <p id="demoText5"></p>
                            </div>
                            <button type="button" class="layui-btn" id="test5">上传图片</button>
                            <input type="hidden" id="optionAboutsiteGithub" name="option_aboutsite_github" value="${option.option_aboutsite_github}">
                        </div>
                    </div>
                    <div class="layui-form-mid layui-word-aux">建议 430px*430px</div>
                </div>
            </div>
        </div>

    </div>

        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn" lay-submit lay-filter="formDemo">保存设置</button>
            </div>
        </div>
    </form>




</rapid:override>
<rapid:override name="footer-script">
    <script>
        //上传头像
        layui.use('upload', function () {
            var $ = layui.jquery,
                upload = layui.upload;
            var uploadInst = upload.render({
                elem: '#test1',
                url: '/SSMBlog/admin/user/uploadUserAvator/avator',
                before: function (obj) {
                    obj.preview(function (index, file, result) {
                        $('#demo1').attr('src', result);
                    });
                },
                done: function (res) {
                    $("#optionAboutsiteAvatar").attr("value", res.data.src);
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                },
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

        //上传微信号
        layui.use('upload', function () {
            var $ = layui.jquery,
                upload = layui.upload;
            var uploadInst = upload.render({
                elem: '#test2',
                url: '/SSMBlog/admin/user/uploadUserAvator/avator',
                before: function (obj) {
                    obj.preview(function (index, file, result) {
                        $('#demo2').attr('src', result);
                    });
                },
                done: function (res) {
                    $("#optionAboutsiteWechat").attr("value", res.data.src);
                    if (res.code > 0) {
                        return layer.msg('上传失败');
                    }
                },
                error: function () {
                    var demoText = $('#demoText2');
                    demoText.html('' +
                        '<span style="color: #FF5722;">上传失败</span>' +
                        ' <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                    demoText.find('.demo-reload').on('click', function () {
                        uploadInst.upload();
                    });
                }
            });
        });
        
      //上传QQ
      layui.use('upload', function () {
          var $ = layui.jquery,
              upload = layui.upload;
          var uploadInst = upload.render({
              elem: '#test3',
              url: '/SSMBlog/admin/user/uploadUserAvator/avator',
              before: function (obj) {
                  obj.preview(function (index, file, result) {
                      $('#demo3').attr('src', result);
                  });
              },
              done: function (res) {
                  $("#optionAboutsiteQQ").attr("value", res.data.src);
                  if (res.code > 0) {
                      return layer.msg('上传失败');
                  }
              },
              error: function () {
                  var demoText = $('#demoText3');
                  demoText.html('' +
                      '<span style="color: #FF5722;">上传失败</span>' +
                      ' <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                  demoText.find('.demo-reload').on('click', function () {
                      uploadInst.upload();
                  });
              }
          });
      });
      
      //上传微博
      layui.use('upload', function () {
          var $ = layui.jquery,
              upload = layui.upload;
          var uploadInst = upload.render({
              elem: '#test4',
              url: '/SSMBlog/admin/user/uploadUserAvator/avator',
              before: function (obj) {
                  obj.preview(function (index, file, result) {
                      $('#demo4').attr('src', result);
                  });
              },
              done: function (res) {
                  $("#optionAboutsiteWeiBo").attr("value", res.data.src);
                  if (res.code > 0) {
                      return layer.msg('上传失败');
                  }
              },
              error: function () {
                  var demoText = $('#demoText4');
                  demoText.html('' +
                      '<span style="color: #FF5722;">上传失败</span>' +
                      ' <a class="layui-btn layui-btn-mini demo-reload">重试</a>');
                  demoText.find('.demo-reload').on('click', function () {
                      uploadInst.upload();
                  });
              }
          });
      });
      
    //上传Github
    layui.use('upload', function () {
        var $ = layui.jquery,
            upload = layui.upload;
        var uploadInst = upload.render({
            elem: '#test5',
            url: '/SSMBlog/admin/user/uploadUserAvator/avator',
            before: function (obj) {
                obj.preview(function (index, file, result) {
                    $('#demo5').attr('src', result);
                });
            },
            done: function (res) {
                $("#optionAboutsiteGithub").attr("value", res.data.src);
                if (res.code > 0) {
                    return layer.msg('上传失败');
                }
            },
            error: function () {
                var demoText = $('#demoText5');
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

<%@ include file="../public/framework.jsp"%>
