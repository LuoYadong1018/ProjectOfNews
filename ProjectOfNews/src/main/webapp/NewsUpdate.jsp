<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.news.entity.*,java.util.*"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<base href="<%=request.getContextPath()%>/">
	<title></title>
	<meta charset="utf-8">
    <link href="css/main.css" rel="stylesheet">
    <script type="text/javascript">
	    function updateNews(){
			var title = document.getElementsByName('title')[0];
			var chnl_code = document.getElementsByName('chnl_code')[0];
			var detail = document.getElementsByName('detail')[0];
			if(title.value==''){
				alert('请输入新闻标题');
				title.focus();
				return false;
			}
			if(chnl_code.options[chnl_code.selectedIndex].value==-1){
				alert('请选择新闻栏目');
				chnl_code.focus();
				return false;
			}
			if(detail.value==''){
				alert('请输入新闻正文');
				detail.focus();
				return false;
			}
			return true;
		}
    </script>
</head>
<body>
  <!-- 新闻编辑 -->
  <div class="AccountManagement_c" id="NewsManagement_c">
      <div class="list" id="release_news">
          <ul class="list_h">
              <li class="b80"><label>编辑新闻</label></li>
          </ul>
          <div class="list_b_c" id="release_news_in">
          	  <form action="updateNews" method="post" onsubmit="return updateNews();">
          	  <%
          	  News news = (News)request.getAttribute("news");
          	  %>
          	  <input type="hidden" name="id" value="<%=news.getId() %>" />
              <div class="release_news">
                  <div class="news_title">
                      <label class="text_center">标题</label>
                      <input type="text" placeholder="填写标题" name="title" value="<%=news.getTitle() %>">
                  </div>
                  <div class="column_name">
                      <label class="text_center">栏目</label>
                      <select class="column_name_release" name="channel.id">
                         <c:forEach  items="${channelList}" var="channel">
						 <option value="${channel.id}">${channel.name }</option>
                         </c:forEach>
                      </select>
                  </div>
                  <textarea class="release_news_content" rows="50" cols="60" placeholder="编辑正文" name="detail"><%=news.getDetail() %></textarea>     
	           	  <div><button type="submit" class="release_news_ok_btn text_center">发&emsp;布</button></div>
              </div>
              </form>
          </div>
      </div>
  </div>
</body>
</html>