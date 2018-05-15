<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
	<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>
    <c:set var="title" value="${address.id == null ? '添加客户' : '修改客户'}"></c:set> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${title}</title>
</head>
<body>
			<form action="" method="post">
						     收货人:<input type="text" name="relname">
						   所在地区:<input type="text" name="area">
						 街道地址:<input type="text" name="address">
						     邮编:<input type="text" name="postCode">
						     电话/手机:<input type="text" name="phone">
						 
						     <button type="submit">提交</button>
			   
			</form>
</body>
</html>