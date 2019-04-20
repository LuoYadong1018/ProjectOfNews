<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib  prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>      
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
			<div class="AccountManagement_c " id="AccountManagement_c">
                <h3>账户管理 
                    <div class="amcl fr">
                    <form action="queryUser"  method="post"  id="fs">
                    
                        <input type="text" placeholder="用户名" class="fl" name="search"  value="${search}" id="s1">
                        <div class="search fl" onclick="fs()"><img src="images/search.png"></div>
                    
                    </form>
                    
                    
                    </div> 
                </h3>
                <div class="AM_ct text_center">
                    <div class="AM_ct_in">
                        <div class="add_btn df_btn fl" id="add_Account_btn">添加</div>
                        <div class="edit_btn df_btn fl" id="edit_Account_btn">编辑</div>
                        <div class="delete_btn df_btn fl" id="delete_Account_btn">删除</div>
                        <div class="fr df_btn ac_btn" id="ac_Account_btn">账号授权</div>
                    </div>
                </div>

                <div class="list">
                    <ul class="list_h">
                        <li class="b20"><label><span>用户名</span></label></li>
                        <li class="b20"><label>密码</label></li>
                        <li class="b60"><label>授权形式</label></li>
                    </ul>
                    <div class="list_b_c">
                   

                    <c:forEach items="${userList}"  var="user">
                        <ul class="list_b">
                            <li class="b20"><label><input type="checkbox" name="ids"  value="${user.id}"><span>${user.name}</span></label></li>
                            <li class="b20"><label>${user.pwd }</label></li>
                            <li class="b60"><label>
                              
                              <c:forEach items='${fn:split(user.lev,",")}'  var="cid">
                                   <c:forEach items="${csList}" var="cs">
                                      <c:choose>
                                        <c:when test="${cid==cs.id}">
                                          ${cs.name},
                                        </c:when>
                                      </c:choose>
                                   </c:forEach>
                              </c:forEach>
                            </label></li>
                        </ul>
                    </c:forEach>
                       


                    </div>

                    <div class="pull_page">
                        <div class="fl pull_page_up"><a href="queryUser.action?page=${page-1}">上一页</a></div>
                            <ul>
                                <c:forEach  begin="1" end="${maxPage}"  var="pa">
                                <c:choose>
                                   <c:when test="${page==pa}">
                                    <a href="queryUser.action?page=${pa}">
                                    <li class="on">${pa}</li>
                                    </a>
                                   </c:when>
                                  <c:otherwise>
                                   <a href="queryUser.action?page=${pa}">
                                  <li >${pa}</li>
                                  </a>
                                  </c:otherwise>
                                </c:choose>
                                </c:forEach>
                            </ul>
                        <div class="fl pull_page_down"><a href="queryUser.action?page=${page+1}">下一页</a></div>
                    </div>
                </div>
            </div>


            <!-- 弹窗 -->
    <!-- 添加账户 -->
    <div class="add_Account dn" id="add_Account">
        <div class="add_Account_c">
        
           <form action="addUser" method="post"  id="addform">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    添加账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="user.name">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="user.pwd">     
            </div>
            <div class="add_Account_ok_btn text_center" id="add_Account_ok_btn">确<i>皮</i>定</div>
           </form>
        </div>
    </div>

    <!-- 账户编辑 -->
    <div class="add_Account dn" id="user_column">
        <div class="add_Account_c">
        
        
           <form action="updateUser"  method="post" id="updateform">
            <div class="add_Account_h">
            
            <input type="hidden" value=""  id="userid" name="user.id" />
                <div class="add_Account_h_in">
                    编辑账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="column_now ">正在编辑 “<span id="bd"></span>”账户</div>
            <div class="user_name user_i">
                <label>用户名</label> <input type="text" placeholder="输入用户名" name="user.name">     
            </div>
            <div class="user_password user_i">
                <label>密<i>调</i>码</label> <input type="password" placeholder="输入密码" name="user.pwd">     
            </div>
            <div class="add_Account_ok_btn text_center" id="user_column_ok_btn">确<i>皮</i>定</div>
           </form>
        </div>
    </div>

    <!-- 删除账户 -->
    <div class="add_Account dn" id="delete_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    删除账户
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <div class="delete_text">确定删除“ <span  id="sd"></span> ”账户吗？</div>
            <div class="add_Account_ok_btn text_center" id="delete_Account_ok_btn">确<i>皮</i>定</div>
             <form action="delUser" method="post" id="delfrom">
               <input type="hidden" name="user.id"  id="delUserId"/>
             </form>
            
        </div>
    </div>

    <!-- 账户授权 -->
    <div class="add_Account dn" id="ac_Account">
        <div class="add_Account_c">
            <div class="add_Account_h">
                <div class="add_Account_h_in">
                    账户栏目授权
                    <span class="fr add_Account_close"><img src="images/close.png"></span>
                </div>
            </div>
            <form action="levUser" method="post" id="levform">
            <input type="hidden" name="user.id"  id="ac_user_id" />
            <ul>
            <c:forEach items="${csList}" var="cs">
                <li><label><input type="checkbox" name="level"   value="${cs.id}"   >&nbsp;<span>${cs.name}</span></label></li>
            </c:forEach>
              
            </ul>
            <div class="add_Account_ok_btn text_center" id="ac_Account_ok_btn">保<i>呀</i>存</div>
            </form>
        </div>
    </div>
    
</body>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/main.js"></script>

<script type="text/javascript">
   
  $(function(){
	  
	  //添加
	  $("#add_Account_ok_btn").click(function(){
		  $("#addform").submit();
	  });
	  
	  // 弹出编辑框 
	  
	   $("#edit_Account_btn").click(function(){
        
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
		   
		   $("#userid").val(c[0]);
		   
		   $("#user_column").fadeIn(100);
    });
	   //提交编辑
		  $("#user_column_ok_btn").click(function(){
			  $("#updateform").submit();
		  });
	  
	   // 显示删除
	      $("#delete_Account_btn").click(function(){
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
			   
			   $("#delete_Account").fadeIn(100);
			   
			   $("#delUserId").val(c[0]);
          
        });
	   
        //  提交删除
	      
	      $("#delete_Account_ok_btn").click(function(){
			  $("#delfrom").submit();
		  });
        
        $("#ac_Account_ok_btn").click(function(){
        	
        
        	$("#levform").submit();
        })
        
        
        //显示授权管理
         $("#ac_Account_btn").click(function(){
         
        	 var  ids=document.getElementsByName("ids");
  		   var  c=new Array();
  		   for(var i=0;i<ids.length;i++){
  			   if(ids[i].checked==true){
  				   c.push(ids[i].value);
  			   }
  		   }
  		   
  		   if(c.length>1){
  			   alert("你选的太多了，请选择一条记录");
  			   return;
  		   }
            
  		   if(c.length==0){
  			   alert("请选择你要授权的用户");
  			   return;
  		   }
  		   
  		     $("#ac_user_id").val(c[0]);
        	 
        	 $("#ac_Account").fadeIn(100);
    })
        
  })
</script>
</html>