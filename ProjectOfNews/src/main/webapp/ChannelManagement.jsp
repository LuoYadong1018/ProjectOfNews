<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>     
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
	<link href="css/main.css" rel="stylesheet">
	<script type="text/javascript">
	   function   fs(){
		   document.getElementById("fs").submit();
	   }
	</script>
</head>
<body>
			<div class="AccountManagement_c " id="ColumnManagement_c">
                <h3>栏目管理 
                    <div class="amcl fr">
                    <form action="queryChannel"  method="post"  id="fs">
                        <input type="text" placeholder="栏目名" class="fl" name="search"  value="${search}" id="s1">
                        <div class="search fl" onclick="fs()"><img src="images/search.png"></div>
                    </form>
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <div class="add_btn df_btn fl" id="add_column_btn">添加</div>
                        <div class="edit_btn df_btn fl" id="edit_column_btn">编辑</div>
                        <div class="delete_btn df_btn fl" id="delete_column_btn">删除</div>
                    </div>
                </div>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><span>序号名</span></label></li>
                        <li class="b80"><label>栏目名称</label></li>
                    </ul>
                    <div class="list_b_c">
                    <c:forEach items="${channelList}"  var="colum">
                        <ul class="list_b">
                            <li class="b20"><label><input type="checkbox" name="ids"  value="${colum.id}"><span>${colum.sort}</span></label></li>
                            <li class="b80"><label>${colum.name}</label></li>
                        </ul>
                    </c:forEach>
                    </div>
                    <div class="pull_page">
                        <div class="fl pull_page_up"><a href="queryChannel.action?page=${page-1}">上一页</a></div>
                            <ul>
                                <c:forEach  begin="1" end="${maxPage}"  var="pa">
                                <c:choose>
                                   <c:when test="${page==pa}">
                                    <a href="queryChannel.action?page=${pa}">
                                    <li class="on">${pa}</li>
                                    </a>
                                   </c:when>
                                  <c:otherwise>
                                   <a href="queryChannel.action?page=${pa}">
                                  <li >${pa}</li>
                                  </a>
                                  </c:otherwise>
                                </c:choose>
                                </c:forEach>
                            </ul>
                        <div class="fl pull_page_down"><a href="queryChannel.action?page=${page+1}">下一页</a></div>
                    </div>
                </div>
            </div>
            <!-- 弹窗 -->
    <!-- 添加栏目-->
    <div class="add_Account dn" id="add_column">
        <div class="add_Account_c">
           <form action="insertChannel" method="post"  id="insertform">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    添加栏目
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="channel.name">     
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="text" placeholder="输入序号" name="channel.sort">     
            </div>
            <div class="add_Account_ok_btn text_center" id="add_column_ok_btn">确<i>皮</i>定</div>
           </form>
        </div>
    </div>

    <!-- 栏目编辑 -->
    <div class="add_Account dn" id="edit_column">
        <div class="add_Account_c">
        
        
           <form action="updateChannel"  method="post" id="updateform">
            <div class="add_Account_h">
            
            <input type="hidden" value=""  id="channelid" name="channel.id" />
                <div class="add_Account_h_in">
                    编辑栏目
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="column_now ">正在编辑 “<span id="bd"></span>”栏目</div>
            <div class="user_name user_i">
                <label>栏目名</label> <input type="text" placeholder="输入栏目名" name="channel.name">     
            </div>
            <div class="user_password user_i">
                <label>序<i>调</i>号</label> <input type="password" placeholder="输入序号" name="channel.sort">     
            </div>
            <div class="add_Account_ok_btn text_center" id="edit_column_ok_btn">确<i>皮</i>定</div>
           </form>
        </div>
    </div>

    <!-- 删除栏目 -->
    <div class="add_Account dn" id="delete_column">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    删除栏目
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除“ <span  id="sd"></span> ”栏目吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_column_ok_btn">确<i>皮</i>定</div>
             <form action="deleteChannel" method="post" id="deleteform">
               <input type="hidden" name="channel.id"  id="delColumnId"/>
             </form>
            
        </div>
    </div>
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script>
<script type="text/javascript">
  $(function(){
	  //添加
	  $("#add_column_ok_btn").click(function(){
		  $("#insertform").submit();
	  });
	  // 弹出编辑框 
	   $("#edit_column_btn").click(function(){
        
		   // 要进行判断    判断用户是否选择了一条记录  
		   var  ids=document.getElementsByName("ids");
		   var  c=new Array();
		   for(var i=0;i<ids.length;i++){
			   if(ids[i].checked==true){
				   
				   $("#bd").text(($(ids[i]).next().text()));
				   c.push(ids[i].value);
			   }
		   }
		   
		   if(c.length>1){
			   alert("你选的太多了，请选择一条记录");
			   return;
		   }
          
		   if(c.length==0){
			   alert("请选择你要编辑的数据");
			   return;
		   }
		   
		   $("#channelid").val(c[0]);
		   
		   $("#edit_column").fadeIn(100);
    });
	   //提交编辑
		  $("#edit_column_ok_btn ").click(function(){
			  $("#updateform").submit();
		  });
	  
	   // 显示删除
	      $("#delete_column_btn").click(function(){
	    	  var  ids=document.getElementsByName("ids");
			   var  c=new Array();
			   for(var i=0;i<ids.length;i++){
				   if(ids[i].checked==true){
					   //讲要删除的名字 设置到 删除的对话框中
					  $("#sd").text(($(ids[i]).next().text()));
					  
					   c.push(ids[i].value);
				   }
			   }
			   if(c.length>1){
				   alert("你选的太多了，请选择一条记录");
				   return;
			   }
			   if(c.length==0){
				   alert("请选择你要删除的数据");
				   return;
			   }
			   $("#delete_column").fadeIn(100);
			   
			   $("#delColumnId").val(c[0]);
        });
        //  提交删除
	      $("#delete_column_ok_btn").click(function(){
			  $("#deleteform").submit();
		  });
       
  })
</script>
</html>