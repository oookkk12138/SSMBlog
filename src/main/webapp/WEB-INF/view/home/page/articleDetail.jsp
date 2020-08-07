<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>

<rapid:override name="title">
    <title>${article.article_title}</title>
</rapid:override>

<rapid:override name="header-style">
    <rapid:override name="header-style">
        <link rel="stylesheet" href="/SSMBlog/resource/css/highlight.css">
        <style>
            .entry-title {
                background: #f8f8f8;
            }
        </style>
    </rapid:override>
</rapid:override>

<rapid:override name="breadcrumb">
    <%--面包屑导航 start--%>
    <nav class="breadcrumb">
        <a class="crumbs" href="/SSMBlog/home/index">
            <i class="fa fa-home"></i>首页
        </a>
        <c:choose>
            <c:when test="${article.categoryList != null && article.categoryList.size() > 0}">
                <c:forEach items="${article.categoryList}" var="c">
                    <i class="fa fa-angle-right"></i>
                    <a href="/SSMBlog/home/articleListByCategory/${c.category_id}">
                            ${c.category_name}
                    </a>
                </c:forEach>
            </c:when>
            <c:otherwise>
                <i class="fa fa-angle-right"></i>
                <a>未分类</a>
            </c:otherwise>
        </c:choose>
        <i class="fa fa-angle-right"></i>
        正文
    </nav>
    <%--面包屑导航 end--%>
</rapid:override>


<rapid:override name="left">
    <%--博客主体-左侧文章正文 start--%>
    <div id="primary" class="content-area">
        <main id="main" class="site-main" role="main">
            <article class="post" id="articleDetail" data-id="${article.article_id}">
                <header class="entry-header">
                    <h1 class="entry-title">
                            ${article.article_title}
                    </h1>
                </header><!-- .entry-header -->
                <div class="entry-content">
                    <div class="single-content">
                            ${article.article_content}
                    </div>
                    <div class="s-weixin">
                        <ul class="weimg1">
                            <li><strong>微信</strong></li>
                            <li>赶快加我聊天吧</li>
                            <li><img src="/SSMBlog/resource/img/logo.png"></li>
                        </ul>
                        <ul class="weimg2">
                            <li><strong>博客交流群</strong></li>
                            <li>海纳百川，大家来水</li>
                            <li><img src="/SSMBlog/resource/img/logo.png" alt="weinxin"></li>
                        </ul>
                        <div class="clear"></div>
                    </div>
                    <div class="clear"></div>
                    <div id="social">
                        <div class="social-main">
                            <span class="like">
                                <a href="javascript:;" data-action="ding" data-id="1" title="点赞"
                                   class="favorite" onclick="increaseLikeCount()">
                                    <i class="fa fa-thumbs-up" id="dianzan"></i>赞
                                    <i class="count"
                                       id="count-${article.article_id}">${article.article_like_count}</i>
                                </a>
                            </span>
                            <div class="shang-p">
                                <div class="shang-empty"><span></span></div>
                                <span class="shang-s">
                                    <a onclick="PaymentUtils.show();" style="cursor:pointer">赏</a>
                                </span>
                            </div>
                            <div class="share-sd">
                                        <span class="share-s" style="margin-top: 25px!important;">
                                            <a href="javascript:void(0)" id="share-s" title="分享">
                                                <i class="fa fa-share-alt"></i>分享
                                            </a>
                                        </span>
                                <div id="share">
                                    <ul class="bdsharebuttonbox bdshare-button-style1-16" data-bd-bind="1503997585792">
                                        <li><a title="更多" class="bds_more fa fa-plus-square" data-cmd="more"
                                               onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到QQ空间" class="fa fa-qq" data-cmd="qzone" onclick="return false;"
                                               href="#"></a></li>
                                        <li><a title="分享到新浪微博" class="fa fa-weibo" data-cmd="tsina"
                                               onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到腾讯微博" class="fa fa-pinterest-square" data-cmd="tqq"
                                               onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到人人网" class="fa fa-renren" data-cmd="renren"
                                               onclick="return false;" href="#"></a></li>
                                        <li><a title="分享到微信" class="fa fa-weixin" data-cmd="weixin"
                                               onclick="return false;" href="#"></a></li>
                                    </ul>
                                </div>
                            </div>
                            <div class="clear"></div>
                        </div>
                    </div>

                    <footer class="single-footer">
                        <ul class="single-meta">
                            <c:if test="${sessionScope.user!=null}">
                                <li class="edit-link">
                                    <a target="_blank" class="post-edit-link"
                                       href="/admin/article/edit/${article.article_id}">编辑</a>
                                </li>
                            </c:if>
                            <li class="comment">
                                <a href="/SSMBlog/home/article/${article.article_id}#comments"
                                   rel="external nofollow">
                                    <i class="fa fa-comment-o"></i>
                                    <i class="comment-count">${comment_list.size()}</i>
                                </a>
                            </li>
                            <li class="views">
                                <i class="fa fa-eye"></i> <span
                                    class="articleViewCount">${article.article_view_count}</span>
                                views
                            </li>
                            <li class="r-hide">
                                <a href="javascript:pr()" title="侧边栏">
                                    <i class="fa fa-caret-left"></i>
                                    <i class="fa fa-caret-right"></i>
                                </a>
                            </li>
                        </ul>
                        <ul id="fontsize">
                            <li>A+</li>
                        </ul>
                        <div class="single-cat-tag">
                            <div class="single-cat">所属分类：
                                <c:forEach items="${article.categoryList}" var="c">
                                    <a href="/SSMBlog/home/articleListByCategory/${c.category_id}">
                                            ${c.category_name}
                                    </a>
                                </c:forEach>
                            </div>
                        </div>
                    </footer><!-- .entry-footer -->


                    <div class="clear"></div>
                </div><!-- .entry-content -->
            </article><!-- #post -->

                <%--所属标签 start--%>
            <div class="single-tag">
                <ul class="" data-wow-delay="0.3s">
                    <c:forEach items="${article.tagList}" var="t">
                        <li>
                            <a href="/SSMBlog/home/articleListByTag/${t.tag_id}" rel="tag"
                               style="background:#666666">
                                    ${t.tag_name}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
                <%--所属标签 end--%>


                <%--版权声明 start--%>
            <div class="authorbio wow fadeInUp">
                <img alt="${user.user_nickname}" src="${user.user_avator}"
                     class="avatar avatar-64 photo" height="64" width="64">
                <ul class="postinfo">
                    <li></li>
                    <li><strong>版权声明：</strong>本站原创文章，于<fmt:formatDate
                            value="${article.article_create_time}"
                            pattern="yyyy-MM-dd"/>，由
                        <strong>
                                ${user.user_nickname}
                        </strong>
                        发表。
                    </li>
                    <li class="reprinted"><strong>转载请注明：</strong>
                        <a href="/SSMBlog/home/article/${article.article_id}"
                           rel="bookmark"
                           title="本文固定链接 /SSMBlog/home/article/${article.article_id}">
                                ${article.article_title} | ${staticOption.option_site_title}</a>
                    </li>
                </ul>
                <div class="clear"></div>
            </div>
                <%--版权声明 end--%>

                <%--上一篇下一篇 start--%>
            <nav class="nav-single">
                <c:choose>
                    <c:when test="${preArticle!=null}">
                        <a href="/SSMBlog/home/article/${preArticle.article_id}" rel="next">
                            <span class="meta-nav">
                                <span class="post-nav">上一篇
                                 <i class="fa fa-angle-left"></i>
                                </span>
                                <br>${preArticle.article_title}
                            </span>
                        </a>
                    </c:when>
                    <c:otherwise>
                              <span class="meta-nav">
                                    <span class="post-nav">
                                        没有了<br>
                                    </span>已是第一篇文章
                                </span>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${nextArticle!=null}">
                        <a href="/SSMBlog/home/article/${nextArticle.article_id}" rel="next">
                            <span class="meta-nav">
                                <span class="post-nav">下一篇
                                 <i class="fa fa-angle-right"></i>
                                </span>
                                <br>${nextArticle.article_title}
                            </span>
                        </a>
                    </c:when>
                    <c:otherwise>
                            <span class="meta-nav">
                                <span class="post-nav">
                                    没有了<br>
                                </span>已是最后文章
                             </span>
                    </c:otherwise>
                </c:choose>

                <div class="clear"></div>
            </nav>
                <%--上一篇下一篇 end--%>

                <%--评论区域 start--%>
            <div class="scroll-comments"></div>
            <div id="comments" class="comments-area">
                <div id="respond" class="comment-respond">
                    <form id="comment_form" method="post">
                        <c:if test="${sessionScope.user!=null}">
                            <div class="user_avatar">
                                <img alt="SSMBlog"
                                     src="${sessionScope.user.user_avator}"
                                     class="avatar avatar-64 photo" height="64" width="64">
                                登录者：${sessionScope.user.user_nickname}
                                <br> <a href="javascript:void(0)" onclick="logout()">登出</a>
                                <input type="hidden" name="comment_role" value="1">
                                <input type="hidden" name="comment_author_name"
                                       value="${sessionScope.user.user_nickname}">
                                <input type="hidden" name="comment_author_email"
                                       value="${sessionScope.user.user_email}">
                                <input type="hidden" name="comment_author_avator"
                                       value="${sessionScope.user.user_avator}">
                                <input type="hidden" name="comment_author_url" value="${sessionScope.user.user_url}">
                            </div>
                        </c:if>
                        <p class="comment-form-comment">
                            <textarea id="comment" name="comment_content" rows="4" tabindex="1" required></textarea>
                        </p>
                        <div id="comment-author-info">
                            <c:if test="${sessionScope.user == null}">
                                <input type="hidden" name="comment_role" value="0">
                                <p class="comment-form-author">
                                    <label for="author_name">
                                        昵称<span class="required">*</span>
                                    </label>
                                    <input type="text" name="comment_author_name" id="author_name" class="" value=""
                                           tabindex="2" required>
                                </p>
                                <p class="comment-form-email">
                                    <label for="author_email">
                                        邮箱<span class="required">*</span>
                                    </label>
                                    <input type="email" name="comment_author_email" id="author_email" class="" value=""
                                           tabindex="3" required>
                                </p>
                                <p class="comment-form-url">
                                    <label for="author_url">网址</label>
                                    <input type="url" name="comment_author_url" id="author_url" class="" value=""
                                           tabindex="4">
                                </p>
                            </c:if>
                        </div>
                        <div class="clear"></div>
                        <p class="form-submit">
                            <input id="submit" name="submit" type="submit" tabindex="5" value="提交评论">
                            <input type="hidden" name="comment_article_id"
                                   value="${article.article_id}" id="article_id">
                        </p>
                    </form>
                </div>

				<!-- 这里是评论 -->
                <ol class="comment-list">
                    <c:forEach items="${commentList}" var="c" varStatus="status">
                            <li class="comment">
                                <div id="div-comment-${c.comment_id}" class="comment-body">
                                    <div class="comment-author vcard">
                                        <img class="avatar" src="${c.comment_author_avator}" alt="avatar"
                                             style="display: block;">
                                        <strong>${c.comment_author_name} </strong>
                                        <c:if test="${c.comment_role == 1}">
                                            <i class="fa fa-black-tie" style="color: #c40000;"></i>
                                            <span class=""
                                                  style="margin-top: 2px!important;color: #c40000;font-size: 13px;;"><b>会员</b></span>
                                        </c:if>
                                        <c:if test="${c.comment_role == 0}">
                                            <i class="fa fa-black-tie" style="color: green;"></i>
                                            <span class=""
                                                  style="margin-top: 2px!important;color: green;font-size: 13px;;"><b>游客</b></span>
                                        </c:if>
                                        <span class="comment-meta commentmetadata">
                                            <span class="ua-info" style="display: inline;">
                                                <br>
                                                <p>${c.comment_content}</p>
                                                <span class="comment-aux">
                                                    <fmt:formatDate value="${c.comment_create_time}"
                                                                    pattern="yyyy年MM月dd日 HH:mm:ss"/>&nbsp;
                                                    <c:if test="${sessionScope.user != null}">
                                                        <a href="javascript:void(0)"
                                                           onclick="deleteComment(${c.comment_id})">删除</a>
                                                        <a class="comment-edit-link"
                                                           href="/SSMBlog/admin/comment/edit/${c.comment_id}"
                                                           target="_blank">编辑</a>
                                                    </c:if>
                                                     <span class="floor"> &nbsp;${status.count}楼</span>
                                                </span>
                                            </span>
                                        </span>
                                    </div>
                                </div>
                            </li>
                    </c:forEach>
                </ol>
            </div>
                <%--评论框 end--%>

        </main>
        <!-- .site-main -->
    </div>
    <%--博客主体-左侧文章正文end--%>
</rapid:override>


<%--侧边栏 start--%>
<rapid:override name="right">
    <%@include file="../public/part/sidebar-1.jsp" %>
</rapid:override>
<%--侧边栏 end--%>

<rapid:override name="footer-script">
    <script src="/SSMBlog/resource/js/jquery.cookie.js"></script>

    <script type="text/javascript">

        $(document).ready(function () {
            if ($('#author_name').val() == '') {
                var author = localStorage.getItem("author");
                $("#author_name").val(author == 'undefined' ? '' : author);
            }
            if ($('#author_email').val() == '') {
                var email = localStorage.getItem("email");
                $("#author_email").val(email == 'undefined' ? '' : email);
            }
            if ($('#author_url').val() == '') {
                var url = localStorage.getItem("url");
                $("#author_url").val(url == 'undefined' ? '' : url);
            }
        });

        //此处使用ajax处理进行文章浏览量加一
        var articleId = $("#articleDetail").attr("data-id");
        increaseViewCount(articleId);
        layui.code({
            elem: 'pre',//默认值为.layui-code
            // skin: 'notepad', //如果要默认风格，不用设定该key。
            about: false
        });

    </script>

</rapid:override>


<%@ include file="../public/framework.jsp" %>