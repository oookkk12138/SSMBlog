<%--
    一般用于首页侧边栏：
    包括 关于本站，网站概况，热评文章，所有标签，随机文章 等小工具

--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--博客主体-右侧侧边栏 start--%>
<div id="sidebar" class="widget-area all-sidebar"
     style="position: relative; overflow: visible; box-sizing: border-box; min-height: 1px;">

    <%--关于本站 start--%>
    <aside class="widget about">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>关于本站
        </h3>
        <div id="feed_widget">
            <div class="feed-about">
                <div class="about-main">
                    <div class="about-img">
                        <img src="${staticOption.option_aboutsite_avator}"
                        alt="QR Code">
                    </div>
                    <div class="about-name">${staticOption.option_aboutsite_title}</div>
                    <div class="about-the">
                        ${staticOption.option_aboutsite_content}
                    </div>
                </div>
                <div class="clear"></div>
                <ul>
                    <li class="weixin">
                        <a title="微信" id="weixin_btn" rel="external nofollow">
                            <i class="fa fa-weixin"> </i>
                            <div id="weixin_code" class="hide" >
                                <img src="${staticOption.option_aboutsite_wechat}" alt="" width="400px" height="400px">
                            </div>
                        </a>
                    </li>
                    <li class="QQ">
                        <a title="QQ" id="QQ_btn" rel="external nofollow">
                            <i class="fa fa-qq"> </i>
                            <div id="QQ_code" class="hide" >
                                <img src="${staticOption.option_aboutsite_qq}" alt="" width="400px" height="400px">
                            </div>
                        </a>
                    </li>
                    <li class="sina">
                        <a title="sina" id="sina_btn" rel="external nofollow">
                            <i class="fa fa-weibo"> </i>
                            <div id="sina_code" class="hide" >
                                <img src="${staticOption.option_aboutsite_weibo}" alt="" width="400px" height="400px">
                            </div>
                        </a>
                    </li>
                    <li class="feed">
                        <a title="feed" id="feed_btn" rel="external nofollow">
                            <i class="fa fa-github"> </i>
                            <div id="feed_code" class="hide" >
                                <img src="${staticOption.option_aboutsite_github}" alt="" width="400px" height="400px">
                            </div>
                        </a>
                    </li>
                </ul>
                <div class="about-inf">
                    <span class="about-pn">文章 ${staticArticleCount} </span>
                    <span class="about-cn">评论 ${staticCommentCount} </span>
                </div>
            </div>
        </div>
        <div class="clear"></div>
    </aside>
    <%--关于本站 start--%>

    <%--网站概况 start--%>
    <aside id="php_text-22" class="widget php_text">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>网站概况
        </h3>
        <div class="textwidget widget-text">
            <ul class="site-profile">
                <li><i class="fa fa-file-o"></i> 文章总数：${staticArticleCount} 篇</li>
                <li><i class="fa fa-commenting-o"></i> 留言数量：${staticCommentCount} 条</li>
                <li><i class="fa fa-folder-o"></i> 分类数量：${staticCategoryCount} 个</li>
                <li><i class="fa fa-tags"></i> 标签总数：${staticTagCount} 个</li>
                <li><i class="fa fa-link"></i> 链接数量：${staticLinkCount} 个</li>
                <li><i class="fa fa-eye"></i> 浏览总量：${totalViewCount} 次</li>
                <li><i class="fa fa-clock-o"></i> 运行时间：<span id="htmer_time"></span></li>
            </ul>
        </div>
        <div class="clear"></div>
    </aside>
    <%--网站概况 end--%>

    <%--所有标签 start--%>
    <aside class="widget">
        <h3 class="widget-title">
            <i class="fa fa-bars"></i>所有标签
        </h3>
        <div class="tagcloud">
            <c:forEach items="${staticTagList}" var="tag">
                <a href="/SSMBlog/home/articleListByTag/${tag.tag_id}"
                   class="tag-link-129 tag-link-position-1"
                   style="font-size: 14px;">
                        ${tag.tag_name}
                </a>
            </c:forEach>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </aside>
    <%--所有标签 end--%>

</div>

<%--博客主体-右侧侧边栏 end--%>

<!-- 用于显示当前网站运行时间 -->
<!--网站计时-->
<script>
    function secondToDate(second) {
        if (!second) {
            return 0;
        }
        var time = new Array(0, 0, 0, 0, 0);
        if (second >= 365 * 24 * 3600) {
            time[0] = parseInt(second / (365 * 24 * 3600));
            second %= 365 * 24 * 3600;
        }
        if (second >= 24 * 3600) {
            time[1] = parseInt(second / (24 * 3600));
            second %= 24 * 3600;
        }
        if (second >= 3600) {
            time[2] = parseInt(second / 3600);
            second %= 3600;
        }
        if (second >= 60) {
            time[3] = parseInt(second / 60);
            second %= 60;
        }
        if (second > 0) {
            time[4] = second;
        }
        return time;
    }
</script>
<script>
    function setTime() {
    	//此为创建时间（上线的时候旧把这个改了就行,00表示一月)
        var create_time = Math.round(new Date(2020, 04, 01, 00, 00, 00).getTime() / 1000);
        var timestamp = Math.round((new Date().getTime() + 8 * 60 * 60 * 1000) / 1000);
        currentTime = secondToDate((timestamp - create_time));
        currentTimeHtml = currentTime[0] + '年 ' + currentTime[1] + '天 '
                + currentTime[2] + '时 ' + currentTime[3] + '分 ' + currentTime[4]
                + '秒';
        document.getElementById("htmer_time").innerHTML = currentTimeHtml;
    }    
    setInterval(setTime, 1000);
</script>
