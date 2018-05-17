<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
           <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改客户</title>
</head>
<body>
    	
		<form:form method="post" action="${contextPath }/vipAddress/${a.id}" commandName="a">
   <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
   <div class="address" style="display: block;">
    <div class="addList">
     <label><span class="red">* </span>选择地区:</label>
     	
    	<!--itemValue:option里的value值  -->
			     <form:select path="id" itemLabel="province" items="${provinces}" itemValue="id">
					    
			     </form:select>
			     <form:select path="id" itemLabel="city" items="${provinces}" itemValue="id">
					     
			     </form:select>
			     <form:select path="id" itemLabel="area" items="${provinces}" itemValue="id">
					    
			     </form:select>
    </div>
    <div class="addList">
     <label><span class="red">* </span>详细地址:</label>
     <form:input type="text" path="address"/>
    </div>
    <div class="addList">
     <label><span class="red">* </span>邮政编码:</label>
     <form:input type="text" path="postCode" />
    </div>
    <div class="addList">
     <label><span class="red">* </span>收件人:</label>
     <form:input type="text" path="arelname" />
    </div>
    <div class="addList">
     <label><span class="red">* </span>手机号码:</label>
     <form:input type="text" path="aphone"/> 或者固定电话 <input type="text">
    </div>
    <div class="addList2">
     <input name="" value=" 确 认 " type="submit" class="submit" onclick="action1">
    </div>
   </div></form:form>
</body>
</html>