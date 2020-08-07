<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<rapid:override name="description">
    <meta name="description" content="${category.category_name}"/>
</rapid:override>
<rapid:override name="keywords">
    <meta name="keywords" content="${category.category_name}"/>
</rapid:override>
<rapid:override name="title">
    <title>${category.category_name}</title>
</rapid:override>

<%--面包屑导航 start--%>
<rapid:override name="breadcrumb">
    <nav class="breadcrumb">
        <a class="crumbs" href="/SSMBlog/home/index">
            <i class="fa fa-home"></i>首页</a>
        <i class="fa fa-angle-right"></i>
        <c:choose>
            <c:when test="${category != null}">
                <a href="/SSMBlog/home/articleListByCategory/${category.category_id}">${category.category_name}</a>
                <i class="fa fa-angle-right"></i> 文章
            </c:when>
            <c:otherwise>
                该分类不存在
            </c:otherwise>

        </c:choose>

    </nav>
</rapid:override>
<%--面包屑导航 end--%>


<rapid:override name="left">
    <%--博客主体-左侧正文 start--%>
    <div id="primary" class="content-area">
        <main id="main" class="site-main">
            <c:choose>
                <c:when test="${pageInfo != null}">
                    <c:choose>
                        <c:when test="${pageInfo.list.size() != 0}">
                            <%--文章列表-start--%>
                            <c:forEach items="${articleList}" var="a">

                                <article class="post">

                                    <figure class="thumbnail">
                                        <a href="/SSMBlog/home/article/${a.article_id}">
                                            <img width="280" height="210"
                                                 src="/SSMBlog/resource/img/random/img_${random.nextInt(15)}.jpg"
                                                 class="attachment-content size-content wp-post-image"
                                                 alt="${a.article_title}">
                                        </a>
                                        <span class="cat">
                                                    <a href="/SSMBlog/home/articleListByCategory/${category.category_id}">${category.category_name}</a>
                                                </span>
                                    </figure>

                                    <header class="entry-header">
                                        <h2 class="entry-title">
                                            <a href="/SSMBlog/home/article/${a.article_id}" rel="bookmark">
                                                    ${a.article_title}
                                            </a>
                                        </h2>
                                    </header><!-- .entry-header -->

                                    <div class="entry-content">
                                        <div class="archive-content">
                                                ${a.article_summary}...
                                        </div>
                                        <span class="title-l"></span>
                                        <span class="new-icon">
                                                    <c:choose>
                                                        <c:when test="${a.article_status == 2}">
                                                            <i class="fa fa-bookmark-o"></i>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <jsp:useBean id="nowDate"
                                                                         class="java.util.Date"/> <%--当前时间--%>
                                                            <c:set var="interval"
                                                                   value="${nowDate.time - a.article_create_time.time}"/><%--时间差毫秒数--%>
                                                            <fmt:formatNumber value="${interval/1000/60/60/24}"
                                                                              pattern="#0"
                                                                              var="days"/><%--取天数整数--%>
                                                            <c:if test="${days <= 7}">NEW</c:if>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </span>
                                        <span class="entry-meta">
                                                    <span class="date">
                                                         <fmt:formatDate value="${a.article_create_time}"
                                                                         pattern="yyyy年MM月dd日"/>
                                                        &nbsp;&nbsp;
                                                    </span>
                                                    <span class="views">
                                                        <i class="fa fa-eye"></i>
                                                            ${a.article_view_count} views
                                                    </span>
                                                    <span class="comment">&nbsp;&nbsp;
                                                        <a href="/SSMBlog/home/article/${a.article_id}#comments"
                                                           rel="external nofollow">
                                                          <i class="fa fa-comment-o"></i>
                                                            <c:choose>
                                                                <c:when test="${a.article_comment_count==0}">
                                                                    发表评论
                                                                </c:when>
                                                                <c:otherwise>
                                                                    ${a.article_comment_count}
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </a>
                                                    </span>
                                                </span>
                                        <div class="clear"></div>
                                    </div><!-- .entry-content -->
                                    <span class="entry-more">
                                            <a href="/SSMBlog/home/article/${a.article_id}"
                                               rel="bookmark">阅读全文
                                            </a>
                                        </span>
                                </article>
                            </c:forEach>
                            <%--文章列表-end--%>
                        </c:when>
                        <c:otherwise>
                            <section class="no-results not-found">
                                <div class="post">
                                    <p>该分类目前还没有文章！</p>
                                    <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                                </div>
                            </section>
                        </c:otherwise>
                    </c:choose>
                </c:when>
                <c:otherwise>
                    <section class="no-results not-found">
                        <div class="post">
                            <p>该分类不存在</p>
                            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
                        </div>
                    </section>
                </c:otherwise>
            </c:choose>

        </main>
        <%@ include file="../public/part/paging.jsp" %>

    </div>
    <%--  博客主体-左侧正文 end--%>
</rapid:override>

<%@ include file="../public/framework.jsp" %>

<script>
	console.log(${pageInfo.pages});
</script>

