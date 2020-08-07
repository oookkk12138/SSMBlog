<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="rapid" uri="http://www.rapid-framework.org.cn/rapid" %>
<jsp:useBean id="random" class="java.util.Random" scope="application" />

<rapid:override name="breadcrumb">
    <nav class="breadcrumb">
        <div class="bull"><i class="fa fa-volume-up"></i></div>
        <div id="scrolldiv">
            <div class="scrolltext">
                <ul style="margin-top: 0px;">
                	<!-- 公告 -->
                    <c:forEach items="${noticeList}" var="n">
                        <li class="scrolltext-title">
                            <a href="/SSMBlog/home/notice/noticeDetail/${n.notice_id}" rel="bookmark">${n.notice_title}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </nav>
</rapid:override>

<rapid:override name="left">
    <div id="primary" class="content-area">

        <main id="main" class="site-main" role="main">
            <c:forEach items="${pageInfo.list}" var="a">

                <article class="post type-post">

                    <figure class="thumbnail">
                        <a href="/SSMBlog/home/article/${a.article_id}">
                        	<!-- 用于随机选取那15个图片 -->
                            <img width="280" height="210"
                                 src="/SSMBlog/resource/img/random/img_${random.nextInt(15)}.jpg"
                                 class="attachment-content size-content wp-post-image"
                                 alt="${a.article_title}">
                        </a>
                        <span class="cat">
                        		<!-- 因为一篇文章对应有多个分类，所以选取最后的一个分类[size()-1]来作为显示 -->
                                <a href="/SSMBlog/home/articleListByCategory/${a.categoryList[a.categoryList.size()-1].category_id}">
                                        ${a.categoryList[a.categoryList.size()-1].category_name}
                                </a>
                            </span>
                    </figure>

                    <header class="entry-header">
                        <h2 class="entry-title">
                            <a href="/SSMBlog/home/article/${a.article_id}"
                               rel="bookmark">
                                    ${a.article_title}
                            </a>
                        </h2>
                    </header>

                    <div class="entry-content">
                        <div class="archive-content">
                        		<!-- 这是文章的总结语，对应数据库的summary -->
                                ${a.article_summary}...
                        </div>
                        <span class="title-l"></span>
                        <span class="new-icon">
                            <c:choose>
                                <c:when test="${a.article_status == 2}">
                                    <i class="fa fa-bookmark-o"></i>
                                </c:when>
                                <c:otherwise>
                                    <jsp:useBean id="nowDate" class="java.util.Date"/>
                                    <c:set var="interval"
                                           value="${nowDate.time - a.article_create_time.time}"/><%--时间差毫秒数--%>
                                    <fmt:formatNumber value="${interval/1000/60/60/24}" pattern="#0"
                                                      var="days"/>
                                    <c:if test="${days <= 7}">NEW</c:if>
                                </c:otherwise>
                            </c:choose>
                        </span>
                        <span class="entry-meta">
                            <span class="date">
                                <fmt:formatDate value="${a.article_create_time}" pattern="yyyy年MM月dd日"/>
                            &nbsp;&nbsp;
                            </span>
                            <span class="views">
                                <i class="fa fa-eye"></i>
                                    ${a.article_view_count} views
                            </span>
                            <span class="comment">&nbsp;&nbsp;
                            	<!-- 后面的#comment用于前端定位到评论那一部分（与后端无关） -->
                                <a href="/SSMBlog/home/article/${a.article_id}#comments" rel="external nofollow">
                                  <i class="fa fa-comment-o"></i>
                                </a>
                            </span>
                        </span>
                        <div class="clear"></div>
                    </div><!-- .entry-content -->

                    <span class="entry-more">
                        <a href="/SSMBlog/home/article/${a.article_id}"
                           rel="bookmark">
                            阅读全文
                        </a>
                    </span>
                </article>
            </c:forEach>
        </main>
        <%@ include file="public/part/paging.jsp" %>

    </div>
</rapid:override>
<%--左侧区域 end--%>

<%--侧边栏 start--%>
<rapid:override name="right">

    <%@include file="public/part/sidebar-2.jsp" %>

</rapid:override>
<%--侧边栏 end--%>

<%--友情链接 start--%>
<rapid:override name="link">
    <div class="links-box">
        <div id="links">
            <c:forEach items="${linkList}" var="l">
                <ul class="lx7">
                    <li class="link-f link-name">
                        <a href="${l.link_url}" target="_blank">
                                ${l.link_name}
                        </a>
                    </li>
                </ul>
            </c:forEach>
            <div class="clear"></div>
        </div>
    </div>
</rapid:override>
<%--友情链接 end--%>

<%@ include file="public/framework.jsp" %>
